package user_interface.account;

import client_server_I_O.Adapter;
import client_server_I_O.Client;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.Blend;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.*;
import main.WindowSettings;
import user_interface.ComponentBuilder;
import user_interface.account.content.ContentType;
import user_interface.account.content.fight.list.SnakePlayerList;
import user_interface.account.content.fight.list.SnakeViewerPane;
import user_interface.account.content.fight.slots.Slot;
import user_interface.account.content.fight.slots.SlotsBox;
import user_interface.account.content.intelligence.Settings;

public class SideMenu extends Pane {

    private static final int TEXT_SIZE = 20;
    private static final double BUTTON_WIDTH = MainMenu.SIDE_MENU_WIDTH;
    private static final double BUTTON_HEIGHT = 50;

    private static final double PADDING = 10;
    private static final double BUTTON_OPACITY = 0.3;

    private static final Region fight = ComponentBuilder.getButton("БІЙ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_OPACITY);
    private static final Region mySnake = ComponentBuilder.getButton("МОЯ ЗМІЯ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_OPACITY);
    private static final Region intelligence = ComponentBuilder.getButton("ІНТЕЛЕКТ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_OPACITY);
    private static final Region rules = ComponentBuilder.getButton("ПРАВИЛА ГРИ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_OPACITY);
    private static final Region developers = ComponentBuilder.getButton("ПРО ПРОГРАМУ", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_OPACITY);
    private static final Region exit = ComponentBuilder.getButton("ВИХІД", TEXT_SIZE, BUTTON_WIDTH, BUTTON_HEIGHT, BUTTON_OPACITY);

    private ToolBar toolBar = new ToolBar(fight, mySnake, intelligence, rules, developers, exit);

    {
        setPrefSize(MainMenu.SIDE_MENU_WIDTH, WindowSettings.height);

        toolBar.setOrientation(Orientation.VERTICAL);
        toolBar.setMinWidth(MainMenu.SIDE_MENU_WIDTH);
        toolBar.setStyle("-fx-background-color: rgba(0, 0, 0, 0)");

        Pane p = new Pane();
        p.setStyle(Settings.sideMenuBackgroundImage);
        p.setPrefSize(MainMenu.SIDE_MENU_WIDTH, WindowSettings.height);

        getChildren().add(p);
        getChildren().add(toolBar);

        fight.setOnMouseClicked(event -> {
            MainMenu.instance.setContent(ContentType.FIGHT_CONTENT);
            updateSnakesList();
        });
        intelligence.setOnMouseClicked(event -> MainMenu.instance.setContent(ContentType.INTELLIGENCE_CONTENT));
        mySnake.setOnMouseClicked(event -> MainMenu.instance.setContent(ContentType.MY_SNAKE_CONTENT));
        rules.setOnMouseClicked(event -> MainMenu.instance.setContent(ContentType.RULES_CONTENT));
        developers.setOnMouseClicked(event -> MainMenu.instance.setContent(ContentType.DEVELOPERS_CONTENT));
        exit.setOnMouseClicked(event -> System.exit(0));
    }

    private void updateSnakesList() {
        new Thread(() -> {
            ObservableList<User> list = Adapter.getUsersList(Client.getUsers());
            Platform.runLater(() -> {
                SlotsBox.getEnemySlots().forEach(Slot::clear);
                SnakePlayerList.getInstance().setMainList(list);
                SnakeViewerPane.getInstance().show();
            });
        }).start();
    }

}
