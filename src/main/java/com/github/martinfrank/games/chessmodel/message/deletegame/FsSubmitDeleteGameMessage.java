package com.github.martinfrank.games.chessmodel.message.deletegame;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;

public class FsSubmitDeleteGameMessage extends Message {

    public final Player player;
    public final Game game;

    public FsSubmitDeleteGameMessage(Player player, Game game) {
        super(MessageType.FS_SUBMIT_DELETE_GAME);
        this.player = player;
        this.game = game;
    }

    @Override
    public String toString() {
        return "FsSubmitDeleteGameMessage{" +
                "player=" + player +
                ", game=" + game +
                ", msgType=" + msgType +
                '}';
    }
}
