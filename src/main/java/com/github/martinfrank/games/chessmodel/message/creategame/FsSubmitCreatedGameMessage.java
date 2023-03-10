package com.github.martinfrank.games.chessmodel.message.creategame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;

public class FsSubmitCreatedGameMessage extends Message {

    public final Game game;

    public FsSubmitCreatedGameMessage(Game game) {
        super(MessageType.FS_SUBMIT_CREATED_GAME);
        this.game = game;
    }
}
