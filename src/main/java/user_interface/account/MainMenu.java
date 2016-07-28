package user_interface.account;

import javafx.scene.layout.BorderPane;
import main.WindowSettings;
import user_interface.account.content.fight.FightContent;

public class MainMenu extends BorderPane {

    public static final double SIDE_MENU_WIDTH = WindowSettings.width / 4.5;
    public static final double CONTENT_WIDTH = WindowSettings.width - SIDE_MENU_WIDTH;

    {
        setPrefSize(WindowSettings.width, WindowSettings.height);
    }

    public MainMenu() {
        setRight(new SideMenu());
        setCenter(new FightContent());
    }

}
