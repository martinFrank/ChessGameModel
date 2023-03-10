package com.github.martinfrank.games.chessmodel.message.selectfield;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineSelectFieldMessage extends Message {

    private final String reason;

    public FsDeclineSelectFieldMessage(String reason) {
        super(MessageType.FS_DECLINE_SELECT_FIELD);
        this.reason = reason;
    }
}
