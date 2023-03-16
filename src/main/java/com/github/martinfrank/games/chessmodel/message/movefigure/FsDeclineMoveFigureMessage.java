package com.github.martinfrank.games.chessmodel.message.movefigure;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineMoveFigureMessage extends Message {

    public final String reason;

    public FsDeclineMoveFigureMessage(String reason) {
        super(MessageType.FS_DECLINE_MOVE_FIGURE);
        this.reason = reason;
    }

}
