package com.github.antnguyen33.hackvioletbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {

    public static void main(String[] args) {
        // Insert your bot's token here
        String token = "OTM5NTM4MDkzNjY3NjYzOTUy.Yf6TCQ._VtH3hL6wIFErnTiOhoXst8npOY";

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
        //Add a listener which answer with possible input calls when the user types !help, should be public  
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!help")) {
                event.getChannel().sendMessage(
                    " ```Welcome to the TalkToMeNow Bot,a responsive support chat bot \n"
                    +"to interact with me, you can use !talk for a more tailored response \n"
                    +"or I can provide you with a list of general resources if you need help more urgently using !vtresources```");
            }
        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}
