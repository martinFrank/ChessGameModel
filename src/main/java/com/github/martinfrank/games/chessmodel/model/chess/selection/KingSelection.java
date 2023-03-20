package com.github.martinfrank.games.chessmodel.model.chess.selection;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.ArrayList;
import java.util.List;

public class KingSelection {
    public static List<Field> getSelection(Field from, Board board, Color figureColor) {
        List<Field> fields = new ArrayList<>();
        addField(fields, Field.northWestOf(from), board, figureColor);
        addField(fields, Field.northOf(from), board, figureColor);
        addField(fields, Field.northEastOf(from), board, figureColor);
        addField(fields, Field.eastOf(from), board, figureColor);
        addField(fields, Field.southEastOf(from), board, figureColor);
        addField(fields, Field.southOf(from), board, figureColor);
        addField(fields, Field.southWestOf(from), board, figureColor);
        addField(fields, Field.westOf(from), board, figureColor);
        return fields;
    }

    private static void addField(List<Field> fields, Field field, Board board, Color figureColor) {
        if(field != null) {
            if(board.isFree(field)){
                fields.add(field);
            }
            if(board.isOccupiedEnemy(field, figureColor)){
                fields.add(field);
            }
        }
    }
}
