package main;

import client_server.SnakePlayer;
import client_server.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import user_interface.account.MainMenu;
import user_interface.account.battlefield.Cells;
import user_interface.account.battlefield.Grid;
import user_interface.account.battlefield.snake.Direction;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.intelligence.Settings;
import user_interface.animation.AnimatedCircles;
import user_interface.menus.MenuBox;

import java.nio.file.Paths;

public class Main extends Application {

    private static Pane root = new Pane();
    private static Pane snakeField = new Pane();
    private static Stage stage;
    private static Scene scene;

    public static final User user = new User();

    @Override
    public void start(Stage primaryStage) throws Exception {

        root.setPrefSize(WindowSettings.width, WindowSettings.height);
        root.getChildren().add(snakeField);

        scene = new Scene(root);

        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setTitle("JavaFx Game. BattleSnake");

        primaryStage.setScene(scene);

        stage = primaryStage;

        gameInit();

        primaryStage.show();

    }

    public static void gameInit() {
        user.setSnake(new SnakePlayer("snake1.png", "Ann", 1200, Color.WHEAT, "Let's play!"));

        root.setStyle("-fx-background-color: rgb(35, 40, 30)");
        AnimatedCircles.createSpawnNodes(root);
        root.getStylesheets().add(Settings.projectPath + "src/main/resources/style.css");

        Grid.draw();

        snakeDemo();

//        MenuBox.init(root);
//        MenuBox.show();

//        root.getChildren().add(MainMenu.instance);

    }

    private static void snakeDemo() {
        Snake snake = new Snake(Color.BLUE, Direction.RIGHT);
        snake.goForward();
        snake.turnRight();
        snake.turnLeft();
    }

    public static Pane getRoot() {
        return root;
    }

    public static Scene getScene() {
        return scene;
    }

    public static Pane getSnakeField() {
        return snakeField;
    }

    public static void main(String[] args) {
        launch(args);
    }

}