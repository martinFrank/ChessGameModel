package com.github.martinfrank.games.chessmodel.message.joingame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Player;

import java.util.UUID;

public class FcJoinGameMessage extends Message {

    public final Player player;
    public final UUID gameId;

    public FcJoinGameMessage(Player player, UUID gameId) {
        super(MessageType.FC_JOIN_GAME);
        this.player = player;
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "FcJoinGameMessage{" +
                "player=" + player +
                ", gameId=" + gameId +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
