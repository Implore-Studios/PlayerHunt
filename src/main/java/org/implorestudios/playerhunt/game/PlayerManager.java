package org.implorestudios.playerhunt.game;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlayerManager {
    private static PlayerManager instance;
    public static synchronized PlayerManager getInstance() {
        if(instance == null) {
            instance = new PlayerManager();
        }
        return instance;
    }
    @Setter
    private ArrayList<Player> startingHunters = new ArrayList<>();
    @Setter
    private ArrayList<Player> startingRunners = new ArrayList<>();
    @Getter
    private ArrayList<Player> hunters = new ArrayList<>();
    @Getter
    private ArrayList<Player> runners = new ArrayList<>();
    @Getter
    private ArrayList<Player> players = new ArrayList<>();
    public void addHunter(Player player) {
        if(!player.isOnline()) return;
        if(isHunter(player)) return;
        hunters.add(player);
        players.add(player);
    }
    public void addRunner(Player player) {
        if(!player.isOnline()) return;
        if(isRunner(player)) return;
        runners.add(player);
        players.add(player);
    }
    private void removeHunter(Player player) {
        Game game = Game.getInstance();
        if(game.getState() == Game.GameState.COUNTDOWN) return;
        hunters.remove(player);
        players.remove(player);
        endGame();
    }
    private void removeRunner(Player player) {
        Game game = Game.getInstance();
        if(game.getState() == Game.GameState.COUNTDOWN) return;
        runners.remove(player);
        players.remove(player);
        endGame();
    }
    public void removePlayer(Player player) {
        Game game = Game.getInstance();
        if(game.getState() == Game.GameState.COUNTDOWN) return;
        this.removeHunter(player);
        this.removeRunner(player);
        players.remove(player);
        endGame();
    }
    public boolean isHunter(Player player) {
        return hunters.contains(player);
    }
    public boolean isRunner(Player player) {
        return runners.contains(player);
    }
    public boolean isPlayer(Player player) {
        return players.contains(player);
    }
    public void setLastPlayers() {
        this.removeOfflinePlayers();
        this.runners = this.startingRunners;
        this.hunters = this.startingHunters;
        ArrayList<Player> p = new ArrayList<>();
        p.addAll(this.startingRunners);
        p.addAll(this.startingHunters);
        this.players = p;
        endGame();
    }
    public void setStartingPlayers() {
        this.removeOfflinePlayers();
        this.startingRunners = this.runners;
        this.startingHunters = this.hunters;
    }
    public void removeOfflinePlayers() {
        this.startingRunners = new ArrayList<>(this.startingRunners.stream().filter(OfflinePlayer::isOnline).toList());
        this.startingHunters = new ArrayList<>(this.startingHunters.stream().filter(OfflinePlayer::isOnline).toList());
        this.runners = new ArrayList<>(this.runners.stream().filter(OfflinePlayer::isOnline).toList());
        this.hunters = new ArrayList<>(this.hunters.stream().filter(OfflinePlayer::isOnline).toList());
        this.players = new ArrayList<>(this.players.stream().filter(OfflinePlayer::isOnline).toList());
        this.endGame();
    }
    public void resetPlayers() {
        this.runners = new ArrayList<>();
        this.hunters = new ArrayList<>();
        this.players = new ArrayList<>();
    }
    private void endGame() {
        Game game = Game.getInstance();
        if(getHunters().isEmpty()) {
            game.end("hunters", false);
        }
        if(getRunners().isEmpty()) {
            game.end("runners", false);
        }
    }
}
