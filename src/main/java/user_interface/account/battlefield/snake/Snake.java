package user_interface.account.battlefield.snake;

import client_server_I_O.classes.Block;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import nodes.Rect;
import user_interface.account.battlefield.Cells;
import user_interface.account.content.intelligence.Settings;

import java.util.ArrayList;

public class Snake {

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

    public void setBody(ArrayList<Block> newBody) {
        if (body != null) {
            body.forEach(Cells::setEffectNull);
            body.forEach(block -> Cells.remove(block, snakeColor));
        }
        body = newBody;
        body.forEach(block -> Cells.draw(block, snakeColor));
        if (isHighlight) body.forEach(Cells::setEffect);
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
        Platform.runLater(()->{

            if (flag) {
                snake.isHighlight = true;
                snake.body.forEach(Cells::setEffect);
                return;
            }

            snake.isHighlight = false;
            snake.body.forEach(Cells::setEffectNull);
        });
    }

    public static void setSnakeBody(int index, ArrayList<Block> newBody) {
        snakes.get(index).setBody(newBody);
    }

    public static void clearField() {
        snakes.forEach(snake -> snake.isHighlight = false);
    }

    public static Snake getFirst() {
        return snakes.get(0);
    }

    public static Snake getSecond() {
        return snakes.get(1);
    }

    public static Snake getThird() {
        return snakes.get(2);
    }

    public static Snake getFourth() {
        return snakes.get(3);
    }

    public static ArrayList<Snake> getSnakes() {
        return snakes;
    }

}