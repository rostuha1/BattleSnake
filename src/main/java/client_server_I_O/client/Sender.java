package client_server_I_O.client;

import client_server_I_O.I_O_KEYS;
import client_server_I_O.classes.Snake;
import client_server_I_O.classes.SnakePlayer;
import client_server_I_O.classes.User;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import user_interface.account.content.intelligence.card_elements.Card;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {

    private static void send(byte key, long userId, Object o, Socket socket) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeByte(key);
            outputStream.writeLong(userId);
            outputStream.writeObject(o);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendUser(long userId, User user, Socket socket) {
        send(I_O_KEYS.USER.key, userId, user, socket);
    }

    public static void sendCards(long userId, Card[][] cards, Socket socket) {
        send(I_O_KEYS.CARDS.key, userId, cards, socket);
    }

    public static void sendSnakePlayer(long userId, SnakePlayer snakePlayer, Socket socket) {
        send(I_O_KEYS.SNAKE_PLAYER.key, userId, snakePlayer, socket);
    }

    public static void sendAvatar(long userId, Image avatar, Socket socket) {
        send(I_O_KEYS.AVATAR.key, userId, avatar, socket);
    }

    public static void sendName(long userId, String name, Socket socket) {
        send(I_O_KEYS.NAME.key, userId, name, socket);
    }

    public static void sendColor(long userId, Color color, Socket socket) {
        send(I_O_KEYS.COLOR.key, userId, color, socket);
    }

    public static void sendAbout(long userId, String about, Socket socket) {
        send(I_O_KEYS.ABOUT.key, userId, about, socket);
    }

    public static void sendSnake(long userId, Snake snake, Socket socket) {
        send(I_O_KEYS.SNAKE.key, userId, snake, socket);
    }

    public static void registration(String login, String password, Socket socket) {
        singingInUp(I_O_KEYS.REGISTRATION, login, password, socket);
        Receiver.receive(socket);
    }

    public static void authorization(String login, String password, Socket socket) {
        singingInUp(I_O_KEYS.AUTHORIZATION, login, password, socket);
        Receiver.receive(socket);
    }

    private static void singingInUp(I_O_KEYS action, String login, String password, Socket socket) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        send(action.key, -1L, user, socket);
        Receiver.receive(socket);
    }

}
