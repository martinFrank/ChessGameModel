package com.github.martinfrank.games.chessmodel.message.startgame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineStartGameMessage extends Message {

    public final String reason;

    public FsDeclineStartGameMessage(String reason) {
        super(MessageType.FS_DECLINE_START_GAME);
        this.reason = reason;
    }
}
