package com.github.martinfrank.games.chessmodel.model.chess;

import com.github.martinfrank.games.chessmodel.model.Player;

import java.util.UUID;

public class Participant {

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
        if (selection != null && selection.equals(field)){
            selection = null;
        }else {
            selection = field;
        }

    }

    public boolean hasSelection(){
        return selection != null;
    }

    public Field getSelection(){
        return selection;
    }

}
