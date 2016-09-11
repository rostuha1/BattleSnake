package client_server_I_O;

import client_server_I_O.classes.Message;
import client_server_I_O.classes.Turn;
import client_server_I_O.classes.User;
import javafx.application.Platform;
import messages.MessageType;
import messages.Messenger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadFactory;

public class Client {

    private static String ADDRESS = "127.0.0.1";
    private static int PORT = 12345;
    private static Socket socket;

    private static Thread connectionThread;

    static {
        try {
            socket = new Socket(ADDRESS, PORT);
        } catch (IOException e) {
            Platform.runLater(() -> Messenger.showMessage(MessageType.UNAVAILABLE_SERVER));
            connectionThread = new Thread(() -> {
                while (true) {
                    try {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignored) {
                        }
                        socket = new Socket(ADDRESS, PORT);
                        Platform.runLater(() -> Messenger.showMessage(MessageType.SERVER_CONNECTED));
                        return;
                    } catch (IOException ignored) {
                    }
                }
            });
            connectionThread.start();
        }
    }

    public static Thread getConnectionThread() {
        return connectionThread;
    }

    private static void sendMessage(Message message) {
        try {
            if (socket == null) connectionThread.join();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (Exception ignored) {
        }
    }

    private static Message readMessage() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            return (Message) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("can't read message");
            return null;
        }
    }

    public static boolean addUser(User user) {
        Message message = new Message("add", user);
        sendMessage(message);
        message = readMessage();
        return (boolean) message.getUnit();
    }

    public static User getUser(String login, String password) {
        Message message = new Message("get", "user", login, password);
        sendMessage(message);
        message = readMessage();

        User user = (User) message.getUnit();

        user_interface.account.User.setInstance(Adapter.getAccountUser(user));
        return user;
    }

    public static ArrayList<User> getUsers() {
        String login = user_interface.account.User.getInstance().getLogin();
        Message message = new Message("get", "users", login);
        sendMessage(message);
        message = readMessage();
        return (ArrayList<User>) message.getUnit();
    }

    public static HashMap<Integer, String> getGames() {
        Message message = new Message("get", "games");
        sendMessage(message);
        message = readMessage();
        return (HashMap<Integer, String>) message.getUnit();
    }

    public static boolean updateUser(User user) {
        Message message = new Message("update", user);
        sendMessage(message);
        message = readMessage();
        return (boolean) message.getUnit();
    }

    public static ArrayList<Turn> getGameResult(String username1, String username2, String username3, String username4) {
        Message message = new Message("start", username1, username2, username3, username4);
        sendMessage(message);
        message = readMessage();
        return (ArrayList<Turn>) message.getUnit();
    }

}

