package com.github.martinfrank.games.chessmodel.message.movefigure;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

public class FsSubmitMoveFigureMessage extends Message {

    public final Player player;
    public final Game game;
    public final Field from;
    public final Field to;

    public FsSubmitMoveFigureMessage(Player player, Game game, Field from, Field to) {
        super(MessageType.FS_SUBMIT_MOVE_FIGURE);
        this.player = player;
        this.game = game;
        this.from = from;
        this.to = to;
    }
}
