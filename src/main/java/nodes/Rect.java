package nodes;

import main.SnakePane;
import user_interface.account.battlefield.snake.Position;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Main;

public class Rect extends Rectangle {

    private static Pane parent = SnakePane.instance;

    static {
        parent = SnakePane.instance;
    }

    {
        parent.getChildren().add(this);
        setVisible(false);
    }

    private Position position;

    public static void setParent(Pane parent) {
        Rect.parent = parent;
    }

    public Rect(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public void draw() {
        setVisible(true);
    }
    public void draw(Color color) {
        setFill(color);
        setVisible(true);
    }
    public void remove() {
        setVisible(false);
    }

}