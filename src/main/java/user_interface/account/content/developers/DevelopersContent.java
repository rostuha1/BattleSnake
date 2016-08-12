package user_interface.account.content.developers;

import javafx.scene.layout.Pane;
import main.WindowSettings;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class DevelopersContent extends Pane {

    public DevelopersContent() {
        setPrefSize(CONTENT_WIDTH, WindowSettings.height);
        setStyle("-fx-background-color: blueviolet");

    }

}
