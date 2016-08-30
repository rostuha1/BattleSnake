package user_interface.account.content.intelligence;

import javafx.geometry.Insets;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.nio.file.Paths;

public class Settings {
    public static final double menuSpacing = 10;
    public static final double controlMenuSpacing = 10;

    public static final String projectPath = Paths.get("").toAbsolutePath().toUri().normalize().toString();

    public static final Font textFont = Font.font(16);
    public static final Insets hInsets = new Insets(10);
    public static final Insets gridInsets = new Insets(5);

    public static final Effect itemEffect = new DropShadow(10, Color.AZURE);
    public static final Effect cardElementSwitchEffect = new ColorAdjust(0, 0, -0.4, 0);

    public static final Background cardPaneBackground = new Background(new BackgroundFill(Color.web("0x73D123", 0.2), new CornerRadii(3), new Insets(-2)));
    public static final Background defaultMenuItemBackground = new Background(new BackgroundFill(Color.web("0x73D123", 0.2), new CornerRadii(3), null));
    public static final Background pressedMenuItemBackground = new Background(new BackgroundFill(Color.web("0x73D123", 0.5), new CornerRadii(3), null));

    public static final String sideMenuBackground =
            "-fx-background-image: url('" + projectPath + "/src/main/resources/side.jpg');" +
            "-fx-opacity: 0.7";

//        DropShadow effect = new DropShadow();
//        effect.setColor(Color.BLUE);
//        effect.setBlurType(BlurType.GAUSSIAN);
//        effect.setRadius(5);
//        setEffect(effect);

}
