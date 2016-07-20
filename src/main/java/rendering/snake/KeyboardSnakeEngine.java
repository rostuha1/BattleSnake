package rendering.snake;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class KeyboardSnakeEngine implements SnakeEngine {

    @Override
    public void setConduct(Snake snake, Scene scene) {
        scene.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.LEFT) snake.setDirection(Direction.LEFT);
//            if (event.getCode() == KeyCode.RIGHT) snake.setDirection(Direction.RIGHT);
//            if (event.getCode() == KeyCode.UP) snake.setDirection(Direction.UP);
//            if (event.getCode() == KeyCode.DOWN) snake.setDirection(Direction.DOWN);
        });
    }

}
