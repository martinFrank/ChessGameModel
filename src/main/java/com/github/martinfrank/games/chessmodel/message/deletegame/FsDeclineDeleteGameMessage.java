package com.github.martinfrank.games.chessmodel.message.deletegame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineDeleteGameMessage extends Message {

    private final String reason;

    public FsDeclineDeleteGameMessage(String reason) {
        super(MessageType.FS_DECLINE_DELETE_GAME);
        this.reason = reason;
    }
}
