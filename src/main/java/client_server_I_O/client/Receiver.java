package client_server_I_O.client;

import client_server_I_O.classes.SnakesList;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {

    public static void receive(Socket socket) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            byte key = inputStream.readByte();

            switch (key) {
                case 9: Manager.saveSnakesList((SnakesList) inputStream.readObject()); break;
                case 10: Manager.registration((Boolean) inputStream.readObject()); break;
                case 11: Manager.authorization((Boolean) inputStream.readObject()); break;
                case 12: Manager.postRegistrationProcess((Boolean) inputStream.readObject()); break;
                case 13: Manager.postAuthorizationProcess((Boolean) inputStream.readObject()); break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
