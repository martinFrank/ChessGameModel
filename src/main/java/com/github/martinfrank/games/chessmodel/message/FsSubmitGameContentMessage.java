package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.GameContent;

public class FsSubmitGameContentMessage extends Message{

    public final GameContent content;

    public FsSubmitGameContentMessage(GameContent content) {
        super(MessageType.FS_SUBMIT_GAME_CONTENT);
        this.content = content;
    }

    @Override
    public String toString() {
        return "FsSubmitGameContentMessage{" +
                "content=" + content +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
