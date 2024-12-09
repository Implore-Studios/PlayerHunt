package org.implorestudios.playerhunt;

import com.github.sirblobman.api.configuration.ConfigurationManager;
import com.github.sirblobman.api.language.LanguageManager;
import com.github.sirblobman.api.language.replacer.Replacer;
import com.github.sirblobman.api.plugin.ConfigurablePlugin;
import com.github.sirblobman.api.shaded.adventure.text.minimessage.MiniMessage;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.implorestudios.playerhunt.command.playerhunt.PlayerhuntCommand;
import org.implorestudios.playerhunt.event.GameEvents;

@Getter
public final class PlayerHuntPlugin extends ConfigurablePlugin {
    public static PlayerHuntPlugin plugin;
    public static Component mmString(String string) {
        String text = MiniMessage.miniMessage().serialize(MiniMessage.miniMessage().deserialize(string));
        return net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(text);
    }
    public static Component mm(CommandSender audience, String key) {
        String text = MiniMessage.miniMessage().serialize(plugin.getLanguageManager().getMessageWithPrefix(audience, key));
        return net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(text);
    }
    public static Component mm(CommandSender audience, String key, Replacer... replacer) {
        String text = MiniMessage.miniMessage().serialize(plugin.getLanguageManager().getMessageWithPrefix(audience, key, replacer));
        return net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(text);
    }
    private YamlConfiguration mainConfig;
    @Override
    public void onLoad() {
        this.loadConfig();
    }

    @Override
    public void onEnable() {
        plugin = this;
        this.loadLanguages();
        this.registerCommands();
        this.registerListeners();
        getLogger().info("PlayerHunt plugin has been enabled.");
    }

    public void reload() {
        this.loadConfig();
        this.loadLanguages();
        this.registerCommands();
        this.registerListeners();
        getLogger().info("PlayerHunt plugin has been reloaded.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlayerHunt plugin has been disabled.");
    }

    private void loadConfig() {
        ConfigurationManager configurationManager = getConfigurationManager();
        configurationManager.saveDefault("config.yml");
        configurationManager.reload("config.yml");
        this.mainConfig = configurationManager.get("config.yml");
        getLogger().info("Configuration loaded");
    }

    private void loadLanguages() {
        LanguageManager languageManager = getLanguageManager();
        languageManager.saveDefaultLanguageFiles();
        languageManager.reloadLanguages();
        languageManager.onPluginEnable();
        getLogger().info("Languages loaded");
    }

    private void registerCommands() {
        new PlayerhuntCommand(this).register();
        getLogger().info("Commands registered");
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new GameEvents(), this);
        getLogger().info("Events registered");
    }
}
