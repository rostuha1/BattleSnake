package battlefield;

import javafx.scene.paint.Paint;
import nodes.Line;
import nodes.Rect;

import static battlefield.RenderField.PART;
import static battlefield.RenderField.SQUARE_NUMBER;
import static battlefield.RenderField.parts;
import static battlefield.RenderField.startPoint;

public class Cells {

    private static Rect [][] rects = new Rect[SQUARE_NUMBER][SQUARE_NUMBER];

    static {
        for (int i = 0; i < SQUARE_NUMBER; i++) {
            for (int j = 0; j < SQUARE_NUMBER; j++) {
                rects[i][j] = getRect(i + 1, j + 1);
            }
        }
    }

    public static void draw(int posX, int posY, Paint color) {
        Rect r = rects[posX - 1][posY - 1];
        r.setFill(color);
        r.draw();
    }

    private static Rect getRect(int posX, int posY) {
        if (posX < 0 || posX > SQUARE_NUMBER + 1 || posY < 0 || posY > SQUARE_NUMBER + 1)
            throw new IllegalArgumentException("Enter valid arguments");

        if (posX == 0) posX = SQUARE_NUMBER;
        if (posY == 0) posY = SQUARE_NUMBER;
        if (posX == SQUARE_NUMBER + 1) posX = 1;
        if (posY == SQUARE_NUMBER + 1) posY = 1;

        double x = startPoint + parts[posX - 1] + Line.getLineWidth();
        double y = parts[posY - 1] + Line.getLineWidth();

        double width = PART - Line.getLineWidth() * 2;
        double height = PART - Line.getLineWidth() * 2;

        Rect resRec = new Rect(x, y, width, height);
        resRec.setPos(posX, posY);

        return resRec;
    }

}
