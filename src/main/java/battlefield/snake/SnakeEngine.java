package battlefield.snake;

import javafx.scene.Scene;

@FunctionalInterface
public interface SnakeEngine {

    void setConduct(Snake snake, Scene scene);

}
