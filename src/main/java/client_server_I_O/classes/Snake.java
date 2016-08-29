package client_server_I_O.classes;

import javafx.geometry.Point2D;
import user_interface.account.battlefield.snake.Direction;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Snake implements Serializable {

    Direction initDirection;
    List<Point2D> positions = new LinkedList<>(); // positions.size() equals snake length

    public Snake() {}

    public Direction getInitDirection() {
        return initDirection;
    }
    public void setInitDirection(Direction initDirection) {
        this.initDirection = initDirection;
    }

    public List<Point2D> getPositions() {
        return positions;
    }
    public void setPositions(List<Point2D> positions) {
        this.positions = positions;
    }

}
