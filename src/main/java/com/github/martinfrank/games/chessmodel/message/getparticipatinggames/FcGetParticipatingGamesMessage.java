package com.github.martinfrank.games.chessmodel.message.getparticipatinggames;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Player;

public class FcGetParticipatingGamesMessage extends Message {

    public final Player player;

    public FcGetParticipatingGamesMessage(Player player) {
        super(MessageType.FC_GET_PARTICIPATING_GAMES);
        this.player = player;
    }

    @Override
    public String toString() {
        return "FcGetServerInfoMessage{" +
                "player=" + player +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
