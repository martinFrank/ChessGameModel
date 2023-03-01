package com.github.martinfrank.games.chessmodel.model;

import com.github.martinfrank.games.chessmodel.message.FcStartGameMessage;
import com.github.martinfrank.games.chessmodel.message.MessageParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageParser.class);

    private final Gson gson;

    public ModelParser() {
        gson = new GsonBuilder().enableComplexMapKeySerialization().create();
    }

    public Game gameFromJson(String jsonStr) {
        try {
            return gson.fromJson(jsonStr, Game.class);
        } catch (JsonSyntaxException | NullPointerException e) {
            LOGGER.debug("error parsing Game from json: " + e);
            return null;
        }
    }

    public String gameToJson(Game game) {
        try {
            return gson.toJson(game);
        } catch (JsonParseException | NullPointerException e) {
            LOGGER.debug("error creating json from Game: " + e);
        }
        return null;
    }

    public Player playerFromJson(String jsonStr) {
        try {
            return gson.fromJson(jsonStr, Player.class);
        } catch (JsonParseException | NullPointerException e) {
            LOGGER.debug("error parsing Player from json: " + e);
        }
        return null;
    }

    public String playerToJson(Player player) {
        try {
            return gson.toJson(player);
        } catch (JsonParseException | NullPointerException e) {
            LOGGER.debug("error creating json from Player: " + e);
        }
        return null;

    }
}
