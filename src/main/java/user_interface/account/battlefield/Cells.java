package user_interface.account.battlefield;

import client_server_I_O.classes.Block;
import javafx.scene.paint.Paint;
import nodes.Line;
import nodes.Rect;
import user_interface.account.content.intelligence.Settings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static user_interface.account.battlefield.RenderField.PART;
import static user_interface.account.battlefield.RenderField.SQUARE_NUMBER;
import static user_interface.account.battlefield.RenderField.parts;
import static user_interface.account.battlefield.RenderField.startPoint;

public class Cells {

    private static Rect [][] rects = new Rect[SQUARE_NUMBER][SQUARE_NUMBER];
    public static final ArrayList<Rect> visibleRects = new ArrayList<>(625);

    static {
        for (int i = 0; i < SQUARE_NUMBER; i++) {
            for (int j = 0; j < SQUARE_NUMBER; j++) {
                rects[i][j] = getRect(i, j);
            }
        }
    }

    public static void draw(Block block, Paint color) {

        int posX = block.getX();
        int posY = block.getY();

        Rect r = rects[posX][posY];
        draw(r, color);
    }
    public static void draw(Rect r, Paint color) {
        r.setFill(color);
        r.draw();
    }

    public static void remove(Block block) {
        int posX = block.getX();
        int posY = block.getY();

        rects[posX][posY].remove();
    }

    public static void drawByDefault(Block block) {
        int posX = block.getX();
        int posY = block.getY();

        rects[posX][posY].remove();
    }
    public static void drawByDefault(Rect r) {
        r.remove();
    }

    public static Rect getRect(Block block) {
        int posX = block.getX();
        int posY = block.getY();

        return getRect(posX, posY);
    }

    public static Rect getRect(int posX, int posY) {
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

    public static void setEffect(Block block) {

        int posX = block.getX() + 1;
        int posY = block.getY() + 1;

        rects[posX][posY].setEffect(Settings.itemEffect);
    }
    public static void setEffectNull(Block block) {

        int posX = block.getX() + 1;
        int posY = block.getY() + 1;

        rects[posX][posY].setEffect(null);
    }

    public static void clearField() {
        visibleRects.forEach(rect -> {
            rect.setEffect(null);
            rect.remove();
        });
        visibleRects.clear();
    }

}
