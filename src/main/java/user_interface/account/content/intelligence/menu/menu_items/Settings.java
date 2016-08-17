package user_interface.account.content.intelligence.menu.menu_items;

import javafx.geometry.Insets;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Settings {
    public static double menuSpacing = 10;

    public static final Font textFont = Font.font(16);
    public static final Insets hInsets = new Insets(10);
    public static Insets gridInsets = new Insets(5);

    public static Effect itemEffect = new DropShadow(10,Color.AZURE);
    public static Effect cardElementSwitchEffect = new ColorAdjust(0, 0, -0.4, 0);

    public static final String defaultStyle = "-fx-border-color: #93af0f; -fx-border-width: 2px;";
    public static final String backgroundColor = "-fx-background-color: #23af11";
    public static final String pressedStyle = defaultStyle + backgroundColor;
}
