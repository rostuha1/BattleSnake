package user_interface.account.content.intelligence.menu_items;

import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;

public class Settings {
    public static final Insets hInsets = new Insets(10);

    public static Effect itemEffect = new DropShadow(10,Color.AZURE);

    public static final String defaultStyle = "-fx-border-color: #93af0f; -fx-border-width: 2px;";
    public static final String backgroundColor = "-fx-background-color: #23af11";
    public static final String pressedStyle = defaultStyle + backgroundColor;
}
