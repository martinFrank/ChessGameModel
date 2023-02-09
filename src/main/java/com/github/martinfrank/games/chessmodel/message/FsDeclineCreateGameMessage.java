package com.github.martinfrank.games.chessmodel.message;

public class FsDeclineCreateGameMessage extends Message{

    public final String reason;

    public FsDeclineCreateGameMessage(String reason) {
        super(MessageType.FS_DECLINE_CREATE_GAME);
        this.reason = reason;
    }
}
