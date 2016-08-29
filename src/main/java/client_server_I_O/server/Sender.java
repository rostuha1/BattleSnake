package client_server_I_O.server;

import client_server_I_O.classes.SnakesList;
import client_server_I_O.classes.User;

import java.io.ObjectOutputStream;
import java.net.Socket;

import static client_server_I_O.I_O_KEYS.*;

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

    public static void sendSnakesList (SnakesList list, Socket socket) {
        send(SNAKES_LIST.key, list, socket);
    }

    public static void registration (Boolean isSuccessful, Socket socket) {
        send(POST_REGISTRATION.key, isSuccessful, socket);
    }

    public static void authorization (User user, Socket socket) {
        send(POST_AUTHORIZATION.key, user, socket);
    }

}
