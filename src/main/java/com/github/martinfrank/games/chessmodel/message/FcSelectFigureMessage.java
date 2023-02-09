package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Player;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.UUID;

public class FcSelectFigureMessage extends Message{

    public final Player player;
    public final Field field;
    public final UUID gameId;

    public FcSelectFigureMessage(Player player, UUID gameId, Field field) {
        super(MessageType.FC_SELECT_FIGURE);
        this.player = player;
        this.gameId = gameId;
        this.field = field;
    }

    @Override
    public String toString() {
        return "FcSelectColorMessage{" +
                "player=" + player +
                ", field=" + field +
                ", gameId=" + gameId +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
