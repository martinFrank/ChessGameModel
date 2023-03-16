package com.github.martinfrank.games.chessmodel.message.movefigure;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;
import com.github.martinfrank.games.chessmodel.model.chess.Field;

import java.util.UUID;

public class FcMoveFigureMessage extends Message {

    public final Player player;
    public final UUID gameId;
    public final Field from;
    public final Field to;

    public FcMoveFigureMessage(Player player, UUID gameId, Field from, Field to) {
        super(MessageType.FC_MOVE_FIGURE);
        this.player = player;
        this.gameId = gameId;
        this.from = from;
        this.to = to;
    }

}
