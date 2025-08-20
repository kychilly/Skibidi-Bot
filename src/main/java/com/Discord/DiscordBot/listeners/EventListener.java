package com.Discord.DiscordBot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("skibidi toilet")) {
            sendSigma(event);
            return;
        }

        if (Math.random() < 0.33) {
            // all possible brainrot options
            String[] brainrotOptions = {
                    "skibidi ",
                    "ohio ",
                    "sigma ",
                    "SKEEEEEEEEEBIDIDIID",
                    "gyatttt ",
                    "sigma sigma on the wall ",
                    Objects.requireNonNull(event.getMember()).getAsMention() + " CALLATE "
            };

            int index = (int)(Math.random() * brainrotOptions.length);
            String chosen = brainrotOptions[index];

            StringBuilder builder = new StringBuilder();
            for (int p = 0; p < (int)(Math.random() * 6) + 2; p++) {
                builder.append(chosen);
            }
            String sendBrainrot = builder.toString();

            event.getChannel().sendMessage(sendBrainrot).queue();

            event.getAuthor()
                    .openPrivateChannel()
                    .queue(privateChannel -> {
                        privateChannel.sendMessage(sendBrainrot).queue();
                        privateChannel.sendMessage("https://tenor.com/view/skibidi-toilet-skibiditoilet-gif-7150341904622937028").queue();
                    }, failure -> {
                        System.out.println("Could not DM " + event.getAuthor().getAsTag());
                    });

            event.getChannel()
                    .sendMessage("https://tenor.com/view/skibidi-toilet-skibiditoilet-gif-7150341904622937028") // replace with real gif
                    .queue();
        }


        if (message.contains("skibidi")) {
            sendBrainrot(event, "skibidi ");
        }
        if (message.contains("ohio")) {
            sendBrainrot(event, "ohio ");
        }
        if (message.contains("sigma")) {
            sendBrainrot(event, "sigma ");
        }
        if (message.contains("rizz")) {
            sendBrainrot(event, "SKEEEEEEEEEBIDIDIID");
        }
        if (message.contains("gyatt")) {
            sendBrainrot(event, "gyatttt ");
        }
        if (message.contains("callate")) {
            sendBrainrot(event, "sigma sigma on the wall ");
        }
        if (message.contains("repuesta")) {
            sendBrainrot(event, Objects.requireNonNull(event.getMember()).getAsMention() + " CALLATE ");
        }
    }

    public void sendBrainrot(MessageReceivedEvent event, String s) {
        for (int i = 0; i < (int)(Math.random()*6) + 4; i++) {
            StringBuilder builder = new StringBuilder();
            for (int p = 1; p < (int)(Math.random()*6)+2; p++) {
                builder.append(s);
            }
            try {
                event.getChannel().sendMessage(builder.toString()).queue();
                builder.setLength(0);
                Thread.sleep(200);
            } catch (Exception e) {
                event.getChannel().sendMessage("MY TOILET ISNT FLUSHING PROPERLY, I NEED A CAMERAMAN TO FIX ME").queue();
                return;
            }
        }
    }

    public void sendSigma(MessageReceivedEvent event) {
        event.getChannel().sendMessage("To the sigmas of Australia, I say that this goofy ahh government have been capping, not just now but for a long time. A few of you may remember when they said \"there'll be no Fanum Tax under the government I lead\". They're cappaholics! They're also yappaholics! They yap non-stop about how their cost of living measures are changing lives for all Australians. Just put the fries in the bag, lil bro. They tell us that they're \"locked in\" on improving the housing situation in this country. They must have brainrot from watching too much Kai Cenat and forgot about their plans to ban social media for kids under 14. If that becomes law, you can forgor \uD83D\uDC80 all about watching Duke Dennis or catching a dub with the bros on Fort. Chat, is this Prime Minister serious? Even though he's the Prime Minister of Australia, sometimes it feels like he's the CEO of Ohio! I would be taking an L if I did not mention the opps who want to cut WA's Gyatts and Services Tax. The decision voters will be making in a few months time will be between a mid government, a dogwater opposition, or a crossbench that will mog both of them. Though some of you cannot yet vote, I hope when you do, it will be in a more goated Australia for a government with more aura. Skibidi!").queue();
    }
}
