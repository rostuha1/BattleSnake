package user_interface.account;

import javafx.scene.layout.Pane;
import main.WindowSettings;

public class Content extends Pane {

    public Content() {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        setStyle("-fx-background-color: blueviolet");
    }

}
