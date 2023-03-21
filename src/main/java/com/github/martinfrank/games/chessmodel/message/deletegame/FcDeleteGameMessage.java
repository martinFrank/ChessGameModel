package com.github.martinfrank.games.chessmodel.message.deletegame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Player;

import java.util.UUID;

public class FcDeleteGameMessage extends Message {

    public final Player player;
    public final UUID gameId;

    public FcDeleteGameMessage(Player player, UUID gameId) {
        super(MessageType.FC_DELETE_GAME);
        this.player = player;
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "FcDeleteGameMessage{" +
                "player=" + player +
                ", gameId=" + gameId +
                ", message=" + msgType +
                '}';
    }
}
