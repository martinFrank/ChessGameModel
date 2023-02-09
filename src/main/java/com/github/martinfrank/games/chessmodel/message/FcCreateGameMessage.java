package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Player;

public class FcCreateGameMessage extends Message{

    public final Player player;
    public FcCreateGameMessage(Player player) {
        super(MessageType.FC_CREATE_GAME);
        this.player = player;
    }

    @Override
    public String toString() {
        return "FcCreateGameMessage{" +
                "player=" + player +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
