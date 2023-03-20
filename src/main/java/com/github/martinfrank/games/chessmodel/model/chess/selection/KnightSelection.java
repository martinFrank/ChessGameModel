package com.github.martinfrank.games.chessmodel.model.chess.selection;

import com.github.martinfrank.games.chessmodel.model.chess.Board;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.ArrayList;
import java.util.List;

public class KnightSelection {


    public static List<Field> getSelection(Field from, Board board, Color figureColor) {
        List<Field> fields = new ArrayList<>();

        Field northWest = Field.northWestOf(from);
        if (northWest != null) {
            Field northNorthWest = Field.northOf(northWest);
            if (northNorthWest != null) {
                if (board.isFree(northNorthWest)) {
                    fields.add(northNorthWest);
                }
                if (board.isOccupiedEnemy(northNorthWest, figureColor)) {
                    fields.add(northNorthWest);
                }
            }
            Field westNorthWest = Field.westOf(northWest);
            if (westNorthWest != null) {
                if (board.isFree(westNorthWest)) {
                    fields.add(westNorthWest);
                }
                if (board.isOccupiedEnemy(westNorthWest, figureColor)) {
                    fields.add(westNorthWest);
                }
            }
        }

        Field northEast = Field.northEastOf(from);
        if (northEast != null) {
            Field northNorthEast = Field.northOf(northEast);
            if (northNorthEast != null) {
                if (board.isFree(northNorthEast)) {
                    fields.add(northNorthEast);
                }
                if (board.isOccupiedEnemy(northNorthEast, figureColor)) {
                    fields.add(northNorthEast);
                }
            }
            Field eastNorthEast = Field.eastOf(northEast);
            if (eastNorthEast != null) {
                if (board.isFree(eastNorthEast)) {
                    fields.add(eastNorthEast);
                }
                if (board.isOccupiedEnemy(eastNorthEast, figureColor)) {
                    fields.add(eastNorthEast);
                }
            }
        }
        Field southEast = Field.southEastOf(from);
        if (southEast != null) {
            Field southSouthEast = Field.southOf(southEast);
            if (southSouthEast != null) {
                if (board.isFree(southSouthEast)) {
                    fields.add(southSouthEast);
                }
                if (board.isOccupiedEnemy(southSouthEast, figureColor)) {
                    fields.add(southSouthEast);
                }
            }
            Field eastSouthEast = Field.eastOf(southEast);
            if (eastSouthEast != null) {
                if (board.isFree(eastSouthEast)) {
                    fields.add(eastSouthEast);
                }
                if (board.isOccupiedEnemy(eastSouthEast, figureColor)) {
                    fields.add(eastSouthEast);
                }
            }
        }

        Field southWest = Field.southWestOf(from);
        if (southWest != null) {
            Field southSouthWest = Field.southOf(southWest);
            if (southSouthWest != null) {
                if (board.isFree(southSouthWest)) {
                    fields.add(southSouthWest);
                }
                if (board.isOccupiedEnemy(southSouthWest, figureColor)) {
                    fields.add(southSouthWest);
                }

            }
            Field westSouthWest = Field.westOf(southWest);
            if (westSouthWest != null) {
                if (board.isFree(westSouthWest)) {
                    fields.add(westSouthWest);
                }
                if (board.isOccupiedEnemy(westSouthWest, figureColor)) {
                    fields.add(westSouthWest);
                }
            }
        }
        return fields;
    }
}
