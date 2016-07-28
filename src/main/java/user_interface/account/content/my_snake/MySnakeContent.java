package user_interface.account.content.my_snake;

import javafx.scene.layout.Pane;
import main.WindowSettings;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class MySnakeContent extends Pane {

    public MySnakeContent() {
        setPrefSize(CONTENT_WIDTH, WindowSettings.height);
        setStyle("-fx-background-color: blueviolet");

    }
}
