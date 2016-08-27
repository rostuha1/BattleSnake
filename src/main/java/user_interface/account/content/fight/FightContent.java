package user_interface.account.content.fight;

import javafx.scene.layout.BorderPane;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.content.fight.list.SnakeViewerPane;
import user_interface.account.content.fight.slots.SlotsBox;

public class FightContent extends BorderPane {

    public FightContent() {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        setTop(SlotsBox.instance);
        setCenter(SnakeViewerPane.getInstance());
    }
}
