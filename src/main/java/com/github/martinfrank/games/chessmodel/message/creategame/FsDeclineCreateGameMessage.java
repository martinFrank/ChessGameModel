package com.github.martinfrank.games.chessmodel.message.creategame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineCreateGameMessage extends Message {

    public final String reason;

    public FsDeclineCreateGameMessage(String reason) {
        super(MessageType.FS_DECLINE_CREATE_GAME);
        this.reason = reason;
    }
}
