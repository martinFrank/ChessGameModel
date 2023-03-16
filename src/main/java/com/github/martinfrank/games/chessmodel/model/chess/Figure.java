package com.github.martinfrank.games.chessmodel.model.chess;

import java.util.Collections;
import java.util.List;

public class Figure {

    public final String symbol;
    public final Color color;
    public final Figurine type;

    public Figure(String symbol, Color color, Figurine type) {
        this.symbol = symbol;
        this.color = color;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "symbol='" + symbol + '\'' +
                ", color=" + color +
                ", type=" + type +
                '}';
    }

    public boolean is(Figurine type, Color color) {
        return this.type == type && isColor(color);
    }

    public boolean isColor( Color color){
        return this.color == color;
    }
}
