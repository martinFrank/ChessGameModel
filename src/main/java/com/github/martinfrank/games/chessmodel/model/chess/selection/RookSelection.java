package com.github.martinfrank.games.chessmodel.model.chess.selection;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.ArrayList;
import java.util.List;

public class RookSelection {
    public static List<Field> getSelection(Field from, Board board, Color figureColor) {
        List<Field> fields = new ArrayList<>();

        //n
        Field n = from;
        while (n != null){
            n = Field.northOf(n);
            if(n != null){
                if(board.isFree(n)){
                    fields.add(n);
                }
                if(board.isOccupiedEnemy(n, figureColor)){
                    fields.add(n);
                    break;
                }
                if(board.isOccupiedFriendly(n, figureColor)){
                    break;
                }
            }
        }

        //e
        Field e = from;
        while (e != null){
            e = Field.eastOf(e);
            if(e != null){
                if(board.isFree(e)){
                    fields.add(e);
                }
                if(board.isOccupiedEnemy(e, figureColor)){
                    fields.add(e);
                    break;
                }
                if(board.isOccupiedFriendly(e, figureColor)){
                    break;
                }
            }
        }

        //s
        Field s = from;
        while (s != null){
            s = Field.southOf(s);
            if(s != null){
                if(board.isFree(s)){
                    fields.add(s);
                }
                if(board.isOccupiedEnemy(s, figureColor)){
                    fields.add(s);
                    break;
                }
                if(board.isOccupiedFriendly(s, figureColor)){
                    break;
                }
            }
        }

        //w
        Field w = from;
        while (w != null){
            w = Field.westOf(w);
            if(w != null){
                if(board.isFree(w)){
                    fields.add(w);
                }
                if(board.isOccupiedEnemy(w, figureColor)){
                    fields.add(w);
                    break;
                }
                if(board.isOccupiedFriendly(w, figureColor)){
                    break;
                }
            }
        }

        return fields;
    }
}
