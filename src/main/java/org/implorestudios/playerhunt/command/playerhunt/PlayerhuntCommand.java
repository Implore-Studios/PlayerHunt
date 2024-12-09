package org.implorestudios.playerhunt.command.playerhunt;

import com.github.sirblobman.api.command.Command;
import com.github.sirblobman.api.language.replacer.StringReplacer;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.implorestudios.playerhunt.PlayerHuntPlugin;
import org.implorestudios.playerhunt.command.playerhunt.team.TeamSubcommand;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlayerhuntCommand extends Command {
    public PlayerhuntCommand(@NonNull PlayerHuntPlugin plugin) {
        super(plugin, "playerhunt");
        setPermissionName("playerhunt.command");
        addSubCommand(new StartSubcommand(plugin));
        addSubCommand(new StopSubcommand(plugin));
        addSubCommand(new TeamSubcommand(plugin));
        addSubCommand(new ReloadSubcommand(plugin));
    }
    @Override
    protected @NonNull List<String> onTabComplete(@NonNull CommandSender sender, String @NonNull [] args) {
        return Collections.emptyList();
    }

    @Override
    protected boolean execute(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        Objects.requireNonNull(getLanguageManager()).sendMessage(commandSender, "help-title", new StringReplacer("%command%", "/playerhunt"));
        Objects.requireNonNull(getLanguageManager()).sendMessage(commandSender, "commands.help");
        return true;
    }
}
