package org.implorestudios.playerhunt.command.playerhunt;

import com.github.sirblobman.api.command.Command;
import com.github.sirblobman.api.language.replacer.IntegerReplacer;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.implorestudios.playerhunt.PlayerHuntPlugin;
import org.implorestudios.playerhunt.game.Game;

import java.util.Collections;
import java.util.List;

public class StartSubcommand extends Command {
    private final PlayerHuntPlugin plugin;
    public StartSubcommand(@NonNull PlayerHuntPlugin plugin) {
        super(plugin, "start");
        this.plugin = plugin;
    }

    @Override
    protected @NonNull List<String> onTabComplete(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        return Collections.emptyList();
    }

    @Override
    protected boolean execute(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        Game game = Game.getInstance();
        if(game.getState() != Game.GameState.NOT_STARTED) {
            sendMessageWithPrefix(commandSender, "commands.start.gameAlreadyStarted");
            return true;
        }
        if(game.getPlayerManager().getHunters().isEmpty() || game.getPlayerManager().getRunners().isEmpty()) {
            sendMessageWithPrefix(commandSender, "commands.start.notEnoughPlayers");
            return true;
        }
        game.init();
        sendMessageWithPrefix(commandSender, "commands.start.starting", new IntegerReplacer("%time%", plugin.getMainConfig().getInt("countdown")));
        return true;
    }
}
