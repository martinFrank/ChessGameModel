package com.github.martinfrank.games.chessmodel.message.getopengames;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Player;

public class FcGetOpenGamesMessage extends Message {

    public final Player player;
    public FcGetOpenGamesMessage(Player player) {
        super(MessageType.FC_GET_OPEN_GAMES);
        this.player = player;
    }

    @Override
    public String toString() {
        return "FcGetOpenGamesMessage{" +
                "player="+player+
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
