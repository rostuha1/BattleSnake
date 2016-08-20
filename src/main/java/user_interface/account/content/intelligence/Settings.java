package user_interface.account.content.intelligence;

import javafx.geometry.Insets;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.nio.file.Paths;

public class Settings {
    public static final double menuSpacing = 10;

    public static final String projectPath = Paths.get("").toAbsolutePath().toUri().normalize().toString();

    public static final Font textFont = Font.font(16);
    public static final Insets hInsets = new Insets(10);
    public static final Insets gridInsets = new Insets(5);

    public static final Effect itemEffect = new DropShadow(10,Color.AZURE);
    public static final Effect cardElementSwitchEffect = new ColorAdjust(0, 0, -0.4, 0);

    public static final String defaultStyle = "-fx-border-color: #93af0f; -fx-border-width: 2px;";
    public static final String backgroundColor = "-fx-background-color: #23af11";
    public static final String pressedStyle = defaultStyle + backgroundColor;
    public static final String sideMenuBackground =
            "-fx-background-image: url('" + projectPath + "/src/main/resources/side.jpg');" +
            "-fx-opacity: 0.6";
}
