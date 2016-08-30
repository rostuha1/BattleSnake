package client_server_I_O.client;

import client_server_I_O.classes.SnakesList;
import client_server_I_O.classes.User;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class Receiver {

    private static Logger log = Logger.getLogger(Receiver.class.getName());

    public static void receive(Socket socket) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            byte key = inputStream.readByte();

            switch (key) {
                case 9: Manager.saveSnakesList((SnakesList) inputStream.readObject()); break;
                case 12: Manager.postRegistrationProcess((Boolean) inputStream.readObject()); break;
                case 13: Manager.postAuthorizationProcess((User) inputStream.readObject()); break;
                case 14: log.info("_CLIENT_ successful operation\n"); break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
