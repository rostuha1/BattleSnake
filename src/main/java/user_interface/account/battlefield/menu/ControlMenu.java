package user_interface.account.battlefield.menu;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import main.WindowSettings;
import user_interface.account.content.intelligence.Settings;

public class ControlMenu extends VBox {
    private static final double indent = 20;
    public static final double SIDE_PLACE_WIDTH = (WindowSettings.width - WindowSettings.height) / 2;
    public static final ControlMenu instance = new ControlMenu();

    private ControlMenu() {
        setAlignment(Pos.TOP_CENTER);
        setSpacing(Settings.controlMenuSpacing);

        setPrefSize(SIDE_PLACE_WIDTH - indent, WindowSettings.height);
        setTranslateX((WindowSettings.width + WindowSettings.height) / 2 + indent);
    }

}
