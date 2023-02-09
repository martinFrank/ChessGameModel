package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Player;

public class FcLoginMessage extends Message{

    public final Player player;

    public FcLoginMessage(Player player) {
        super(MessageType.FC_LOGIN);
        this.player = player;
    }


    @Override
    public String toString() {
        return "FcLoginMessage{" +
                "player=" + player +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
