package com.github.martinfrank.games.chessmodel.message.selectfield;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;
import com.github.martinfrank.games.chessmodel.model.chess.ChessGame;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

public class FsSubmitSelectFieldMessage extends Message {

    public final Game game;
    public final Player player;
    public final Field field;

    public FsSubmitSelectFieldMessage(Player player, Game game, Field f) {
        super(MessageType.FS_SUBMIT_SELECT_FIELD);
        this.game = game;
        this.player = player;
        this.field = f;
    }

}
