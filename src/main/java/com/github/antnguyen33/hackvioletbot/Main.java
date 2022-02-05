package com.github.antnguyen33.hackvioletbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.interaction.MessageComponentInteraction;

/**
 * Main method for TalkToMeNow Discord Bot using Javacord API for discord as a
 * competition submission for HackViolet2022.
 * 
 * @author Anthony Nguyen (anthonyn33@vt.edu)
 * @author Brian Lee
 * @author Preston Pfitzer
 * 
 * @version 2022.2.5
 */
public class Main {

    /**
     * Main method that starts TalkToMeNowBot
     * 
     * @param args
     *            No args are used in this program but can be used to implement
     *            token input.
     */
    public static void main(String[] args) {
        // Insert your Discord account's development token
        String token = "placeholderToken";

        // Loads TalkToMeNow bot into given Discord server
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Methods/Commands
        // These commands are all proceeded by '!' and must be sent alone to be
        // recognized by the bot's listeners
        // TODO looking to implement object listener instead of message listener

        // Listener for !talk command
        // !talk - starts user-bot interaction by giving list of available
        // commands and their descriptions
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!talk")) {
                event.getChannel().sendMessage("Hi! How can I help you?\n"
                    + "!help - Offers support resources for multiple difficulties\n"
                    + "!vtresouces - Available resources at Virginia Tech"
                    + "!music - Links a YouTUbe playlist of relaxing music\n"
                    + "!rain - Links raining audio to help you sleep\n"
                    + "!cats - Links a funny cat video on YouTube\n"
                    + "!games - Play a random online game");
            }
        });

        // Listener for !vtresources command
        // !vtresources - Displays available support resources offered by
        // Virginia Tech
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

        // Listener for !help command
        // !help - Prompts user with a button interface to choose from multiple
        // issues (e.g. depression, anxiety, etc.)
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!help")) {
                new MessageBuilder().setContent(
                    "What are you dealing with right now?").addComponents(
                        ActionRow.of(Button.primary("anxiety",
                            "Anxiety/Stress"), Button.primary("bully",
                                "Bullying"), Button.primary("depression",
                                    "Depression"), Button.primary("assault",
                                        "Assault"), Button.primary("suicide",
                                            "Suicidal Thoughts"))).send(event
                                                .getChannel());
            }
        });

        // Switch cases for each button from !help prompt
        // Each case provides links and phone numbers for users to contact
        api.addMessageComponentCreateListener(event -> {
            MessageComponentInteraction messageComponentInteraction = event
                .getMessageComponentInteraction();
            String customId = messageComponentInteraction.getCustomId();

            switch (customId) {
                case "anxiety":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("1").respond();
                    break;
                case "bully":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("2").respond();
                    break;
                case "depression":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("3").respond();
                    break;
                case "assault":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("4").respond();
                    break;
                case "suicide":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("5").respond();
                    break;
            }
        });

        // Listener for !music
        // !music - Provides a link to a YouTube music playlist
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!music")) {
                event.getChannel().sendMessage(
                    "Here's some easy listening to relax to:\n"
                        + "https://www.youtube.com/watch?v=IcFDcXfvWsQ");
            }
        });

        // Listener for !rain
        // !rain - Provides a link to a YouTube audio
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!rain")) {
                event.getChannel().sendMessage(
                    "Rain sounds to help you sleep:\n"
                        + "https://www.youtube.com/watch?v=jX6kn9_U8qk");
            }
        });

        // Listener for !cats
        // !cats - Provides link to search results for cat videos on YouTube
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!cats")) {
                event.getChannel().sendMessage("Find fun cat videos:\n"
                    + "https://www.youtube.com/results?search_query=funny+cat+videos");
            }
        });

        // String array of preset links to online browser games
        String[] gameLinks = { "https://puzzles.usatoday.com/",
            "https://tetris.com/play-tetris",
            "https://www.coolmathgames.com/0-car-drawing-game/play",
            "https://www.coolmathgames.com/0-duck-life",
            "https://www.coolmathgames.com/0-idle-breakout",
            "http://orteil.dashnet.org/cookieclicker/",
            "https://www.decisionproblem.com/paperclips/",
            "https://www.coolmathgames.com/0-snake" };

        // Listener for !games
        // !games - Randomly selects and provides a link to a game from the
        // gameLinks array
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!games")) {
                int randomPos = (int)(Math.random() * (gameLinks.length - 1));
                event.getChannel().sendMessage(
                    "Here's an online game to play:\n" + gameLinks[randomPos]);
            }
        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: "
            + api.createBotInvite());
    }
}
