package com.github.martinfrank.games.chessmodel.model;


import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;
import com.github.martinfrank.games.chessmodel.model.chess.Figure;

import java.util.Objects;
import java.util.UUID;

//laufendes Spiel
public class Game {

    public final UUID gameId;
    public final Player hostPlayer;
    private Player guestPlayer;
    public GameContent gameContent;

    public Game(UUID gameId, Player hostPlayer) {
        this.gameId = gameId;
        this.hostPlayer = hostPlayer;
        gameContent = new GameContent();
        updateHostPlayer(hostPlayer);
    }

    public Player getGuestPlayer(){
        return guestPlayer;
    }

    public void updateGuestPlayer(Player guestPlayer) {
        this.guestPlayer = guestPlayer;
        gameContent.setGuest(guestPlayer);
    }

    public void updateHostPlayer(Player hostPlayer) {
        gameContent.setHost(hostPlayer);
    }


    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", hostPlayer=" + hostPlayer +
                ", guestPlayer=" + guestPlayer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId.equals(game.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId);
    }

    public boolean isParticipant(Player player) {
        if(player == null){
            throw new IllegalArgumentException("player is null!");
        }
        return player.equals(hostPlayer) || player.equals(guestPlayer);
    }

    public Player getOther(Player player){
        if (hostPlayer.equals(player)){
            return guestPlayer;
        }
        return hostPlayer;
    }

    public boolean isHost(Player player) {
        return hostPlayer.equals(player);
    }

    public boolean isGuest(Player player) {
        return guestPlayer != null && guestPlayer.equals(player);
    }


}
