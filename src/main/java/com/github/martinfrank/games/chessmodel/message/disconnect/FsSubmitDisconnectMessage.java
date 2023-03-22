package com.github.martinfrank.games.chessmodel.message.disconnect;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;

public class FsSubmitDisconnectMessage extends Message {

    public final Player player;
    public final Game game;

    public FsSubmitDisconnectMessage(Player player, Game game) {
        super(MessageType.FS_SUBMIT_DISCONNECT);
        this.player = player;
        this.game = game;
    }

    @Override
    public String toString() {
        return "FsSubmitDisconnectMessage{" +
                "player=" + player +
                ", game=" + game +
                ", msgType=" + msgType +
                '}';
    }
}
