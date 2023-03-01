package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;

public class FsConfirmJoinGamesMessage extends Message{

    public final Player player;
    public Game game;

    public FsConfirmJoinGamesMessage(Player player, Game game) {
        super(MessageType.FS_CONFIRM_JOIN_GAME);
        this.player = player;
        this.game = game;
    }

    @Override
    public String toString() {
        return "FsConfirmJoinGamesMessage{" +
                "player=" + player +
                ", game=" + game +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
