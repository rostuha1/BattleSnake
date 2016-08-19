package user_interface.account.content.fight;

import javafx.scene.layout.BorderPane;
import main.Main;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.content.fight.list.SnakeViewerPane;
import user_interface.account.content.fight.slots.SlotsBox;

public class FightContent extends BorderPane {

    public SlotsBox slotsBox = new SlotsBox(Main.user.getSnake());

    public FightContent() {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        setTop(slotsBox);
        setCenter(SnakeViewerPane.getInstance());
    }
}
