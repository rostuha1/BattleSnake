package user_interface.account;

import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.WindowSettings;

public class MainMenu extends BorderPane {

    static final double SPACING = 15;
    static final double SIDE_MENU_WIDTH = WindowSettings.width / 4.5;
    static final double CONTENT_WIDTH = WindowSettings.width - SIDE_MENU_WIDTH - SPACING;

    {
        setPrefSize(WindowSettings.width, WindowSettings.height);
    }

    public MainMenu(Pane content, ToolBar sideMenu) {
        setRight(sideMenu);
    }

}
