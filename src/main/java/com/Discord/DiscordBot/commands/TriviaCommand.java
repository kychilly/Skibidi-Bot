package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.listeners.TriviaListener;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import java.util.*;

public class TriviaCommand {


    private static final List<Question> QUESTIONS = Arrays.asList(
            new Question("Who created the Skibidi Toilet series?", "DaFuq!?Boom!"),
            new Question("What year did the Skibidi Toilet series first appear?", "2023"),
            new Question("What is the main enemy of the Skibidi Toilets?", "Cameramen"),
            new Question("Which faction is known for using speaker heads?", "Speakermen"),
            new Question("Which meme song is used heavily in Skibidi Toilet?", "Dom Dom Yes Yes"),
            new Question("What body part sticks out of the Skibidi Toilets?", "Head"),
            new Question("Which YouTube Shorts format helped Skibidi Toilet blow up?", "Shorts"),
            new Question("Who helps the Cameramen against the Toilets?", "Speakermen"),
            new Question("Which Skibidi creature has a large TV for a head?", "TV Man"),
            new Question("What do the Skibidi Toilets shout repeatedly?", "Skibidi"),
            new Question("Which Cameraman type uses jetpacks?", "Flying Cameramen"),
            new Question("Who is the biggest Cameraman leader?", "Titan Cameraman"),
            new Question("Which Titan has a large screen on his chest?", "Titan TV Man"),
            new Question("What platform is Skibidi Toilet most popular on?", "YouTube"),
            new Question("What do the Skibidi Toilets use to move around?", "Toilets"),
            new Question("Which Cameraman has powerful laser eyes?", "Titan Cameraman"),
            new Question("Who is stronger: Titan Cameraman or Titan Speakerman?", "Titan Cameraman"),
            new Question("Which faction is often seen repairing allies?", "Engineer Cameramen"),
            new Question("What type of heads do the enemies of the Toilets have?", "Camera"),
            new Question("What is the main genre of Skibidi Toilet?", "Surreal comedy")
    );

    private static final Random RANDOM = new Random();

    public static void execute(SlashCommandInteractionEvent event) {
        Question q = QUESTIONS.get(RANDOM.nextInt(QUESTIONS.size()));
        event.reply("Trivia Time! " + q.getQuestion()).queue();
        TriviaListener.setQuestion(event.getChannel(), q);

    }

    public static class Question {
        private final String question;
        private final String answer;

        public Question(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() { return question; }
        public String getAnswer() { return answer; }
    }
}
