package nodes;

import user_interface.account.battlefield.snake.Position;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Main;

public class Rect extends Rectangle {

    private static Pane parent = Main.getSnakeField();

    static {
        parent = Main.getSnakeField();
    }

    private Position position;

    public static void setParent(Pane parent) {
        Rect.parent = parent;
    }

    public Rect(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public Position getPos() {
        return position;
    }
    public void setPos(int posX, int posY) {
        this.position = new Position(posX, posY);
    }

    public void draw() {
        parent.getChildren().add(this);
    }
    public void remove() {
        parent.getChildren().remove(this);
    }

}