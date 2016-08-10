package user_interface.account.content.fight;

import javafx.scene.layout.BorderPane;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.content.fight.list.SnakePlayer;
import user_interface.account.content.fight.list.SnakeViewerPane;
import user_interface.account.content.fight.slots.SlotsBox;

public class FightContent extends BorderPane {

    public FightContent() {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        setTop(new SlotsBox(new SnakePlayer("snake1.png", "Ann", 1200, "Let's play!")));
        setCenter(SnakeViewerPane.getInstance());
    }
}
