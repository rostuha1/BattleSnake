package client_server.I_O.Sender;

import client_server.I_O.SnakePlayer;
import javafx.collections.ObservableList;

public interface SnakeListSender {
    void receiveSnakeList(ObservableList<SnakePlayer> list);
}
