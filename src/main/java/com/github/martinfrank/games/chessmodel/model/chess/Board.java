package com.github.martinfrank.games.chessmodel.model.chess;

import com.github.martinfrank.games.chessmodel.model.chess.selection.BishopSelection;
import com.github.martinfrank.games.chessmodel.model.chess.selection.BlackPawnSelection;
import com.github.martinfrank.games.chessmodel.model.chess.selection.KingSelection;
import com.github.martinfrank.games.chessmodel.model.chess.selection.KnightSelection;
import com.github.martinfrank.games.chessmodel.model.chess.selection.QueenSelection;
import com.github.martinfrank.games.chessmodel.model.chess.selection.RookSelection;
import com.github.martinfrank.games.chessmodel.model.chess.selection.WhitePawnSelection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            return WhitePawnSelection.getSelection(from, this);
        }
        if(figure.is(Figurine.PAWN, Color.BLACK)){
            return BlackPawnSelection.getSelection(from, this);
        }
        if(figure.is(Figurine.KNIGHT, Color.WHITE) || figure.is(Figurine.KNIGHT, Color.BLACK)  ){
            return KnightSelection.getSelection(from, this, figure.color);
        }
        if(figure.is(Figurine.BISHOP, Color.WHITE) || figure.is(Figurine.BISHOP, Color.BLACK)  ){
            return BishopSelection.getSelection(from, this, figure.color);
        }
        if(figure.is(Figurine.ROOK, Color.WHITE) || figure.is(Figurine.ROOK, Color.BLACK)  ){
            return RookSelection.getSelection(from, this, figure.color);
        }
        if(figure.is(Figurine.QUEEN, Color.WHITE) || figure.is(Figurine.QUEEN, Color.BLACK)  ){
            return QueenSelection.getSelection(from, this, figure.color);
        }
        if(figure.is(Figurine.KING, Color.WHITE) || figure.is(Figurine.KING, Color.BLACK)  ){
            return KingSelection.getSelection(from, this, figure.color);
        }
        return new ArrayList<>();
    }


    public boolean isFree(Field f){
        return !lineUp.containsKey(f);
    }
    public boolean isOccupied(Field f){
        return lineUp.containsKey(f);
    }

    public boolean isOccupiedFriendly(Field f, Color color){
        Figure figure = lineUp.get(f);
        return figure != null && figure.isColor(color);
    }

    public boolean isOccupiedEnemy(Field f, Color color){
        Figure figure = lineUp.get(f);
        return figure != null && !figure.isColor(color);
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

    public boolean isCheck(Color color) {
        Field kingsField = findKingsField(color);
        List<Field> enemyOccupiedFields = filterLineUp(color.getOpposite());
        for(Field enemyOccupiedField: enemyOccupiedFields){
            List<Field> selection = getSelectionForField(enemyOccupiedField);
            if(selection.contains(kingsField)){
                return true;
            }
        }
        return false;
    }

    private List<Field> filterLineUp(Color color) {
        return lineUp.entrySet().stream()
                .filter(entry -> entry.getValue().isColor(color))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    private Field findKingsField(Color color) {
        for(Map.Entry<Field, Figure> entry: lineUp.entrySet()){
            if(entry.getValue().is(Figurine.KING, color)){
                return entry.getKey();
            }
        }
        throw new IllegalStateException("there is no King with color:"+color+" in the line up");
    }

    public boolean willBeCheck(Field from, Field to, Color playersColor) {
        Map<Field, Figure> lineUpCopy = new HashMap<>(lineUp);
        moveFigure(from, to);
        boolean isCheck = isCheck(playersColor);
        lineUp.clear();
        lineUp.putAll(lineUpCopy);
        return isCheck;
    }
}
