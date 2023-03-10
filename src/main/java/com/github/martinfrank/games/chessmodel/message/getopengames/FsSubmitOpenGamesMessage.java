package com.github.martinfrank.games.chessmodel.message.getopengames;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;

import java.util.List;

public class FsSubmitOpenGamesMessage extends Message {

    public final List<Game> games;

    public FsSubmitOpenGamesMessage(List<Game> games) {
        super(MessageType.FS_SUBMIT_OPEN_GAMES);
        this.games = games;
    }

    @Override
    public String toString() {
        return "FsSubmitUpdateGameMessage{" +
                "game=" + games +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
