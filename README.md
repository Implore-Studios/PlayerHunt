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
- **/playerhunt team:** Manages team-related actions. <br> <br>
  <img src="https://github.com/user-attachments/assets/2073c988-63c5-400f-a07b-dd02dc394ec5"/> 


### /playerhunt team
Subcommands for team management:
- **/playerhunt team add hunter <username>:** Adds a player to the hunter team.
- **/playerhunt team add runner <username>:** Adds a player to the runner team.
- **/playerhunt team remove <username>:** Removes a player from the game.
- **/playerhunt team view:** Views the current teams.
- **/playerhunt team clear:** Clears all players from the game.
- **/playerhunt team last:** Sets the game players to the last game's players. <br> <br>
  <img src="https://github.com/user-attachments/assets/c8289b99-6076-4959-82a6-8bf3af9ebef0"/>


## Configuration
The plugin uses a `config.yml` file to manage settings. Key configuration options include:
- **countdown:** The countdown time before the game starts.
- **compass:** Settings related to the hunter's compass, including cooldown and display options.
<details>
  <summary><code>config.yml</code></summary>
  
```yml
 # Countdown to game start in seconds
countdown: 20
# Whether the plugin should use a custom tablist when the game is progressing.
enableTablist: true
compass:
  enabled: true
  # Seconds for which the player can't use the compass after using it once
  cooldown: 10
  name: '<reset><dark_purple><b>Runner Compass</b> <gray>(Right-Click)'
  lore:
    - '<aqua>Shows you the direction to the nearest runner.'
    - '<gray><i>Right-click to update direction'
  droppable: false
  showEnchanted: true
deathMessages:
  enableRunner: true
  enableHunter: true
```
</details>

## Language
Customizable messages are stored in `en_us.lang.yml`. Key messages include:
- **deathMessages:** Messages for player deaths, differentiated by whether they are hunters or runners.
- **commands:** Messages for various plugin commands.
- **countdown:** Messages shown during the countdown before the game starts.
- **titles:** Titles displayed to players at key points in the game.
<details>
  <summary><code>en_us.lang.yml</code></summary>
  
```yml
# Prefix which will be shown before all the messages.
prefix: "<gold>PlayerHunt <gray>»<white>"

deathMessages:
  # Runner dies, but not to a hunter (e.g., fall damage, killed by other players not included in the game, etc.). PlaceholderAPI parsed for runner
  runnerDied: "<green>Runner <aqua>%player%</aqua> has died! There are <aqua>%runners%</aqua> runners left."
  # A hunter kills runner. PlaceholderAPI parsed for runner
  runnerKilled: "<green>Runner <aqua>%runner%</aqua> has been killed by the hunter <aqua>%hunter%</aqua>. There are <aqua>%runners%</aqua> runners left."
  # Hunter dies to anything that is not a player
  hunterDied: "<green>Hunter <aqua>%hunter%</aqua> has died!"
  # Hunter dies to a runner
  hunterKilled: "<green>Hunter <aqua>%hunter%</aqua> has been killed by the runner <aqua>%runner%</aqua>"
helpHeader: "<gold>Help: <b>%command%"
commands:
  # /playerhunt reload
  reload: "<green>Configurations and languages reloaded."
  # /playerhunt start
  start:
    # Player executes the command
    starting: "<green>Countdown has been initiated and the game will start in <aqua>%time%s</aqua>."
    # There are not enough players (one hunter and one runner) to start the game
    notEnoughPlayers: "<red>Not enough players to start a player hunt."
    # Player tries to execute this command while a game is already running
    gameAlreadyStarted: "<red>Game already started. If you want to stop it, you can use <aqua>/playerhunt stop</aqua>."
  # /playerhunt stop
  stop:
    # Player forcefully stops the game by using this command
    # Note: This message will be sent instead of game-end.message in case the stop command was used.
    gameStopped: "<red>The game was forcefully stopped."
    # Player tries to execute this command while a game isn't already running
    gameNotStarted: "<red>Game not started. If you want to start it, you can use <aqua>/playerhunt start</aqua>."
  # /playerhunt add
  add:
    hunter: "<green>Added <aqua>%player%</aqua> as <aqua>hunter</aqua>."
    runner: "<green>Added <aqua>%player%</aqua> as <aqua>runner</aqua>."
    # Player tries to add an offline player
    notFound: "<red>A player with that name is not online!"
    # Player tries to add a player that already is in a team
    alreadyInTeam: "<red>The player is already in a team! Remove the player using <aqua>/playerhunt remove</aqua>."
    # /playerhunt add [hunter/runner]
    help: |-
      <yellow>/playerhunt team add hunter <gold><username> <gray>- <white>Add a player to the hunter team
      <yellow>/playerhunt team add runner <gold><username> <gray>- <white>Add a player to the runner team
  # /playerhunt team
  team:
    # /playerhunt team view
    view: |-
      <green><i>Hunters:</i>
                  <white>%hunters%
      <red><i>Runners:</i>
                  <white>%runners%
    # /playerhunt team remove
    remove:
      success: "<green>Removed <aqua>%player%</aqua> from the game."
      # Player tries to remove an offline player
      notFound: "<red>A player with that name is not online!"
      # Player tries to remove while the countdown is progressing
      inCountdown: "<red>You can't remove players during countdown!"
      help: "<yellow>/playerhunt team remove <gold><username> <gray>- <white>Remove a player from the game"
    # /playerhunt team clear
    clear: "<green>Cleared all players from game."
    # /playerhunt team last
    last: "<green>Set game players to the last game's players."
    # /playerhunt team
    help: |-
      <yellow>/playerhunt team add hunter <gold><username> <gray>- <white>Add a player to the hunter team
      <yellow>/playerhunt team add runner <gold><username> <gray>- <white>Add a player to the runner team
      
      <yellow>/playerhunt team remove <gold><username> <gray>- <white>Remove a player from the game
      
      <yellow>/playerhunt team last <gray>- <white>Set current team to players from previous game
      <yellow>/playerhunt team clear <gray>- <white>Remove all players
      <yellow>/playerhunt team view <gray>- <white>See the current teams
  help: |-
    <yellow>/playerhunt team <gray>- <white>Commands to manage teams (add or remove players)
    <yellow>/playerhunt start <gray>- <white>Start the game
    <yellow>/playerhunt stop <gray>- <white>Stop the game
    
    <yellow>/playerhunt reload <gray>- <white>Reload configuration and languages
countdown:
  # Countdown to the start of the game in chat
  message: "<green>Game starts in <aqua>%time%s</aqua>..."
titles:
  # 1; To disable any titles, remove their title and subtitle
  # 2; fade-in, stay, and fade-out are in ticks (20 ticks = 1 second)

  # Title to show as countdown
  countdown:
    title: "<dark_green>%time%"
    subtitle: "<gray>seconds left"
    fade-in: 3
    stay: 20
    fade-out: 3
  gameStarted:
    title: "<gold>Player Hunt Started!"
    subtitle: "<gray>You are a <b>%team%</b>."
    fade-in: 10
    stay: 80
    fade-out: 10
  gameEnded:
    title: "<gold>Player Hunt Ended!"
    subtitle: "<gray>The winner team was <b>%team%</b>."
  gameEndedAbrupt:
    title: "<gold>Player Hunt Ended!"
    subtitle: "<gray>The game was forcefully ended."
compass:
  # 1; type can be ACTION_BAR, CHAT, and anything else.
  #    ACTION_BAR: Message shows up in action bar
  #    CHAT: Message shows up in chat
  #    Something else: Disables the message

  # Player tries to interact with compass, but there are no runners in their world
  noRunners:
    type: ACTION_BAR
    content: "<red>There are no runners in your current world."
  # The compass is in cooldown
  cooldownMessage:
    type: ACTION_BAR
    content: "<red>Compass in cooldown! Cannot use for <aqua>%time%s</aqua>."
  # The Compass is successfully used, and the direction updated
  message:
    type: ACTION_BAR
    content: "<green>X: <aqua>%x%</aqua>, <green>Z: <aqua>%z%</aqua>"
gameStarted: |-
  
  <gold><st>                       </st><b>Player Hunt</b><st>                       </st></gold>
  
       <green><i>Hunters:</i>
           <white>%hunters%</white>
       <red><i>Runners:</i></red>
           <white>%runners%</white>
  
  
  Hunters have to try to kill the runners as fast as possible,
            while the runners try their best to
      win the game by defeating the Ender Dragon.
gameEnded: |-
  <green>The player hunt game has ended. The <aqua>%team%</aqua> have won!
  
       <green><i>Winners:</i>
           <white>%winners%</white>
       <red><i>Losers:</i></red>
           <white>%losers%</white>
```
</details>
