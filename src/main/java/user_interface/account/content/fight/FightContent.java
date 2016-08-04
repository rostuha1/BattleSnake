package user_interface.account.content.fight;

import javafx.scene.layout.BorderPane;
import main.WindowSettings;
import user_interface.account.MainMenu;

public class FightContent extends BorderPane {

    public FightContent() {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        setTop(new SlotsBox(new SnakePlayer("snake1.png", "Ann", 1200, "Let's play!")));
        setCenter(new SnakeViewerPane());
    }
}
