package com.github.martinfrank.games.chessmodel.message;

public class FsDeclineSelectFigureMessage extends Message{

    private final String reason;

    public FsDeclineSelectFigureMessage(String reason) {
        super(MessageType.FS_DECLINE_SELECT_FIGURE);
        this.reason = reason;
    }
}
