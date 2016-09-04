package user_interface.account.battlefield.snake;

import client_server_I_O.classes.Block;
import javafx.scene.paint.Color;
import nodes.Rect;
import user_interface.account.battlefield.Cells;
import user_interface.account.content.intelligence.Settings;

import java.util.ArrayList;

public class Snake {

    private static Snake selectedSnake = null;
    private static ArrayList<Snake> snakes = new ArrayList<>(4);

    static {
        snakes.add(new Snake());
        snakes.add(new Snake());
        snakes.add(new Snake());
        snakes.add(new Snake());
    }

    private Color snakeColor;
    private boolean isHighlight = false;
    private ArrayList<Block> body;

    public ArrayList<Block> getBody() {
        return body;
    }

    public void setBody(ArrayList<Block> newBody) {
        if (body != null) body.forEach(Cells::remove);
        body = newBody;
        if (!isHighlight) body.forEach(block -> Cells.draw(block, snakeColor));
        else body.forEach(block -> {
            Rect r = Cells.getRect(block.getX(), block.getY());
            r.setEffect(Settings.itemEffect);
            Cells.draw(r, snakeColor);
        });
    }

    public Color getColor() {
        return snakeColor;
    }

    public void setColor(Color color) {
        this.snakeColor = color;
    }

    public boolean isHighlight() {
        return isHighlight;
    }

    public static void highlightSnake(boolean flag, int snakeIndex) {
        highlightSnake(flag, snakes.get(snakeIndex));
    }

    public static void highlightSnake(boolean flag, Snake snake) {
        if (flag) {
            selectedSnake = snake;
            snake.isHighlight = true;
            snake.body.forEach(Cells::setEffect);
            return;
        }

        snake.isHighlight = false;
        snake.body.forEach(Cells::setEffectNull);
        selectedSnake = null;
    }

    private Rect getRect(Block pos) {
        return Cells.getRect(pos);
    }

    public static void setSnakeBody(ArrayList<Block> newBody, int index) {
        snakes.get(index).setBody(newBody);
    }

    public static void clearField() {
        snakes.forEach(snake -> snake.isHighlight = false);
        Cells.clearField();
    }

}