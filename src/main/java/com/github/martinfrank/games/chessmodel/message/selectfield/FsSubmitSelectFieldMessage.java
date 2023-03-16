package com.github.martinfrank.games.chessmodel.message.selectfield;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.GameContent;
import com.github.martinfrank.games.chessmodel.model.chess.Field;
import com.github.martinfrank.games.chessmodel.model.chess.Figure;

import java.util.List;

public class FsSubmitSelectFieldMessage extends Message {

    public final Game game;
    public final GameContent gameContent;

    public FsSubmitSelectFieldMessage(Game game, GameContent gameContent) {
        super(MessageType.FS_SUBMIT_SELECT_FIELD);
        this.game = game;
        this.gameContent = gameContent;
    }

}
