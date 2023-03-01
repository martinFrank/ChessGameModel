package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;

import java.util.UUID;

public class FcGetGameContentMessage extends Message{

    public final Player player;
    public final Game game;

    public FcGetGameContentMessage(Player player, Game game) {
        super(MessageType.FC_GET_GAME_CONTENT);
        this.player = player;
        this.game = game;
    }

}
