package nodes;

import javafx.animation.FillTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.Main;
import rendering.snake.Position;

public class Rect extends Rectangle {

    private Color mainColor = Color.DEEPPINK;

    FillTransition ft = new FillTransition(Duration.millis(50), this, mainColor, Color.WHITE);

    {
        ft.setOnFinished(event -> Main.getRoot().getChildren().remove(this));
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

    public void draw() {
        Main.getRoot().getChildren().add(this);
    }

    public void remove() {
        ft.play();
    }

}
