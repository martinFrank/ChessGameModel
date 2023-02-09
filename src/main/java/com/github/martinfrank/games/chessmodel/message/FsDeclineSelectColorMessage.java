package com.github.martinfrank.games.chessmodel.message;

public class FsDeclineSelectColorMessage extends Message{

    private final String reason;

    public FsDeclineSelectColorMessage(String reason) {
        super(MessageType.FS_DECLINE_SELECT_COLOR);
        this.reason = reason;
    }
}
