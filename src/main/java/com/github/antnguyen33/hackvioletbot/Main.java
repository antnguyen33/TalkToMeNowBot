package com.github.antnguyen33.hackvioletbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.entity.message.component.SelectMenu;
import org.javacord.api.interaction.MessageComponentInteraction;

public class Main {

    public static void main(String[] args) {
        // Insert your bot's token here
        String token = "antony dumbass";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        
        
        // Add a listener which answers with abuse resources at Virginia Tech when user types !ping
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!vtresources")) {
                event.getChannel().sendMessage(
                    " ``` - Women's Center at Virginia Tech: 540-231-7806\r\n"
                    + " - Women's Resource Center of the New River Valley: 540-639-1123\r\n"
                    + " - Katie Polidoro: Title IX Coordinator: 540-231-1824\r\n"
                    + " - Cook Counseling Center: 540-231-6557\r\n"
                    + " - Dean of Students Office: 540-231-3787\r\n"
                    + " - Virginia Tech Police Department: 540-382-4343! ``` ");
            }
        });
        
        
        
        MessageBuilder mb1 = new MessageBuilder()
        .setContent("How have you been?")
        .addComponents(
            ActionRow.of(Button.primary("good", "I am good today!"),
                Button.primary("bad", "I am not feeling well today.")));
        
        
        MessageBuilder mb2 = new MessageBuilder()
            .setContent("I'm sorry to hear that. Is there anything I can hear you out on?")
            .addComponents(
                ActionRow.of(SelectMenu.create("options", "What's going on?"))
       
        
        
        
        
        
        
        //Add a listener which answer with possible input calls when the user types !help, should be public  
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!help")) {
                mb1.send(event.getChannel());
            }
        });
            
        
        
        api.addMessageComponentCreateListener(event -> {
            MessageComponentInteraction messageComponentInteraction = event.getMessageComponentInteraction();
            String customId = messageComponentInteraction.getCustomId();

            switch (customId) {
                case "good":
                    messageComponentInteraction.createImmediateResponder()
                            .setContent("hyperpoggies")
                            .respond();
                    break;
                case "bad":
                    messageComponentInteraction.createImmediateResponder()
                            .setContent("lol loser")
                            .respond();
                    break;
            }
        });
        
        
        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}
