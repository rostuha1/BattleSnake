package client_server.I_O.Receiver;

import client_server.I_O.SnakePlayer;
import javafx.collections.ObservableList;

public interface SnakeListReceiver {
    ObservableList<SnakePlayer> receiveSnakeList();
}
