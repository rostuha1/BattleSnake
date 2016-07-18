package rendering.snake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.Line;
import main.Main;

import static rendering.RenderField.PART;
import static rendering.RenderField.SQUARE_NUMBER;
import static rendering.RenderField.parts;
import static rendering.RenderField.startPoint;

public class Snake {

    public static void fillSquare(int posX, int posY) {
        if (posX < 1 || posX > SQUARE_NUMBER || posY < 1 || posY > SQUARE_NUMBER)
            throw new IllegalArgumentException("Enter valid arguments");

        double x = startPoint + parts[posX - 1] + Line.getLineWidth();
        double y = parts[posY - 1] + Line.getLineWidth();

        double width = PART - Line.getLineWidth() * 2;
        double height = PART - Line.getLineWidth() * 2;

        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.DARKSLATEBLUE);
//        rectangle.setStrokeDashOffset(10);
        Main.root.getChildren().add(rectangle);

    }

}