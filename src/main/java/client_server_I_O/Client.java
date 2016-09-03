package client_server_I_O;

import client_server_I_O.classes.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client {

    private Socket socket;

    public Client(String address, int port){
        try {
            socket = new Socket(address, port);
        }catch (IOException e){
            System.out.println("server connect error");
        }
    }

    private void sendMessage(Message message) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException e) {}
    }

    private Message readMessage() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            return (Message) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("can't read message");
            return null;
        }
    }

    public boolean addUser(User user){
        Message message = new Message("add", user);
        sendMessage(message);
        message = readMessage();
        return (boolean) message.getUnit();
    }

    public User getUser(String login, String password){
        Message message = new Message("add", "user", login, password);
        sendMessage(message);
        message = readMessage();
        return (User) message.getUnit();
    }

    public ArrayList<User> getUsers(){
        Message message = new Message("get", "users");
        sendMessage(message);
        message = readMessage();
        return (ArrayList<User>) message.getUnit();
    }

    public HashMap<Integer, String> getGames(){
        Message message = new Message("get", "games");
        sendMessage(message);
        message = readMessage();
        return (HashMap<Integer, String>) message.getUnit();
    }

    public boolean updateUser(User user){
        Message message = new Message("update", user);
        sendMessage(message);
        message = readMessage();
        return (boolean) message.getUnit();
    }

    public User startGame(String username1, String username2, String username3, String username4){
            Message message = new Message("start", username1, username2, username3, username4);
        sendMessage(message);
        message = readMessage();
        return (User) message.getUnit();
    }

}

