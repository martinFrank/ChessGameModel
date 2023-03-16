package com.github.martinfrank.games.chessmodel.model.chess;

import com.github.martinfrank.games.chessmodel.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final transient Fields fields = new Fields();
    public final Map<Field, Figure> lineUp = new HashMap<>();
    public final List<Figure> beatenFigures = new ArrayList<>();

    public Board(){
        lineUpFigureAt(Figurine.ROOK, Color.WHITE, 'A', 1);
        lineUpFigureAt(Figurine.KNIGHT, Color.WHITE, 'B', 1);
        lineUpFigureAt(Figurine.BISHOP, Color.WHITE, 'C', 1);
        lineUpFigureAt(Figurine.QUEEN, Color.WHITE, 'D', 1);
        lineUpFigureAt(Figurine.KING, Color.WHITE, 'E', 1);
        lineUpFigureAt(Figurine.BISHOP, Color.WHITE, 'F', 1);
        lineUpFigureAt(Figurine.KNIGHT, Color.WHITE, 'G', 1);
        lineUpFigureAt(Figurine.ROOK, Color.WHITE, 'H', 1);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'A', 2);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'B', 2);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'C', 2);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'D', 2);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'E', 2);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'F', 2);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'G', 2);
        lineUpFigureAt(Figurine.PAWN, Color.WHITE, 'H', 2);


        lineUpFigureAt(Figurine.ROOK, Color.BLACK, 'A', 8);
        lineUpFigureAt(Figurine.KNIGHT, Color.BLACK, 'B', 8);
        lineUpFigureAt(Figurine.BISHOP, Color.BLACK, 'C', 8);
        lineUpFigureAt(Figurine.QUEEN, Color.BLACK, 'D', 8);
        lineUpFigureAt(Figurine.KING, Color.BLACK, 'E', 8);
        lineUpFigureAt(Figurine.BISHOP, Color.BLACK, 'F', 8);
        lineUpFigureAt(Figurine.KNIGHT, Color.BLACK, 'G', 8);
        lineUpFigureAt(Figurine.ROOK, Color.BLACK, 'H', 8);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'A', 7);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'B', 7);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'C', 7);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'D', 7);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'E', 7);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'F', 7);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'G', 7);
        lineUpFigureAt(Figurine.PAWN, Color.BLACK, 'H', 7);
    }

    private void lineUpFigureAt(Figurine figurine, Color color, char column, int row) {
        Field field = fields.getField(column, row);
        Figure f = Figures.getFigure(figurine, color);
        lineUp.put(field, f);
    }


    public Field findField(int x, int y){
        String column = Field.mapToColumn(x);
        String row = Field.mapToRow(y);
        return findField(row, column);
    }

    public Field findField(String row, String column){
        return fields.getField(row.charAt(0), Integer.parseInt(column));
    }
    public Figure findFigure(Field field) {
        if(lineUp.containsKey(field)){
            return lineUp.get(field);
        }
        return null;
    }


    @Override
    public String toString() {
        return "Board{" +
                ", lineUp=" + lineUp +
                ", beatenFigures=" + beatenFigures +
                '}';
    }

    public List<Field> getSelectionForField(Field from){
        Figure f = lineUp.get(from);
        if(f != null){
            return getSelectionForFigure(f, from);
        }
        return new ArrayList<>();
    }

    private List<Field> getSelectionForFigure(Figure figure, Field from) {
        if(figure.is(Figurine.PAWN, Color.WHITE)){
            return getSelectionForWhitePawn(from);
        }
        if(figure.is(Figurine.PAWN, Color.BLACK)){
            return getSelectionForBlackPawn(from);
        }
        return new ArrayList<>();
    }

    private List<Field> getSelectionForWhitePawn(Field from) {
        List<Field> fields = new ArrayList<>();

        Field north = Field.northOf(from);
        if(north == null){
            return new ArrayList<>();
        }
        boolean isForwardFree = isFree(north);
        fields.add(north);
        if(!isForwardFree){
            return fields;
        }
        if (from.row.equals("2") ){
            Field northNorth = Field.northOf(north);
            fields.add(northNorth);
        }
        return fields;
    }

    private List<Field> getSelectionForBlackPawn(Field from) {
        List<Field> fields = new ArrayList<>();

        Field south = Field.southOf(from);
        if(south == null){
            return new ArrayList<>();
        }
        boolean isForwardFree = isFree(south);
        fields.add(south);
        if(!isForwardFree){
            return fields;
        }
        if (from.row.equals("7") ){
            Field southOfSouth = Field.southOf(south);
            fields.add(southOfSouth);
        }
        return fields;
    }


    private boolean isFree(Field f){
        return !lineUp.containsKey(f);
    }
    private boolean isOccupied(Field f){
        return lineUp.containsKey(f);
    }

    public void moveFigure(Field from, Field to) {
        Figure beaten = lineUp.get(to);
        if (beaten != null){
            beatenFigures.add(beaten);
        }
        Figure moved = lineUp.get(from);
        lineUp.remove(from);
        lineUp.put(to, moved);

    }
}
