package com.github.martinfrank.games.chessmodel.model.chess.selection;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.ArrayList;
import java.util.List;

public class WhitePawnSelection {
    public static List<Field> getSelection(Field from, Board board) {
        List<Field> fields = new ArrayList<>();

        Field north = Field.northOf(from);
        if(north == null){
            return new ArrayList<>();
        }
        if(board.isFree(north)){
            fields.add(north);
        }
        Field northEast = Field.northEastOf(from);
        if(board.isOccupiedEnemy(northEast, Color.WHITE)){
            fields.add(northEast);
        }
        Field northWest = Field.northWestOf(from);
        if(board.isOccupiedEnemy(northWest, Color.WHITE)){
            fields.add(northWest);
        }

        if (from.row.equals("2") && board.isFree(north)){
            Field northNorth = Field.northOf(north);
            if(board.isFree(northNorth)){
                fields.add(northNorth);
            }
        }
        return fields;
    }
}
