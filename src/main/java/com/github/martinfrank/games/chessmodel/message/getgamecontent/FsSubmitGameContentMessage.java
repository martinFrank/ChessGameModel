package com.github.martinfrank.games.chessmodel.message.getgamecontent;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;

public class FsSubmitGameContentMessage extends Message {

    public final Game game;

    public FsSubmitGameContentMessage(Game game) {
        super(MessageType.FS_SUBMIT_GAME_CONTENT);
        this.game = game;
    }

    @Override
    public String toString() {
        return "FsSubmitGameContentMessage{" +
                "game=" + game +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
