package user_interface.account.content.fight;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.WindowSettings;
import user_interface.Centering;
import user_interface.account.MainMenu;

public class FightContent extends BorderPane {

    public FightContent() {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        SnakeViewerPane snakeViewerPane = new SnakeViewerPane();
        setTop(new SlotsBox());
        setCenter(snakeViewerPane);
    }
}
