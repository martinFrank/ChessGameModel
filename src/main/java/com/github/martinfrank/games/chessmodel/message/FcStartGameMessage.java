package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Player;

import java.util.UUID;

public class FcStartGameMessage extends Message{

    public final Player player;
    public final UUID gameId;

    public FcStartGameMessage(Player player, UUID gameId) {
        super(MessageType.FC_START_GAME);
        this.player = player;
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "FcSelectColorMessage{" +
                "player=" + player +
                ", gameId=" + gameId +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
