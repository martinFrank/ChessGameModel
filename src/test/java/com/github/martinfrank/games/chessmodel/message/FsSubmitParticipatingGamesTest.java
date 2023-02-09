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

    private static final String TEST_NAME_A = "a-name";
    private static final String TEST_NAME_B = "b-name";

    @Test
    public void testFsSubmitServerInfoMessageToJson(){
        Player aPlayer = new Player(TEST_ID_A, TEST_NAME_A);
        Player bPlayer = new Player(TEST_ID_B, TEST_NAME_B);
        Game aGame = new Game(aPlayer); //offenes
        Game bGame = new Game(aPlayer); //mit teilnehmer b
        bGame.setGuestPlayer(bPlayer);
        Game cGame = new Game(bPlayer); //offenes
        Game dGame = new Game(bPlayer); //mit Teilnehmer a
        dGame.setGuestPlayer(aPlayer);
        List<Game> games = Arrays.asList(aGame, bGame, cGame);

        FsSubmitParticipatingGamesMessage fsSubmitParticipatingGamesMessage = new FsSubmitParticipatingGamesMessage(games);
    }
}