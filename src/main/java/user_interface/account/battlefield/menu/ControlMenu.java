package user_interface.account.battlefield.menu;

import events.KeyboardEvents;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import main.WindowSettings;
import user_interface.ComponentBuilder;

public class ControlMenu extends BorderPane {
    private static final double indent = 10;
    public static final double SIDE_PLACE_WIDTH = (WindowSettings.width - WindowSettings.height) / 2 - indent;
    public static final ControlMenu instance = new ControlMenu();

    private ControlMenu() {
        setPrefSize(SIDE_PLACE_WIDTH, WindowSettings.height);

        setTranslateX((WindowSettings.width + WindowSettings.height) / 2 + indent);

        BorderPane.setMargin(GameSpeedChanger.instance, new Insets(30));
        BorderPane.setAlignment(GameSpeedChanger.instance, Pos.TOP_CENTER);

        Region buttonBack = ComponentBuilder.getButton("НАЗАД");
        buttonBack.setOpacity(0.8);
        buttonBack.setOnMouseClicked(event -> KeyboardEvents.backFromBattleField());
        BorderPane.setAlignment(buttonBack, Pos.BOTTOM_CENTER);
        BorderPane.setMargin(buttonBack, new Insets(0, 0, 40, 0));

        DropShadow effect = new DropShadow();
        effect.setColor(Color.BLUE);
        effect.setBlurType(BlurType.GAUSSIAN);
        effect.setRadius(0);
        buttonBack.setEffect(effect);

        setCenter(GameSpeedChanger.instance);
        setBottom(buttonBack);

    }

}
