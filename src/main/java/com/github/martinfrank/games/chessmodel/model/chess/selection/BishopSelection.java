package com.github.martinfrank.games.chessmodel.model.chess.selection;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;
import com.github.martinfrank.games.chessmodel.model.chess.Figure;
import com.github.martinfrank.games.chessmodel.model.chess.Figurine;

import java.util.ArrayList;
import java.util.List;

public class BishopSelection {
    public static List<Field> getSelection(Field from, Board board, Color figureColor) {
        List<Field> fields = new ArrayList<>();

        //nw
        Field nw = from;
        while (nw != null){
            nw = Field.northWestOf(nw);
            if(nw != null){
                if(board.isFree(nw)){
                    fields.add(nw);
                }
                if(board.isOccupiedEnemy(nw, figureColor)){
                    fields.add(nw);
                    break;
                }
                if(board.isOccupiedFriendly(nw, figureColor)){
                    break;
                }
            }
        }

        //ne
        Field ne = from;
        while (ne != null){
            ne = Field.northEastOf(ne);
            if(ne != null){
                if(board.isFree(ne)){
                    fields.add(ne);
                }
                if(board.isOccupiedEnemy(ne, figureColor)){
                    fields.add(ne);
                    break;
                }
                if(board.isOccupiedFriendly(ne, figureColor)){
                    break;
                }
            }
        }

        //se
        Field se = from;
        while (se != null){
            se = Field.southEastOf(se);
            if(se != null){
                if(board.isFree(se)){
                    fields.add(se);
                }
                if(board.isOccupiedEnemy(se, figureColor)){
                    fields.add(se);
                    break;
                }
                if(board.isOccupiedFriendly(se, figureColor)){
                    break;
                }
            }
        }

        //sw
        Field sw = from;
        while (sw != null){
            sw = Field.southWestOf(sw);
            if(sw != null){
                if(board.isFree(sw)){
                    fields.add(sw);
                }
                if(board.isOccupiedEnemy(sw, figureColor)){
                    fields.add(sw);
                    break;
                }
                if(board.isOccupiedFriendly(sw, figureColor)){
                    break;
                }
            }
        }

        return fields;
    }
}
