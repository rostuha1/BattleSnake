package events;

import user_interface.account.battlefield.snake.Snake;
import javafx.scene.Scene;

public class KeyboardEvents {

    public static Snake snake;

    public static void initKeys(Scene scene) {
        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) snake.setDirection(Direction.LEFT);
//            if (event.getCode() == KeyCode.RIGHT) snake.setDirection(Direction.RIGHT);
//            if (event.getCode() == KeyCode.UP) snake.setDirection(Direction.UP);
//            if (event.getCode() == KeyCode.DOWN) snake.setDirection(Direction.DOWN);
        });
    }

}
