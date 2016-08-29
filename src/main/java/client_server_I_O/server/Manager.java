package client_server_I_O.server;

import client_server_I_O.classes.Snake;
import client_server_I_O.classes.SnakePlayer;
import client_server_I_O.classes.User;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import user_interface.account.content.intelligence.card_elements.Card;

import java.net.Socket;

public class Manager {

    // some methods to save, update etc

    public static void saveUser(long userId, User user) {

    }

    public static void saveCards(long userId, Card[][] cards) {

    }

    public static void saveSnakePlayer(long userId, SnakePlayer snakePlayer) {

    }

    public static void saveAvatar(long userId, Image avatar) {

    }

    public static void saveName(long userId, String name) {

    }

    public static void saveColor(long userId, Color color) {

    }

    public static void saveAbout(long userId, String about) {

    }

    public static void saveSnake(long userId, Snake snake) {

    }

    public static void registration(User user, Socket socket) {

//        Sender.registration( responce );
    }

    public static void authorization(User user, Socket socket) {

//        Sender.authorization( responce );
    }

}
