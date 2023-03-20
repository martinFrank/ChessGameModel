package com.github.martinfrank.games.chessmodel.model.chess.selection;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.ArrayList;
import java.util.List;

public class BlackPawnSelection {

    public static List<Field> getSelection(Field from, Board board) {
        List<Field> fields = new ArrayList<>();

        Field south = Field.southOf(from);
        if(south == null){
            return new ArrayList<>();
        }
        if(board.isFree(south)){
            fields.add(south);
        }
        Field southEast = Field.southEastOf(from);
        if(board.isOccupiedEnemy(southEast, Color.BLACK)){
            fields.add(southEast);
        }
        Field southWest = Field.southWestOf(from);
        if(board.isOccupiedEnemy(southWest, Color.BLACK)){
            fields.add(southWest);
        }

        if (from.row.equals("7") && board.isFree(south)){
            Field southSouth = Field.southOf(south);
            if(board.isFree(southSouth)){
                fields.add(southSouth);
            }
        }
        return fields;
    }
}
