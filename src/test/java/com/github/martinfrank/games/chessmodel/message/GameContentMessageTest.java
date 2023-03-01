package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.GameContent;
import com.github.martinfrank.games.chessmodel.model.Player;
import com.github.martinfrank.games.chessmodel.model.chess.Color;
import com.github.martinfrank.games.chessmodel.model.chess.Field;
import com.github.martinfrank.games.chessmodel.model.chess.Figure;
import com.github.martinfrank.games.chessmodel.model.chess.Figurine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameContentMessageTest {

    @Test
    public void doIt(){
        //given
        final String json = "{\"content\":{\"isStarted\":false,\"hostColor\":\"WHITE\",\"guestColor\":\"BLACK\",\"isHostOnline\":false,\"isGuestOnline\":false,\"startTime\":-1,\"board\":{\"lineUp\":{},\"beatenFigures\":[]}},\"msgType\":\"FS_SUBMIT_GAME_CONTENT\",\"version\":1}";
        final String json2 = "{\"content\":{\"isStarted\":false,\"hostColor\":\"WHITE\",\"guestColor\":\"BLACK\",\"isHostOnline\":false,\"isGuestOnline\":false,\"startTime\":-1,\"board\":{\"lineUp\":{\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027B\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027B\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027E\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027E\\u0027}\":{\"symbol\":\"♔\",\"color\":\"WHITE\",\"type\":\"KING\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027F\\u0027}\":{\"symbol\":\"♗\",\"color\":\"WHITE\",\"type\":\"BISHOP\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027D\\u0027}\":{\"symbol\":\"♛\",\"color\":\"BLACK\",\"type\":\"QUEEN\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027A\\u0027}\":{\"symbol\":\"♜\",\"color\":\"BLACK\",\"type\":\"ROOK\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027A\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027E\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027C\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027D\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027A\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027D\\u0027}\":{\"symbol\":\"♕\",\"color\":\"WHITE\",\"type\":\"QUEEN\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027H\\u0027}\":{\"symbol\":\"♜\",\"color\":\"BLACK\",\"type\":\"ROOK\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027D\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027B\\u0027}\":{\"symbol\":\"♞\",\"color\":\"BLACK\",\"type\":\"KNIGHT\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027C\\u0027}\":{\"symbol\":\"♝\",\"color\":\"BLACK\",\"type\":\"BISHOP\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027H\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027G\\u0027}\":{\"symbol\":\"♘\",\"color\":\"WHITE\",\"type\":\"KNIGHT\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027H\\u0027}\":{\"symbol\":\"♖\",\"color\":\"WHITE\",\"type\":\"ROOK\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027C\\u0027}\":{\"symbol\":\"♗\",\"color\":\"WHITE\",\"type\":\"BISHOP\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027A\\u0027}\":{\"symbol\":\"♖\",\"color\":\"WHITE\",\"type\":\"ROOK\"},\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027F\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027G\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027F\\u0027}\":{\"symbol\":\"♝\",\"color\":\"BLACK\",\"type\":\"BISHOP\"},\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027C\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027E\\u0027}\":{\"symbol\":\"♚\",\"color\":\"BLACK\",\"type\":\"KING\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027F\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00271\\u0027, column\\u003d\\u0027B\\u0027}\":{\"symbol\":\"♘\",\"color\":\"WHITE\",\"type\":\"KNIGHT\"},\"Field{row\\u003d\\u00272\\u0027, column\\u003d\\u0027H\\u0027}\":{\"symbol\":\"♙\",\"color\":\"WHITE\",\"type\":\"PAWN\"},\"Field{row\\u003d\\u00278\\u0027, column\\u003d\\u0027G\\u0027}\":{\"symbol\":\"♞\",\"color\":\"BLACK\",\"type\":\"KNIGHT\"},\"Field{row\\u003d\\u00277\\u0027, column\\u003d\\u0027G\\u0027}\":{\"symbol\":\"♟\",\"color\":\"BLACK\",\"type\":\"PAWN\"}},\"beatenFigures\":[]}},\"msgType\":\"FS_SUBMIT_GAME_CONTENT\",\"version\":1}";
        System.out.println("json : "+json);
        System.out.println("json2: "+json2);
        MessageParser parser = new MessageParser();

        //when
        Message message = parser.fromJson(json);
        System.out.println("message:  " + message);
        FsSubmitGameContentMessage specificMessage = (FsSubmitGameContentMessage)message;

        Message message2 = parser.fromJson(json2);
        System.out.println("message2: " + message2);
        FsSubmitGameContentMessage specificMessage2 = (FsSubmitGameContentMessage)message;


        //then
        System.out.println(specificMessage);
    }

    @Test
    public void doIt2(){
        //given
        GameContent gameContent = new GameContent(new Game(UUID.fromString("7ea85e6a-7380-4247-b08c-e3898c7b6a41"), new Player(UUID.fromString("7ea85e6a-7380-4247-b08c-e3898c7b6a42"), "testeee")));
        FsSubmitGameContentMessage message = new FsSubmitGameContentMessage(gameContent);
        System.out.println("message: "+message);

        //when
        MessageParser parser = new MessageParser();
        String json = parser.toJson(message);
        System.out.println("json: "+json);
        Message raw = parser.fromJson(json);
        System.out.println("raw: " + raw);

    }

    @Test
    public void doIt3(){
        Field field = new Field("A", "1");
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
//        Gson gson = new Gson();
        String jsonField = gson.toJson(field);
        System.out.println("json: "+jsonField);

        Figure figure = new Figure("B", Color.WHITE, Figurine.PAWN);
        String jsonFigure = gson.toJson(figure);
        System.out.println("json: "+jsonFigure);

        Map<Field, Figure> map = new HashMap<>();
        map.put(field, figure);
        String jsonMap = gson.toJson(map);
        System.out.println("json: "+jsonMap);
    }
}
