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
            new Question("Which Titan has speakers on his shoulders?", "Titan Speakerman"),
            new Question("Who is known for hacking Skibidi Toilets?", "Scientist Cameraman"),
            new Question("Which Titan was corrupted by the Skibidi Toilets?", "Titan Speakerman"),
            new Question("Which ally uses a TV head to hypnotize Skibidi Toilets?", "TV Man"),
            new Question("Which Skibidi Toilet type has multiple heads?", "Three-Headed Skibidi Toilet"),
            new Question("What liquid do corrupted characters often leak?", "Glitch goo"),
            new Question("Which Titan carries a massive drill arm?", "Titan Drill Cameraman"),
            new Question("Which Cameramen type are small but fast?", "Mini Cameramen"),
            new Question("Who is the tallest Skibidi enemy?", "Giant Skibidi Toilet"),
            new Question("Which Cameraman faction specializes in shields?", "Shield Cameramen"),
            new Question("Which Titan has a glowing core in his chest?", "Titan Cameraman"),
            new Question("Which group fights alongside the Cameramen and Speakermen?", "TV Men"),
            new Question("What device do the Skibidi Toilets use to infect others?", "Parasite Skibidi"),
            new Question("Which Titan combines strength and sound?", "Titan Speakerman"),
            new Question("Who is the leader of the TV Men?", "Titan TV Man"),
            new Question("Which type of Skibidi Toilet explodes when defeated?", "Explosive Skibidi Toilet"),
            new Question("Which Cameraman can disguise as a Skibidi Toilet?", "Spy Cameraman"),
            new Question("What organ do the Skibidi Toilets usually expose?", "Head"),
            new Question("What power do Titan TV Man’s screens have?", "Mind control"),
            new Question("Which faction is known for upgrading allies with tech?", "Engineer Cameramen"),
            new Question("Which Cameraman type rides on wheels?", "Roller Cameramen"),
            new Question("What is the nickname fans gave to Titan Cameraman?", "G-Man"),
            new Question("Which Cameraman has four arms?", "Multi-Arm Cameraman"),
            new Question("What is the main weakness of Skibidi Toilets?", "Headshots"),
            new Question("Which Cameraman type uses rockets?", "Rocket Cameramen"),
            new Question("What Skibidi Toilet has spider-like legs?", "Spider Skibidi"),
            new Question("Which Titan has huge speakers for hands?", "Titan Speakerman"),
            new Question("Who often rescues injured allies?", "Medic Cameramen"),
            new Question("Which Skibidi form is the most dangerous?", "Giant Skibidi Toilet"),
            new Question("What color glow is often seen in corrupted Titans?", "Purple"),
            new Question("Which Cameraman is known for electricity attacks?", "Electro Cameraman"),
            new Question("Which Cameraman has the ability to cloak?", "Stealth Cameraman"),
            new Question("Who is stronger: Titan TV Man or Titan Speakerman?", "Titan TV Man"),
            new Question("What weapon does the Scientist Cameraman use?", "Hacking device"),
            new Question("Which Cameraman type wears armor plating?", "Heavy Cameramen"),
            new Question("What Titan is often seen smashing the ground?", "Titan Cameraman"),
            new Question("Which Skibidi Toilet can fly?", "Flying Skibidi Toilet"),
            new Question("Which faction created advanced healing pods?", "Engineer Cameramen"),
            new Question("Who has screens for eyes?", "TV Man"),
            new Question("Which Titan has the ability to freeze enemies?", "Frost Cameraman"),

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
