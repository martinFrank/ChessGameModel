package com.github.martinfrank.games.chessmodel.message;

public class Message {
    public final MessageType msgType;
    public int version = 1;

    //order:
    //1) PLAYER
    //2) GAME
    public Message (MessageType msgType ){
        this.msgType = msgType;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgType=" + msgType +
                ", version=" + version +
                '}';
    }
}
