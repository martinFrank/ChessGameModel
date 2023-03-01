package com.github.martinfrank.games.chessmodel.message;

public class FsDeclineGameContentMessage extends Message{

    public final String reason;

    public FsDeclineGameContentMessage(String reason) {
        super(MessageType.FS_DECLINE_GAME_CONTENT);
        this.reason = reason;
    }

}
