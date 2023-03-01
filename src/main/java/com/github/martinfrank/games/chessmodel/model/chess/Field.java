package com.github.martinfrank.games.chessmodel.model.chess;

public class Field {

    public String row;
    public String column;

    transient int x;
    transient int y;


    public Field(String row, String column) {
        this.row = row;
        this.column = column;
    }

    Field(int x, int y) {
        this.row = mapToRow(x);
        this.column = mapToColumn((char)y);
        this.x = x;
        this.y = y;
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
        return "?";
    }

    public static String mapToRow(int row) {
        return ""+(8 - row);
    }


}
