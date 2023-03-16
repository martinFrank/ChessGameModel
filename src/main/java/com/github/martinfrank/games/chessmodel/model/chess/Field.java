package com.github.martinfrank.games.chessmodel.model.chess;

import java.util.Objects;

public class Field {

    public String row;
    public String column;

    public Field(String row, String column) {
        this.row = row;
        this.column = column;
    }

    public static Field westOf(Field from) {
        int col = mapFromColumn(from.column);
        return new Field(from.row, mapToColumn(col + 1));
    }

    public static Field northOf(Field from) {
        int row = mapFromRow(from.row);
        String northRow;
        try{
            northRow = mapToRow(row+1);
        }catch (IllegalArgumentException e){
            return null;
        }
        return new Field(northRow, from.column);
    }

    public static Field southOf(Field from) {
        int row = mapFromRow(from.row);
        String southRow;
        try{
            southRow = mapToRow(row-1);
        }catch (IllegalArgumentException e){
            return null;
        }
        return new Field(southRow, from.column);
    }

    public static int mapFromRow(String row) {
        switch (row){
            case "1": return 0;
            case "2": return 1;
            case "3": return 2;
            case "4": return 3;
            case "5": return 4;
            case "6": return 5;
            case "7": return 6;
            case "8": return 7;
        }
        throw new IllegalArgumentException("not a valid row (1-8): "+row);
    }

    public static int mapFromColumn(String column) {
        switch (column){
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            case "E": return 4;
            case "F": return 5;
            case "G": return 6;
            case "H": return 7;
        }
        throw new IllegalArgumentException("not a valid (A-H) column: "+column);
    }




    @Override
    public String toString() {
        return "Field{" +
                "row='" + row + '\'' +
                ", column='" + column + '\'' +
                '}';
    }


    public static String mapToColumn(int column) {
        switch (column){
            case 0: return "A";
            case 1: return "B";
            case 2: return "C";
            case 3: return "D";
            case 4: return "E";
            case 5: return "F";
            case 6: return "G";
            case 7: return "H";
        }
        throw new IllegalArgumentException("not a valid (0-7) column: "+column);
    }

    public static String mapToRow(int row) {
        switch (row){
            case 0: return "1";
            case 1: return "2";
            case 2: return "3";
            case 3: return "4";
            case 4: return "5";
            case 5: return "6";
            case 6: return "7";
            case 7: return "8";
        }
        throw new IllegalArgumentException("not a valid (0-7) row: "+row);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return row.equals(field.row) && column.equals(field.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
