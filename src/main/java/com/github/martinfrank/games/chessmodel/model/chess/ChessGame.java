package com.github.martinfrank.games.chessmodel.model.chess;

import com.github.martinfrank.games.chessmodel.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessGame {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChessGame.class);

    private boolean isStarted;
    private Participant host;
    private Participant guest;
    private Participant current;


    private long startTime = -1;
    public Board board;

    public ChessGame(){
        board = new Board();
    }

    public boolean isValidMove(Field from, Field to, Player player){
        LOGGER.debug("isValidMove?");
        if(!hasValidMoveParameter(from, to, player) ){
            LOGGER.debug("no - invalid Parameter");
            return false;
        }
        if(!isMyMove(from, player)){
            LOGGER.debug("no - is not MY move");
            return false;
        }

        boolean willBeCheck = board.willBeCheck(from, to, getThisParticipant(player).color);
        LOGGER.debug("willBeCheck="+willBeCheck);
        return !willBeCheck;
    }

    private boolean isMyMove(Field from, Player player) {
        Figure figure = board.findFigure(from);
        Color myColor = getThisParticipant(player).color;
        LOGGER.debug("isMyMove.myColor="+myColor);
        boolean isMyFigure = figure != null && figure.isColor(myColor);
        LOGGER.debug("current.player.id="+current.player.playerId);
        LOGGER.debug("        player.id="+player.playerId);
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
        if(host == null){
            host = new Participant(hostPlayer);
        }else{
            host.updatePlayer(hostPlayer);
        }
        host.color = Color.WHITE;
    }

    public void setGuest(Player guestPlayer) {
        if(guest == null){
            guest = new Participant(guestPlayer);
        }else{
            guest.updatePlayer(guestPlayer);
        }
        guest.color = host.color.getOpposite();
    }
}
