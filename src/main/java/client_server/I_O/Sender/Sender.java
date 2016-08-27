package client_server.I_O.Sender;

import client_server.I_O.SnakePlayer;
import javafx.collections.ObservableList;

public class Sender implements SnakeListSender {

    public static final Sender instance = new Sender();

    private Sender() {}

    @Override
    public void receiveSnakeList(ObservableList<SnakePlayer> list) {

    }

}
