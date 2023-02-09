package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Player;

public class FcGetOpenGamesMessage extends Message{

    public final Player player;
    public FcGetOpenGamesMessage(Player player) {
        super(MessageType.FC_GET_OPEN_GAMES);
        this.player = player;
    }

    @Override
    public String toString() {
        return "FcGetOpenGamesMessage{" +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
