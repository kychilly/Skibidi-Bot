package com.Discord.DiscordBot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class skibidiCommand {

    public static void execute(SlashCommandInteractionEvent event) {
        event.reply("https://tenor.com/view/skibidi-toilet-skibiditoilet-gif-7150341904622937028").queue();
    }

}
