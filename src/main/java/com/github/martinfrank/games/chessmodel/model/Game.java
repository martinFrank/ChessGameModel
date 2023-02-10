package com.github.martinfrank.games.chessmodel.model;


import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;

import java.util.Objects;
import java.util.UUID;

//laufendes Spiel
public class Game {

    public final UUID gameId;
    public final Player hostPlayer;
    private Player guestPlayer;
    private Player currentPlayer;

    private Color hostColor = Color.WHITE;
    private Color guestColor = Color.BLACK;
    private boolean isStarted;
    private boolean isHostOnline;
    private boolean isGuestOnline;

    private long startTime = -1;

    public Board board;
    //private List<Move> moveHistory;

    public Game(UUID gameId, Player hostPlayer) {
        this.gameId = gameId;
        this.hostPlayer = hostPlayer;
        isHostOnline = true;
    }

    public Player getGuestPlayer(){
        return guestPlayer;
    }

    public void setGuestPlayer(Player guestPlayer) {
        this.guestPlayer = guestPlayer;
    }

    public boolean isHostOnline() {
        return isHostOnline;
    }

    public void setHostOnline(boolean hostOnline) {
        isHostOnline = hostOnline;
    }

    public boolean isGuestOnline() {
        return isGuestOnline;
    }

    public void setGuestOnline(boolean guestOnline) {
        isGuestOnline = guestOnline;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
        currentPlayer = hostPlayer;
        board = new Board();
        startTime = System.currentTimeMillis();
    }


    public void setHostColor(Color desiredColor) {
        hostColor = desiredColor;
        guestColor = desiredColor.getOpposite();
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", hostPlayer=" + hostPlayer +
                ", guestPlayer=" + guestPlayer +
                ", currentPlayer=" + currentPlayer +
                ", hostColor=" + hostColor +
                ", guestColor=" + guestColor +
                ", isStarted=" + isStarted +
                ", isHostOnline=" + isHostOnline +
                ", isGuestOnline=" + isGuestOnline +
                ", startTime=" + startTime +
                ", board=" + board +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return isStarted == game.isStarted && isHostOnline == game.isHostOnline && isGuestOnline == game.isGuestOnline && startTime == game.startTime && gameId.equals(game.gameId) && hostPlayer.equals(game.hostPlayer) && Objects.equals(guestPlayer, game.guestPlayer) && Objects.equals(currentPlayer, game.currentPlayer) && hostColor == game.hostColor && guestColor == game.guestColor && Objects.equals(board, game.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, hostPlayer, guestPlayer, currentPlayer, hostColor, guestColor, isStarted, isHostOnline, isGuestOnline, startTime, board);
    }
}
