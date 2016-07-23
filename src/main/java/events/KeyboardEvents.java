package events;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import user_interface.menus.MenuBox;
import battlefield.snake.Direction;
import battlefield.snake.Snake;

public class KeyboardEvents {

    public static Snake snake;

    public static void initKeys(Scene scene) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) snake.setDirection(Direction.LEFT);
            if (event.getCode() == KeyCode.RIGHT) snake.setDirection(Direction.RIGHT);
            if (event.getCode() == KeyCode.UP) snake.setDirection(Direction.UP);
            if (event.getCode() == KeyCode.DOWN) snake.setDirection(Direction.DOWN);
            if (event.getCode() == KeyCode.ESCAPE) MenuBox.escapeEvent();
        });
    }

}
