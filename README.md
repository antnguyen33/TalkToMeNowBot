# TalkToMeNowBot
HackViolet2022 Submission

TalkToMeNowBot is a assisted self-help application that provides users with various mental health resources based on prompts given by natural language and/or message buttons.

# Set Up
To use this bot in your own server, set up is a relativly straighfoward process.
1. Be sure you have a Discord account and are logged in.
2. Navigate to Discord Developer Portal located here: https://discord.com/developers/applications. 
3. Click "New Application" button and give the aplication a name.
4. Navigate to the "Bot" tab and click "Add bot", be sure that "Public Bot" is ticked
5. "Require OAuth2 Code Grant" must be ticked in order for the bot to function.
6. Click the "Copy" button under "Token" to get your bot's token.
7. Navigate to TalkToMeNowBot/src/main/java/com/github/antnguyen33/hackvioletbot/Main.java and locate the token field
8. Paste the token into the field. Save and run the file to obtain the bot's URL address 
9. Clicking the URL generated by the bot will allow the bot to be connected to your discord server.

# Commands

TalkToMeNowBot supports a variety of commands.

Common Commands

!help - returns menu with various commands 
!talk or !talkmeny - Offers support resources for multiple difficulties
!vtresources - Available resources at Virginia Tech
!music - Links a YouTube playlist of relaxing music
!calm - Links raining audio to help you sleep
!cats - Links a funny cat video on YouTube
!games - Play a random online game"

Commands within !talk

!anxiety - Links to managing anxiety
!bullying - Links to bullying and cyberbullying resources
!depression - Links to depression resources and contacts
!assault - Links to assault resources
!suicide - Links to suicide prevention resources
