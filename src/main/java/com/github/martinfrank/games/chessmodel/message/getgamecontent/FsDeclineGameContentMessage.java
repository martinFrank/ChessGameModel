package com.github.martinfrank.games.chessmodel.message.getgamecontent;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineGameContentMessage extends Message {

    public final String reason;

    public FsDeclineGameContentMessage(String reason) {
        super(MessageType.FS_DECLINE_GAME_CONTENT);
        this.reason = reason;
    }

}
