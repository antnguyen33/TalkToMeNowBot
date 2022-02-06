package com.github.antnguyen33.hackvioletbot;

import java.awt.Color;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.interaction.MessageComponentInteraction;

/**
 * Main method for TalkToMeNow Discord Bot using Javacord API for discord as a
 * competition submission for HackViolet2022.
 * 
 * @author Anthony Nguyen (anthonyn33@vt.edu)
 * @author Brian Lee (brianl03@vt.edu)
 * @author Preston Pitzer
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
        String token = "Place your own Discord token here";

        // Loads TalkToMeNow bot into given Discord server
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Methods/Commands
        // These commands are all proceeded by '!' and must be sent alone to be
        // recognized by the bot's listeners
        // TODO looking to implement object listener instead of message listener

        // Embedded text object holding list of all bot commands and
        // descriptions
        EmbedBuilder commands = new EmbedBuilder().setDescription(
            "List of Commands").setAuthor("TalkToMeBot").addField(
                "Hi! How can I help you?",
                "!talk or !talkmenu - Offers support resources for multiple difficulties\n"
                    + "!vtresources - Available resources at Virginia Tech\n"
                    + "!music - Links a YouTube playlist of relaxing music\n"
                    + "!calm - Links raining audio to help you sleep and relax\n"
                    + "!cats - Links a funny cat video on YouTube\n"
                    + "!games - Play a random online game").setColor(
                        Color.WHITE);

        // Embedded text object holding resources offered at Virginia Tech
        EmbedBuilder resources = new EmbedBuilder().setTitle(
            "Resources at Virginia Tech").setDescription(
                "List of helpful numbers and people to contact").setAuthor(
                    "TalkToMeBot").addField("Contact",
                        " - Women's Center at Virginia Tech: 540-231-7806\r\n"
                            + " - Women's Resource Center of the New River Valley: 540-639-1123\r\n"
                            + " - Katie Polidoro: Title IX Coordinator: 540-231-1824\r\n"
                            + " - Cook Counseling Center: 540-231-6557\r\n"
                            + " - Dean of Students Office: 540-231-3787\r\n"
                            + " - Virginia Tech Police Department: 540-382-4343")
            .setColor(Color.ORANGE);

        // Embedded text objected with mental health resources categorized into
        // commands
        EmbedBuilder talk = new EmbedBuilder().setTitle("!talk command")
            .setDescription("What are you dealing with?").setAuthor(
                "TalkToMeBot").addField("Commands",
                    "!anxiety - Links to managing anxiety\n"
                        + "!bullying - Links to bullying and cyberbullying resources\n"
                        + "!depression - Links to depression resources and contacts\n"
                        + "!assault - Links to assault resources\n"
                        + "!suicide - Links to suicide prevention resources\n"
                        + "!vtresources - Resources at Virginia Tech").setColor(
                            Color.WHITE);

        // Embedded text object holding resources related to anxiety
        EmbedBuilder anxiety = new EmbedBuilder().setTitle("!anxiety command")
            .setDescription("Links to managing anxiety").setAuthor(
                "TalkToMeBot").addField("Definition ",
                    "Anxiety is a feeling of fear, dread, and uneasiness. It might cause you to sweat, feel restless and tense, and have a rapid heartbeat. It can be a normal reaction to stress. For example, you might feel anxious when faced with a difficult problem at work, before taking a test, or before making an important decision.")
            .addInlineField("Links",
                "https://www.verywellmind.com/manage-your-anxiety-2584184\n"
                    + "https://adaa.org/tips\n").setColor(Color.RED);

        // Embedded text object holding resources related to bullying
        EmbedBuilder bully = new EmbedBuilder().setTitle("!bullying command")
            .setDescription("Links to bullying and cyberbullying resources")
            .setAuthor("TalkToMeBot").addField("Definition",
                "Bullying is a form of aggressive behavior in which someone intentionally and repeatedly causes another person injury or discomfort. Bullying can take the form of physical contact, words or more subtle actions.")
            .addInlineField("Links",
                "https://www.girlshealth.gov/bullying/school/index.html\n"
                    + "https://www.cdc.gov/violenceprevention/pdf/bullying-factsheet508.pdf\n")
            .setColor(Color.RED);

        // Embedded text object holding resources related to depression
        EmbedBuilder depression = new EmbedBuilder().setTitle(
            "!depression command").setDescription(
                "Links to depression resources and contacts").setAuthor(
                    "TalkToMeBot").addField("Definition",
                        "Depression (major depressive disorder or clinical depression) is a common but serious mood disorder. It causes severe symptoms that affect how you feel, think, and handle daily activities, such as sleeping, eating, or working. To be diagnosed with depression, the symptoms must be present for at least two weeks.")
            .addInlineField("Links",
                "https://www.counseling.org/knowledge-center/mental-health-resources/depression\n"
                    + "https://www.depression.org/bouldering-indoor-rock-climbing-as-group-therapy-treatment-for-depression")
            .setColor(Color.RED);

        // Embedded text object holding resources related to assault
        EmbedBuilder assault = new EmbedBuilder().setTitle("!assault command")
            .setDescription("Links to managing anxiety").setAuthor(
                "TalkToMeBot").addField("Definition",
                    "An assault is the act of inflicting physical harm or unwanted physical contact upon a person or, in some specific legal definitions, a threat or attempt to commit such an action.")
            .addInlineField("Links", "https://www.rainn.org/\n"
                + "https://www.psychologytoday.com/us/blog/trauma-and-hope/201704/overcoming-sexual-assault-symptoms-recovery\n")
            .setColor(Color.RED);

        // Embedded text object holding resources related to suicide
        EmbedBuilder suicide = new EmbedBuilder().setTitle("!suicide command")
            .setDescription("Links to suicide prevention resources").setAuthor(
                "TalkToMeBot").addField("Definition",
                    "Suicide is death caused by injuring oneself with the intent to die. A suicide attempt is when someone harms themselves with any intent to end their life, but they do not die as a result of their actions.")
            .addInlineField("Links & important phone numbers",
                "https://www.nimh.nih.gov/health/topics/suicide-prevention\n"
                    + "Suicide Prevention Hotline: 1(800) 273 TALK \n")
            .setColor(Color.RED);

        // Embedded text object holding YouTube link to easy listening music
        EmbedBuilder music = new EmbedBuilder().setTitle("!music command")
            .setDescription("Fun music to listen and destress").setAuthor(
                "TalkToMeBot").addField(
                    "Here's some easy listening to relax to:",
                    "https://www.youtube.com/watch?v=IcFDcXfvWsQ").setColor(
                        Color.GREEN);

        // Embedded text object holding YouTube link to rain audio
        EmbedBuilder calm = new EmbedBuilder().setTitle("!calm command")
            .setDescription("Calming rain sounds to help you relax/sleep")
            .setAuthor("TalkToMeBot").addField("Rain sounds:",
                "https://www.youtube.com/watch?v=jX6kn9_U8qk").setColor(
                    Color.GREEN);

        // Embedded text object holding a YouTube search result page of cat
        // videos
        EmbedBuilder cats = new EmbedBuilder().setTitle("!cats command")
            .setDescription("Links to funny cat videos").setAuthor(
                "TalkToMeBot").addField("Find fun cat videos:",
                    "https://www.youtube.com/results?search_query=funny+cat+videos")
            .setColor(Color.GREEN);

        // Listener for !anxiety command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!anxiety")) {
                event.getChannel().sendMessage(anxiety);
            }
        });

        // Listener for !help command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!help")) {
                event.getChannel().sendMessage(commands);
            }
        });

        // Listener for !talk command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!talk")) {
                event.getChannel().sendMessage(talk);
            }
        });

        // Listener for !bullying command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!bullying")) {
                event.getChannel().sendMessage(bully);
            }
        });

        // Listener for !depression command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!depression")) {
                event.getChannel().sendMessage(depression);
            }
        });

        // Listener for !assault command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!assault")) {
                event.getChannel().sendMessage(assault);
            }
        });

        // Listener for !suicide command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!suicide")) {
                event.getChannel().sendMessage(suicide);
            }
        });

        // Listener for !vtresources command
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!vtresources")) {
                event.getChannel().sendMessage(resources);
            }
        });

        // Listener for !music
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!music")) {
                event.getChannel().sendMessage(music);
            }
        });

        // Listener for !calm
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!calm")) {
                event.getChannel().sendMessage(calm);
            }
        });

        // Listener for !cats
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!cats")) {
                event.getChannel().sendMessage(cats);
            }
        });

        // Listener for !talkmenu
        // !talkmenu - creates embedded prompt with buttons for user to select
        // what type of mental health resources they need
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!talkmenu")) {
                new MessageBuilder().setContent(
                    "What are you dealing with right now?").addComponents(
                        ActionRow.of(Button.primary("anxiety1",
                            "Anxiety/Stress"), Button.primary("bully1",
                                "Bullying"), Button.primary("depression1",
                                    "Depression"), Button.primary("assault1",
                                        "Assault"), Button.primary("suicide1",
                                            "Suicidal Thoughts"))).send(event
                                                .getChannel());
            }
        });

        // Switch component for !talkmenu buttons
        // Each case corresponds to each button with resources related to the
        // matching mental health issue
        api.addMessageComponentCreateListener(event -> {
            MessageComponentInteraction messageComponentInteraction = event
                .getMessageComponentInteraction();
            String customId = messageComponentInteraction.getCustomId();

            switch (customId) {
                case "anxiety1":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent(
                            "https://www.counseling.org/knowledge-center/mental-health-resources/depression\r\n\n"
                                + "https://www.depression.org/bouldering-indoor-rock-climbing-as-group-therapy-treatment-for-depression")
                        .respond();
                    break;
                case "bully1":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("https://www.rainn.org/\r\n\n"
                            + "https://www.psychologytoday.com/us/blog/trauma-and-hope/201704/overcoming-sexual-assault-symptoms-recovery\r\n\n"
                            + "800.656.HOPE (24/7 Hotline)").respond();
                    break;
                case "depression1":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("https://adaa.org/tips\r\n\n"
                            + "https://www.verywellmind.com/manage-your-anxiety-2584184")
                        .respond();
                    break;
                case "assault1":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent(
                            "https://www.cdc.gov/violenceprevention/pdf/bullying-factsheet508.pdf\r\n\n"
                                + "https://www.girlshealth.gov/bullying/school/index.html")
                        .respond();
                    break;
                case "suicide1":
                    messageComponentInteraction.createImmediateResponder()
                        .setContent("1(800) 273 TALK\n"
                            + "https://www.nimh.nih.gov/health/topics/suicide-prevention")
                        .respond();
                    break;
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
