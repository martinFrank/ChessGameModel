package com.github.martinfrank.games.chessmodel.message.getopengames;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsDeclineOpenGamesMessage extends Message {

    private final String reason;

    public FsDeclineOpenGamesMessage(String reason) {
        super(MessageType.FS_DECLINE_OPEN_GAMES);
        this.reason = reason;
    }
}
