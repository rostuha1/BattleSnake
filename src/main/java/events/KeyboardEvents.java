package events;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import menu.MainMenu;
import menu.MenuBox;
import rendering.snake.Direction;
import rendering.snake.Snake;

public class KeyboardEvents {

    public static Snake snake;
    public static MenuBox menuBox;

    public static void initKeys(Scene scene) {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) snake.setDirection(Direction.LEFT);
            if (event.getCode() == KeyCode.RIGHT) snake.setDirection(Direction.RIGHT);
            if (event.getCode() == KeyCode.UP) snake.setDirection(Direction.UP);
            if (event.getCode() == KeyCode.DOWN) snake.setDirection(Direction.DOWN);
            if (event.getCode() == KeyCode.ESCAPE) {
                FadeTransition ft = new FadeTransition(Duration.seconds(1), menuBox);
                if (!menuBox.isVisible()) {
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                } else {
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(e -> menuBox.setVisible(false));
                    ft.play();
                }
            }
        });
    }

}
