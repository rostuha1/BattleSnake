package client_server_I_O.server;

import client_server_I_O.classes.Avatar;
import client_server_I_O.classes.Snake;
import client_server_I_O.classes.SnakePlayer;
import client_server_I_O.classes.User;
import user_interface.account.content.intelligence.card_elements.Card;

import java.net.Socket;
import java.util.logging.Logger;

public class Manager {

    private static Logger log = Logger.getLogger(Manager.class.getName());

    public static void saveUser(long userId, User user) {
        // ToDo
        log.info("_SERVER_ received user");
    }

    public static void saveCards(long userId, Card[][] cards) {
        // ToDo
        log.info("_SERVER_ received cards");
    }

    public static void saveSnakePlayer(long userId, SnakePlayer snakePlayer) {
        // ToDo
        log.info("_SERVER_ received snakePlayer");
    }

    public static void saveAvatar(long userId, Avatar avatar) {
        // ToDo
        log.info("_SERVER_ received avatar");
    }

    public static void saveName(long userId, String name) {
        // ToDo
        log.info("_SERVER_ received name");
    }

    public static void saveColor(long userId, String color) {
        // ToDo
        log.info("_SERVER_ received color");
    }

    public static void saveAbout(long userId, String about) {
        // ToDo
        log.info("_SERVER_ received about");
    }

    public static void saveSnake(long userId, Snake snake) {
        // ToDo
        log.info("_SERVER_ received snake");
    }

    public static void registration(User user, Socket socket) {
        log.info("_SERVER_receive user");
        // ToDo
        Sender.sendRegistrationResponse(Boolean.TRUE, socket);
    }

    public static void authorization(User user, Socket socket) {
        log.info("_SERVER_authorization");
        // ToDo
        Sender.sendAuthorizationResponse(user, socket);
    }

}
