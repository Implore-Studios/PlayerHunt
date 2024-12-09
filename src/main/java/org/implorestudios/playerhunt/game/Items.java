package org.implorestudios.playerhunt.game;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.implorestudios.playerhunt.PlayerHuntPlugin;


public class Items {
    public static ItemStack getCompass() {
        PlayerHuntPlugin plugin = PlayerHuntPlugin.getPlugin(PlayerHuntPlugin.class);
        ItemStack compass = new ItemStack(Material.COMPASS, 1);
        ItemMeta meta = compass.getItemMeta();
        assert meta != null;
        if(plugin.getMainConfig().getBoolean("compass.showEnchanted")) {
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        String name = plugin.getMainConfig().getString("compass.name");
        meta.displayName(PlayerHuntPlugin.mmString(name));
        meta.lore(
                plugin
                        .getMainConfig()
                        .getStringList("compass.lore")
                        .stream().map(PlayerHuntPlugin::mmString)
                        .toList()
        );
        compass.setItemMeta(meta);
        return compass;
    }
}
