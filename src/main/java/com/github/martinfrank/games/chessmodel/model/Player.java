package com.github.martinfrank.games.chessmodel.model;

import java.util.Objects;
import java.util.UUID;

public class Player {

    public final UUID playerId;
    public final String playerName;
    public final int color;

    public Player(UUID playerId, String playerName, int color){
        this.playerId = playerId;
        this.playerName = playerName;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId.equals(player.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                '}';
    }

    public boolean hasId(UUID playerId) {
        return this.playerId.equals(playerId);
    }
}
