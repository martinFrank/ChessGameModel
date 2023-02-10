package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.model.Game;
import com.github.martinfrank.games.chessmodel.model.Player;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FsSubmitParticipatingGamesTest {

    private static final UUID TEST_ID_A = UUID.fromString("f62b659a-30ae-465b-8765-0096519dee70");
    private static final UUID TEST_ID_B = UUID.fromString("f62b659a-30ae-465b-8765-0096519dee71");

    private static final UUID TEST_GAME_A = UUID.fromString("f62b659a-30ae-465b-8765-0096519dee60");
    private static final UUID TEST_GAME_B = UUID.fromString("f62b659a-30ae-465b-8765-0096519dee61");
    private static final UUID TEST_GAME_C = UUID.fromString("f62b659a-30ae-465b-8765-0096519dee62");
    private static final UUID TEST_GAME_D = UUID.fromString("f62b659a-30ae-465b-8765-0096519dee63");

    private static final String TEST_NAME_A = "a-name";
    private static final String TEST_NAME_B = "b-name";

    @Test
    public void testFsSubmitServerInfoMessageToJson(){
        Player aPlayer = new Player(TEST_ID_A, TEST_NAME_A);
        Player bPlayer = new Player(TEST_ID_B, TEST_NAME_B);
        Game aGame = new Game(TEST_GAME_A, aPlayer); //offenes
        Game bGame = new Game(TEST_GAME_B, aPlayer); //mit teilnehmer b
        bGame.setGuestPlayer(bPlayer);
        Game cGame = new Game(TEST_GAME_C, bPlayer); //offenes
        Game dGame = new Game(TEST_GAME_D, bPlayer); //mit Teilnehmer a
        dGame.setGuestPlayer(aPlayer);
        List<Game> games = Arrays.asList(aGame, bGame, cGame);

        FsSubmitParticipatingGamesMessage fsSubmitParticipatingGamesMessage = new FsSubmitParticipatingGamesMessage(games);
    }

    @Test
    public void doIt(){
        String json = "{\"participatingGames\":[],\"msgType\":\"FS_SUBMIT_PARTICIPATING_GAMES\",\"version\":1}";
        MessageParser parser = new MessageParser();
        Message message = parser.fromJson(json);
        System.out.println(message);
        FsSubmitParticipatingGamesMessage submitMessage = (FsSubmitParticipatingGamesMessage) message;
        System.out.println(submitMessage);
    }

    @Test
    public void doItAgain(){
        String json = "{\"participatingGames\":[{\"gameId\":\"d20e6db3-69bb-4c89-a552-4835812bf62a\",\"hostPlayer\":{\"playerId\":\"ad53a318-7371-448e-a901-00643a86d834\",\"playerName\":\"Player\"},\"hostColor\":\"WHITE\",\"guestColor\":\"BLACK\",\"isStarted\":false,\"isHostOnline\":true,\"isGuestOnline\":false,\"startTime\":-1}],\"msgType\":\"FS_SUBMIT_PARTICIPATING_GAMES\",\"version\":1}";
        MessageParser parser = new MessageParser();
        Message message = parser.fromJson(json);
        System.out.println(message);
        FsSubmitParticipatingGamesMessage submitMessage = (FsSubmitParticipatingGamesMessage) message;
        System.out.println(submitMessage);
    }
}