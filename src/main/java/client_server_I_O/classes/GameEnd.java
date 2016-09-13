package client_server_I_O.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class GameEnd implements Serializable {
    static final long serialVersionUID = 4566843898265039363L;

    private int snakeWinner;
    ArrayList<Integer> newRatings;

    public GameEnd() {}

    public int getSnakeWinner() {
        return snakeWinner;
    }
    public void setSnakeWinner(int snakeWinner) {
        this.snakeWinner = snakeWinner;
    }

    public ArrayList<Integer> getNewRatings() {
        return newRatings;
    }
    public void setNewRatings(ArrayList<Integer> newRatings) {
        this.newRatings = newRatings;
    }

}
