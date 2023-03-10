package com.github.martinfrank.games.chessmodel.message.selectfield;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Player;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.UUID;

public class FcSelectFieldMessage extends Message {

    public final Player player;
    public final Field field;
    public final UUID gameId;

    public FcSelectFieldMessage(Player player, UUID gameId, Field field) {
        super(MessageType.FC_SELECT_FIELD);
        this.player = player;
        this.gameId = gameId;
        this.field = field;
    }

    @Override
    public String toString() {
        return "FcSelectFieldMessage{" +
                "player=" + player +
                ", field=" + field +
                ", gameId=" + gameId +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
