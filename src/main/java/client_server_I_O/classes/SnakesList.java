package client_server_I_O.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class SnakesList implements Serializable {

    ArrayList<SnakePlayer> list;

    SnakesList() {}

    public ArrayList<SnakePlayer> getList() {
        return list;
    }
    public void setList(ArrayList<SnakePlayer> list) {
        this.list = list;
    }

}
