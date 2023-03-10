package com.github.martinfrank.games.chessmodel.message;

import com.github.martinfrank.games.chessmodel.message.creategame.FcCreateGameMessage;
import com.github.martinfrank.games.chessmodel.message.getgamecontent.FcGetGameContentMessage;
import com.github.martinfrank.games.chessmodel.message.getgamecontent.FsDeclineGameContentMessage;
import com.github.martinfrank.games.chessmodel.message.getgamecontent.FsSubmitGameContentMessage;
import com.github.martinfrank.games.chessmodel.message.getopengames.FcGetOpenGamesMessage;
import com.github.martinfrank.games.chessmodel.message.getopengames.FsSubmitOpenGamesMessage;
import com.github.martinfrank.games.chessmodel.message.getparticipatinggames.FcGetParticipatingGamesMessage;
import com.github.martinfrank.games.chessmodel.message.getparticipatinggames.FsDeclineParticipatingGamesMessage;
import com.github.martinfrank.games.chessmodel.message.getparticipatinggames.FsSubmitParticipatingGamesMessage;
import com.github.martinfrank.games.chessmodel.message.login.FcLoginMessage;
import com.github.martinfrank.games.chessmodel.message.login.FsSubmitLoginMessage;
import com.github.martinfrank.games.chessmodel.message.selectfield.FcSelectFieldMessage;
import com.github.martinfrank.games.chessmodel.message.selectfield.FsDeclineSelectFieldMessage;
import com.github.martinfrank.games.chessmodel.message.selectfield.FsSubmitSelectFieldMessage;
import com.github.martinfrank.games.chessmodel.message.startgame.FcStartGameMessage;
import com.github.martinfrank.games.chessmodel.message.creategame.FsDeclineCreateGameMessage;
import com.github.martinfrank.games.chessmodel.message.creategame.FsSubmitCreatedGameMessage;
import com.github.martinfrank.games.chessmodel.message.joingame.FcJoinGameMessage;
import com.github.martinfrank.games.chessmodel.message.joingame.FsConfirmJoinGamesMessage;
import com.github.martinfrank.games.chessmodel.message.joingame.FsDeclineJoinGameMessage;
import com.github.martinfrank.games.chessmodel.message.selectColor.FcSelectColorMessage;
import com.github.martinfrank.games.chessmodel.message.selectColor.FsDeclineSelectColorMessage;
import com.github.martinfrank.games.chessmodel.message.selectColor.FsSubmitSelectColorMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageParser.class);
    private final Gson gson;

    public MessageParser(){
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    }

    public Message fromJson(String jsonStr) {
        Message message;
        try {
            message = gson.fromJson(jsonStr, Message.class);
            switch (message.msgType) {
                case FC_LOGIN: return gson.fromJson(jsonStr, FcLoginMessage.class);
                case FS_SUBMIT_LOGIN: return gson.fromJson(jsonStr, FsSubmitLoginMessage.class);
                //FIXME decline?

                case FC_GET_PARTICIPATING_GAMES: return gson.fromJson(jsonStr, FcGetParticipatingGamesMessage.class);
                case FS_SUBMIT_PARTICIPATING_GAMES: return gson.fromJson(jsonStr, FsSubmitParticipatingGamesMessage.class);
                case FS_DECLINE_PARTICIPATING_GAMES: return gson.fromJson(jsonStr, FsDeclineParticipatingGamesMessage.class);

                case FC_GET_OPEN_GAMES: return gson.fromJson(jsonStr, FcGetOpenGamesMessage.class);
                case FS_SUBMIT_OPEN_GAMES: return gson.fromJson(jsonStr, FsSubmitOpenGamesMessage.class);
                //FIXME decline?

                case FC_CREATE_GAME: return gson.fromJson(jsonStr, FcCreateGameMessage.class);
                case FS_SUBMIT_CREATED_GAME: return gson.fromJson(jsonStr, FsSubmitCreatedGameMessage.class);
                case FS_DECLINE_CREATE_GAME: return gson.fromJson(jsonStr, FsDeclineCreateGameMessage.class);

                case FC_SELECT_COLOR: return gson.fromJson(jsonStr, FcSelectColorMessage.class);
                case FS_SUBMIT_SELECT_COLOR: return gson.fromJson(jsonStr, FsSubmitSelectColorMessage.class);
                case FS_DECLINE_SELECT_COLOR: return gson.fromJson(jsonStr, FsDeclineSelectColorMessage.class);

                case FC_SELECT_FIELD: return gson.fromJson(jsonStr, FcSelectFieldMessage.class);
                case FS_SUBMIT_SELECT_FIELD: return gson.fromJson(jsonStr, FsSubmitSelectFieldMessage.class);
                case FS_DECLINE_SELECT_FIELD: return gson.fromJson(jsonStr, FsDeclineSelectFieldMessage.class);

                case FC_JOIN_GAME: return gson.fromJson(jsonStr, FcJoinGameMessage.class);
                case FS_CONFIRM_JOIN_GAME: return gson.fromJson(jsonStr, FsConfirmJoinGamesMessage.class);
                case FS_DECLINE_JOIN_GAME: return gson.fromJson(jsonStr, FsDeclineJoinGameMessage.class);

                case FC_GET_GAME_CONTENT: return gson.fromJson(jsonStr, FcGetGameContentMessage.class);
                case FS_DECLINE_GAME_CONTENT: return gson.fromJson(jsonStr, FsDeclineGameContentMessage.class);
                case FS_SUBMIT_GAME_CONTENT: return gson.fromJson(jsonStr, FsSubmitGameContentMessage.class);

                //open stuff
                case FC_START_GAME: return gson.fromJson(jsonStr, FcStartGameMessage.class);

                //FIXME unrequired class
                case FS_SUBMIT_UPDATE_GAME: return gson.fromJson(jsonStr, FsSubmitUpdateGameMessage.class);



            }
        } catch (JsonParseException e) {
            message = new Message(MessageType.UNKNOWN);
            LOGGER.debug("Exception: " + e);
        }
        return message;
    }

    public String toJson(Message message) {
        try {
            return gson.toJson(message);
        } catch (JsonParseException e) {
            return gson.toJson(message);
        }
    }
}
