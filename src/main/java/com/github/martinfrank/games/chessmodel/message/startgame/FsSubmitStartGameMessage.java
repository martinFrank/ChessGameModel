package com.github.martinfrank.games.chessmodel.message.startgame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.GameContent;

public class FsSubmitStartGameMessage extends Message {

    public final Game game;
    public final GameContent content;

    public FsSubmitStartGameMessage(Game game, GameContent content) {
        super(MessageType.FS_SUBMIT_START_GAME);
        this.game = game;
        this.content = content;
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
