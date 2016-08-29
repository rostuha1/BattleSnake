package client_server_I_O.server;

import client_server_I_O.classes.SnakesList;
import client_server_I_O.classes.User;
import client_server_I_O.I_O_KEYS;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {

    private static void send(byte key, Object o, Socket socket) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeByte(key);
            outputStream.writeObject(o);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendUser(User user, Socket socket) {
        send(I_O_KEYS.USER.key, user, socket);
    }

    public static void sendSnakesList (SnakesList list, Socket socket) {
        send(I_O_KEYS.SNAKES_LIST.key, list, socket);
    }

    public static void registration (Boolean isSuccessful, Socket socket) {
        send(I_O_KEYS.REGISTRATION.key, isSuccessful, socket);
    }

    public static void authorization (Boolean isSuccessful, Socket socket) {
        send(I_O_KEYS.AUTHORIZATION.key, isSuccessful, socket);
    }

}
