package com.github.martinfrank.games.chessmodel.message.login;

import com.github.martinfrank.games.chessmodel.message.Message;
import com.github.martinfrank.games.chessmodel.message.MessageType;

public class FsSubmitLoginMessage extends Message {

    public final String loginConfirmationMessage = "login confirmed";

    public FsSubmitLoginMessage() {
        super(MessageType.FS_SUBMIT_LOGIN);
    }

    @Override
    public String toString() {
        return "FsConfirmLoginMessage{" +
                "loginConfirmationMessage='" + loginConfirmationMessage + '\'' +
                ", msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
