package com.github.martinfrank.games.chessmodel.model;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;

public class GameContent {


    private boolean isStarted;
    private Player currentPlayer;

    private Color hostColor = Color.WHITE;
    private Color guestColor = Color.BLACK;
    private boolean isHostOnline;
    private boolean isGuestOnline;

    private long startTime = -1;

    public Board board;

    public transient final Game container;

    public GameContent (Game container){
        this.container = container; //string coupling
        board = new Board();
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
        currentPlayer = container.hostPlayer;
        board = new Board();
        startTime = System.currentTimeMillis();
    }


    public void setHostColor(Color desiredColor) {
        hostColor = desiredColor;
        guestColor = desiredColor.getOpposite();
    }

    @Override
    public String toString() {
        return "GameContent{" +
                "isStarted=" + isStarted +
                ", currentPlayer=" + currentPlayer +
                ", hostColor=" + hostColor +
                ", guestColor=" + guestColor +
                ", isHostOnline=" + isHostOnline +
                ", isGuestOnline=" + isGuestOnline +
                ", startTime=" + startTime +
                ", board=" + board +
                ", container=" + container +
                '}';
    }
}
