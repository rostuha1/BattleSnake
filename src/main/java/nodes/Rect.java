package nodes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import rendering.snake.Position;

public class Rect extends Rectangle {

    {
        setFill(Color.DARKSLATEBLUE);
    }

    private Position position;

    public Position getPos() {
        return position;
    }
    public void setPos(int posX, int posY) {
        this.position = new Position(posX, posY);
    }

    public Rect(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

}
