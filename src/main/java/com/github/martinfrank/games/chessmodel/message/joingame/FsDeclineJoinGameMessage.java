package com.github.martinfrank.games.chessmodel.message.joingame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineJoinGameMessage extends Message {

    private final String reason;

    public FsDeclineJoinGameMessage(String reason) {
        super(MessageType.FS_DECLINE_JOIN_GAME);
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "FsDeclineJoinGameMessage{" +
                "reason='" + reason + '\'' +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
