package user_interface.account;

import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.WindowSettings;

public class MainMenu extends BorderPane {

    static final double SPACING = 15;
    static final double TOP_MENU_HEIGHT = WindowSettings.height / 4.5;
    static final double CONTENT_WIDTH = WindowSettings.height - TOP_MENU_HEIGHT - SPACING;

    {
        setPrefSize(WindowSettings.width, WindowSettings.height);
    }

    public MainMenu(Pane content, ToolBar topMenu) {
        setTop(topMenu);
    }

}
