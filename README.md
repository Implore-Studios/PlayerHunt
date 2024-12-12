# PlayerHunt

PlayerHunt is an engaging Minecraft plugin that allows players to engage in a thrilling hunt game. Hunters must track down and eliminate runners, while runners must avoid hunters and try to defeat the Ender Dragon to win the game.

## Features
- **Team Management:** Add and manage players in hunter and runner teams.
- **Compass for Hunters:** Hunters receive a compass that points to the nearest runner.
- **Countdown Timer:** A configurable countdown timer before the game starts.
- **Language Support:** Customizable language messages to tailor the game experience.

## Commands

### /playerhunt
The main command to manage the PlayerHunt game. Subcommands include:
- **/playerhunt start:** Starts the game with a countdown timer.
- **/playerhunt stop:** Stops the game immediately.
- **/playerhunt reload:** Reloads the plugin configuration and language files.
- **/playerhunt team:** Manages team-related actions.

### /playerhunt team
Subcommands for team management:
- **/playerhunt team add hunter <username>:** Adds a player to the hunter team.
- **/playerhunt team add runner <username>:** Adds a player to the runner team.
- **/playerhunt team remove <username>:** Removes a player from the game.
- **/playerhunt team view:** Views the current teams.
- **/playerhunt team clear:** Clears all players from the game.
- **/playerhunt team last:** Sets the game players to the last game's players.

## Configuration
The plugin uses a `config.yml` file to manage settings. Key configuration options include:
- **countdown:** The countdown time before the game starts.
- **compass:** Settings related to the hunter's compass, including cooldown and display options.

## Language
Customizable messages are stored in `en_us.lang.yml`. Key messages include:
- **deathMessages:** Messages for player deaths, differentiated by whether they are hunters or runners.
- **commands:** Messages for various plugin commands.
- **countdown:** Messages shown during the countdown before the game starts.
- **titles:** Titles displayed to players at key points in the game.