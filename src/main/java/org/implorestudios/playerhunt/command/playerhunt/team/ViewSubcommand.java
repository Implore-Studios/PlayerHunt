package org.implorestudios.playerhunt.command.playerhunt.team;

import com.github.sirblobman.api.command.Command;
import com.github.sirblobman.api.language.replacer.StringReplacer;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.implorestudios.playerhunt.PlayerHuntPlugin;
import org.implorestudios.playerhunt.game.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewSubcommand extends Command {
    public ViewSubcommand(@NonNull PlayerHuntPlugin plugin) {
        super(plugin, "view");
    }

    @Override
    protected @NonNull List<String> onTabComplete(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        return Collections.emptyList();
    }

    @Override
    protected boolean execute(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        Game game = Game.getInstance();
        ArrayList<Player> hunters = game.getPlayerManager().getHunters();
        ArrayList<Player> runners = game.getPlayerManager().getRunners();
        PlayerHuntPlugin.getPlugin(PlayerHuntPlugin.class).getLanguageManager().sendMessageWithPrefix(commandSender, "commands.team.view", new StringReplacer("%hunters%", String.join(", ", hunters.stream().map(Player::getName).toList())), new StringReplacer("%runners%", String.join(", ", runners.stream().map(Player::getName).toList())));
        return true;
    }
}
