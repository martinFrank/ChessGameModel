package com.github.martinfrank.games.chessmodel.model.chess.selection;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.ArrayList;
import java.util.List;

public class QueenSelection {
    public static List<Field> getSelection(Field from, Board board, Color color) {
        List<Field> fields = new ArrayList<>();
        fields.addAll(BishopSelection.getSelection(from, board, color));
        fields.addAll(RookSelection.getSelection(from, board, color));
        return fields;
    }
}
