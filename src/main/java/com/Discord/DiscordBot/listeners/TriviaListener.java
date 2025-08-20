package com.Discord.DiscordBot.listeners;

import com.Discord.DiscordBot.StringUtils;
import com.Discord.DiscordBot.commands.TriviaCommand;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.util.concurrent.*;

public class TriviaListener extends ListenerAdapter {

    // Stores active trivia games per channel
    private static final ConcurrentHashMap<Long, TriviaCommand.Question> activeQuestions = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, ScheduledFuture<?>> activeTimers = new ConcurrentHashMap<>();

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void setQuestion(MessageChannel channel, TriviaCommand.Question question) {
        long channelId = channel.getIdLong();
        activeQuestions.put(channelId, question);

        // Cancel old timer
        ScheduledFuture<?> oldTimer = activeTimers.remove(channelId);
        if (oldTimer != null && !oldTimer.isDone()) {
            oldTimer.cancel(true);
        }

        // Schedule timeout
        ScheduledFuture<?> timeoutTask = scheduler.schedule(() -> {
            triggerTimeout(channelId, channel);
        }, 10, TimeUnit.SECONDS);

        activeTimers.put(channelId, timeoutTask);
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        long channelId = event.getChannel().getIdLong();
        TriviaCommand.Question currentQuestion = activeQuestions.get(channelId);

        if (currentQuestion == null) return;

        String message = event.getMessage().getContentRaw().trim();

        if (StringUtils.isCloseMatch(message, currentQuestion.getAnswer())) {
            event.getChannel().sendMessage(
                    "✅ Correct! " + event.getAuthor().getAsMention() +
                            " got it: **" + currentQuestion.getAnswer() + "**"
            ).queue();

            // End this trivia
            activeQuestions.remove(channelId);

            ScheduledFuture<?> timer = activeTimers.remove(channelId);
            if (timer != null && !timer.isDone()) {
                timer.cancel(true);
            }
        }
    }

    // Helper method so TriviaCommand can trigger timeout messages properly
    public static void triggerTimeout(long channelId, MessageChannel channel) {
        TriviaCommand.Question q = activeQuestions.remove(channelId);
        if (q != null) {
            channel.sendMessage("⏰ Time’s up! The correct answer was: **" + q.getAnswer() + "**").queue();
            activeTimers.remove(channelId);
        }
    }
}
