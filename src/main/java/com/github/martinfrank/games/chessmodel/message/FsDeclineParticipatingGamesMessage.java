package com.github.martinfrank.games.chessmodel.message;

public class FsDeclineParticipatingGamesMessage extends Message{

    private final String reason;

    public FsDeclineParticipatingGamesMessage(String reason) {
        super(MessageType.FS_DECLINE_PARTICIPATING_GAMES);
        this.reason = reason;
    }
}
