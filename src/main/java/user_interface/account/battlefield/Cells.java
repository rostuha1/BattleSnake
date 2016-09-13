package user_interface.account.battlefield;

import client_server_I_O.classes.Block;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import nodes.Line;
import nodes.Rect;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.intelligence.Settings;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;

import static user_interface.account.battlefield.RenderField.PART;
import static user_interface.account.battlefield.RenderField.SQUARE_NUMBER;
import static user_interface.account.battlefield.RenderField.parts;
import static user_interface.account.battlefield.RenderField.startPoint;

public class Cells {

    private static Rect[][] rects = new Rect[SQUARE_NUMBER][SQUARE_NUMBER];
    public static final ArrayList<Rect> visibleRects = new ArrayList<>(625);

    static {
        for (int i = 0; i < SQUARE_NUMBER; i++) {
            for (int j = 0; j < SQUARE_NUMBER; j++) {
                rects[i][j] = getNewRect(i, j);
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

    public static void draw(int x, int y, Color color) {
        draw(new Block(x, y), color);
    }

    public static void remove(Block block) {
        int posX = block.getX();
        int posY = block.getY();

        rects[posX][posY].remove();
    }

    public static Rect get(int x, int y) {
        return rects[x][y];
    }

    public static Rect get(Block block) {
        return get(block.getX(), block.getY());
    }

    public static void drawByDefault(Block block) {
        int posX = block.getX();
        int posY = block.getY();

        rects[posX][posY].remove();
    }

    public static void drawByDefault(Rect r) {
        r.remove();
    }

    public static Rect getNewRect(Block block) {
        int posX = block.getX();
        int posY = block.getY();

        return getNewRect(posX, posY);
    }

    public static Rect getNewRect(int posX, int posY) {
        if (posX < 0 || posX > SQUARE_NUMBER + 1 || posY < 0 || posY > SQUARE_NUMBER + 1)
            throw new IllegalArgumentException("Enter valid arguments");

        if (posX == -1) posX = SQUARE_NUMBER;
        if (posY == -1) posY = SQUARE_NUMBER;
        if (posX == SQUARE_NUMBER + 1) posX = 0;
        if (posY == SQUARE_NUMBER + 1) posY = 0;

        double x = startPoint + parts[posX] + Line.getLineWidth();
        double y = parts[posY] + Line.getLineWidth();

        double width = PART - Line.getLineWidth() * 2;
        double height = PART - Line.getLineWidth() * 2;

        return new Rect(x, y, width, height);
    }

    public static void setEffect(Block block) {
        get(block).setEffect(Settings.itemEffect);
    }

    public static void setEffectNull(Block block) {
        get(block).setEffect(null);
    }

    public static void clear() {
        Platform.runLater(() -> {
            for (int i = 0; i < SQUARE_NUMBER; i++) {
                for (int j = 0; j < SQUARE_NUMBER; j++) {
                    get(i, j).setEffect(null);
                    get(i, j).remove();
                }
            }
            Snake.clearField();
        });
    }
}
