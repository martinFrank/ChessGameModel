package com.github.martinfrank.games.chessmodel.model.chess;

import com.github.martinfrank.games.chessmodel.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Participant {

    private static final Logger LOGGER = LoggerFactory.getLogger(Participant.class);

    public Player player;
    public Color color;
    private Field selection;

    public Participant(Player player) {
        this.player = player;
    }

    public boolean isColor(Color color){
        return this.color.equals(color);
    }


    public void selectField(Field field) {
        LOGGER.debug("before: "+selection);
        LOGGER.debug("new value: "+field);
        if (selection != null && selection.equals(field)){
            selection = null;
        }else {
            selection = field;
        }
        LOGGER.debug("after: "+selection);
    }

    public boolean hasSelection(){
        return selection != null;
    }

    public Field getSelection(){
        return selection;
    }

    public void updatePlayer(Player hostPlayer) {
        this.player = player;
    }
}
