package com.github.martinfrank.games.chessmodel.message.selectColor;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;
import com.github.martinfrank.games.chessmodel.model.Game;

public class FsSubmitSelectColorMessage extends Message {

    public final Game game;
    public String changes;

    public FsSubmitSelectColorMessage(Game game, String changes) {
        super(MessageType.FS_SUBMIT_SELECT_COLOR);
        this.game = game;
        this.changes = changes;
    }

    @Override
    public String toString() {
        return "FsSubmitSelectColorMessage{" +
                "game=" + game +
                ", changes='" + changes + '\'' +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
