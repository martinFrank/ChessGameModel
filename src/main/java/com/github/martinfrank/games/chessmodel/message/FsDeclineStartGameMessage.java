package com.github.martinfrank.games.chessmodel.message;

public class FsDeclineStartGameMessage extends Message{

    public final String reason;

    public FsDeclineStartGameMessage(String reason) {
        super(MessageType.FS_DECLINE_CREATE_GAME);
        this.reason = reason;
    }
}
