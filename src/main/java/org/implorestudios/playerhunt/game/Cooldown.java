package org.implorestudios.playerhunt.game;

import lombok.Getter;
import org.bukkit.scheduler.BukkitRunnable;
import org.implorestudios.playerhunt.PlayerHuntPlugin;

public class Cooldown extends BukkitRunnable {
    @Getter
    private int time;
    public interface Function {
        void run();
    }
    private Function function;
    public void start(PlayerHuntPlugin plugin, int time, Function function) {
        this.time = time;
        this.function = function;
        this.runTaskTimer(plugin, 0L, 20L);
    }
    public void run() {
        if(time == 0) {
            cancel();
            function.run();
        }
        time--;
    }
}
