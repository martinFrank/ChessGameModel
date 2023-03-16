package com.github.martinfrank.games.chessmodel.message.selectcolor;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Player;
import com.github.martinfrank.games.chessmodel.model.chess.Color;

import java.util.UUID;

public class FcSelectColorMessage extends Message {

    public final Player player;
    public final Color desiredColor;
    public final UUID gameId;

    public FcSelectColorMessage(Player player, UUID gameId, Color desiredColor) {
        super(MessageType.FC_SELECT_COLOR);
        this.player = player;
        this.gameId = gameId;
        this.desiredColor = desiredColor;
    }

    @Override
    public String toString() {
        return "FcSelectColorMessage{" +
                "player=" + player +
                ", desiredColor=" + desiredColor +
                ", gameId=" + gameId +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
