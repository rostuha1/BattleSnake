package client_server_I_O;

import client_server_I_O.classes.Message;
import client_server_I_O.classes.Snake;
import client_server_I_O.classes.User;
import messages.MessageType;
import messages.Messenger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {

    private static String ADDRESS = "127.0.0.1";
    private static int PORT = 12345;
    private static Socket socket;

    static {
        try {
            socket = new Socket(ADDRESS, PORT);
        }catch (IOException e){
            Messenger.showMessage(MessageType.UNAVAILABLE_SERVER);
        }
    }

    private static void sendMessage(Message message) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException e) {}
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

    public static boolean addUser(User user){
        Message message = new Message("add", user);
        sendMessage(message);
        message = readMessage();
        return (boolean) message.getUnit();
    }

    public static User getUser(String login, String password){
        Message message = new Message("get", "user", login, password);
        sendMessage(message);
        message = readMessage();

        User user = (User) message.getUnit();

        user_interface.account.User.setInstance(Adapter.getAccountUser(user));
        return user;
    }

    public static ArrayList<Snake> getUsers(){
        Message message = new Message("get", "users");
        sendMessage(message);
        message = readMessage();
        return (ArrayList<Snake>) message.getUnit();
    }

    public static HashMap<Integer, String> getGames(){
        Message message = new Message("get", "games");
        sendMessage(message);
        message = readMessage();
        return (HashMap<Integer, String>) message.getUnit();
    }

    public static boolean updateUser(User user){
        Message message = new Message("update", user);
        sendMessage(message);
        message = readMessage();
        return (boolean) message.getUnit();
    }

    public static User startGame(String username1, String username2, String username3, String username4){
        Message message = new Message("start", username1, username2, username3, username4);
        sendMessage(message);
        message = readMessage();
        return (User) message.getUnit();
    }

}

