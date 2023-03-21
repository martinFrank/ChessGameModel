package com.github.martinfrank.games.chessmodel.model;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;
import com.github.martinfrank.games.chessmodel.model.chess.Figure;
import com.github.martinfrank.games.chessmodel.model.chess.Participant;

public class GameContent {


    private boolean isStarted;
    private Participant host;
    private Participant guest;
    private Participant current;


    private long startTime = -1;
    public Board board;

    public GameContent (){
        board = new Board();
    }

    public boolean isValidMove(Field from, Field to, Player player){
        if(!hasValidMoveParameter(from, to, player) ){
            return false;
        }
        if(!isMyMove(from, player)){
            return false;
        }

        boolean willBeCheck = board.willBeCheck(from, to, getThisParticipant(player).color);
        return !willBeCheck;
    }

    private boolean isMyMove(Field from, Player player) {
        Figure figure = board.findFigure(from);
        Color myColor = getThisParticipant(player).color;
        boolean isMyFigure = figure != null && figure.isColor(myColor);
        boolean isMyTurn = current.player.equals(player);
        return (isMyFigure && isMyTurn);
    }

    private boolean hasValidMoveParameter(Field from, Field to, Player player) {
        if(from == null){
            return false;
        }
        if(to == null){
            return false;
        }
        if(player == null){
            return false;
        }
        if(from.equals(to)){
            return false;
        }
        if (!board.getSelectionForField(from).contains(to)){
            return false;
        }
        return true;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void startGame() {
        isStarted = true;
        current = host.color == Color.WHITE ? host : guest;
        board = new Board();
        startTime = System.currentTimeMillis();
    }


    public void setHostColor(Color desiredColor) {
        host.color = desiredColor;
        guest.color = desiredColor.getOpposite();
    }

    public Participant getCurrentParticipant() {
        return current;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }


    public void moveFigure(Field from, Field to) {
        board.moveFigure(from, to);
        toggleCurrent();
    }

    private void toggleCurrent() {
        if(current.equals(host)){
            current = guest;
        }else {
            current = host;
        }
    }

    public Participant getThisParticipant(Player player){
        if(host.player.equals(player)){
            return host;
        }
        return guest;
    }

    public Participant getOtherParticipant(Player player){
        if(host.player.equals(player)){
            return guest;
        }
        return host;
    }

    public Participant getHost(){
        return host;
    }

    public Participant getGuest(){
        return guest;
    }

    public void setHost(Player hostPlayer) {
        host = new Participant(hostPlayer);
        host.color = Color.WHITE;
    }

    public void setGuest(Player guestPlayer) {
        guest = new Participant(guestPlayer);
        guest.color = Color.BLACK;
    }
}
