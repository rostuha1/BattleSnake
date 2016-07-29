package user_interface.account;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import user_interface.ComponentBuilder;
import user_interface.account.content.ContentType;

public class SideMenu extends ToolBar {

    private static final int TEXT_SIZE = 20;
    private static final double BUTTON_WIDTH = MainMenu.SIDE_MENU_WIDTH;
    private static final double BUTTON_HEIGHT = 50;

    private static final double SPACING = 10;
    private static final double padding = 10;
    private static final Insets insets = new Insets(padding);

    private static final Region fight = ComponentBuilder.getButton("БІЙ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Region mySnake = ComponentBuilder.getButton("МОЯ ЗМІЯ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Region intelligence = ComponentBuilder.getButton("ІНТЕЛЕКТ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Region developers = ComponentBuilder.getButton("РОЗРОБНИКИ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT);
    private static final Region exit = ComponentBuilder.getButton("ВИХІД", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT);

    public SideMenu() {
        super(fight, mySnake, intelligence, developers, exit);
        exit.setOnMouseClicked(event -> System.exit(0));
    }

    {

        fight.setOnMouseClicked(event -> MainMenu.instance.setContent(ContentType.FIGHT_CONTENT));
        intelligence.setOnMouseClicked(event -> MainMenu.instance.setContent(ContentType.INTELLIGENCE_CONTENT));

        setOrientation(Orientation.VERTICAL);
        setMinWidth(MainMenu.SIDE_MENU_WIDTH);
//        BorderPane.setMargin(this, insets);

        setStyle("-fx-background-color: rgb(159, 188, 94)");

//        DropShadow effect = new DropShadow();
//        effect.setColor(Color.BLUE);
//        effect.setBlurType(BlurType.GAUSSIAN);
//        effect.setRadius(5);
//        setEffect(effect);
    }

}
