package com.github.martinfrank.games.chessmodel.model;


import com.github.martinfrank.games.chessmodel.model.chess.ChessGame;

import java.util.Objects;
import java.util.UUID;

//laufendes Spiel
public class Game {

    public final UUID gameId;
    private Player hostPlayer;
    private Player guestPlayer;
    public ChessGame chessGame;

    public Game(UUID gameId, Player hostPlayer) {
        this.gameId = gameId;
        chessGame = new ChessGame();
        updateHostPlayer(hostPlayer);
    }

    public Player getHostPlayer(){
        return hostPlayer;
    }

    public Player getGuestPlayer(){
        return guestPlayer;
    }

    public void updateGuestPlayer(Player guestPlayer) {
        this.guestPlayer = guestPlayer;
        chessGame.setGuest(guestPlayer);
    }

    public void updateHostPlayer(Player hostPlayer) {
        this.hostPlayer = hostPlayer;
        chessGame.setHost(hostPlayer);
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
