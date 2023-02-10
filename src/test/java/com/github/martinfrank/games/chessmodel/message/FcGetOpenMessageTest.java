package com.github.martinfrank.games.chessmodel.message;

import org.junit.Test;

public class FcGetOpenMessageTest {

    @Test
    public void doIt(){
        String json = "{\"player\":{\"playerId\":\"ad53a318-7371-448e-a901-00643a86d834\",\"playerName\":\"Player\"},\"msgType\":\"FC_GET_OPEN_GAMES\",\"version\":1}";
        MessageParser messageParser = new MessageParser();
        Message message = messageParser.fromJson(json);

        System.out.println(message);
    }
}
