package client_server_I_O.client;

import client_server_I_O.I_O_KEYS;
import client_server_I_O.classes.Avatar;
import client_server_I_O.classes.Snake;
import client_server_I_O.classes.SnakePlayer;
import client_server_I_O.classes.User;
import javafx.scene.image.Image;
import user_interface.account.content.intelligence.card_elements.Card;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {

    private static Socket socket;

    private static void send(byte key, long userId, Object o) {
        try {
            socket = Connection.create();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeByte(key);
            outputStream.writeLong(userId);
            outputStream.writeObject(o);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Receiver.receive(socket);
    }

    public static void sendUser(long userId, User user) {
        send(I_O_KEYS.USER.key, userId, user);
    }

    public static void sendCards(long userId, Card[][] cards) {
        send(I_O_KEYS.CARDS.key, userId, cards);
    }

    public static void sendSnakePlayer(long userId, SnakePlayer snakePlayer) {
        send(I_O_KEYS.SNAKE_PLAYER.key, userId, snakePlayer);
    }

    public static void sendAvatar(long userId, Avatar avatar) {
        send(I_O_KEYS.AVATAR.key, userId, avatar);
    }

    public static void sendName(long userId, String name) {
        send(I_O_KEYS.NAME.key, userId, name);
    }

    public static void sendColor(long userId, String color) {
        send(I_O_KEYS.COLOR.key, userId, color);
    }

    public static void sendAbout(long userId, String about) {
        send(I_O_KEYS.ABOUT.key, userId, about);
    }

    public static void sendSnake(long userId, Snake snake) {
        send(I_O_KEYS.SNAKE.key, userId, snake);
    }

    public static void registration(String login, String password) {
        singingInUp(I_O_KEYS.REGISTRATION, login, password);
    }

    public static void authorization(String login, String password) {
        singingInUp(I_O_KEYS.AUTHORIZATION, login, password);
    }

    private static void singingInUp(I_O_KEYS action, String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        send(action.key, -1L, user);
        Receiver.receive(socket);
    }

}
