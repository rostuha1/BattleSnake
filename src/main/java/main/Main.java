package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import user_interface.account.MainMenu;
import user_interface.account.battlefield.menu.SnakesPane;
import user_interface.account.battlefield.snake.Direction;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.intelligence.Settings;
import user_interface.animation.AnimatedCircles;

public class Main extends Application {

    private static Pane root = new Pane();
    private static Stage stage;
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        root.setPrefSize(WindowSettings.width, WindowSettings.height);
        scene = new Scene(root);

        primaryStage.setFullScreen(WindowSettings.fullscreen);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setTitle("JavaFx Game. BattleSnake");

        primaryStage.setScene(scene);

        stage = primaryStage;

        gameInit();

        primaryStage.show();

    }

    public static void gameInit() {

        root.setStyle("-fx-background-color: rgb(35, 40, 30)");
        AnimatedCircles.createSpawnNodes(root);
        root.getStylesheets().add(Settings.projectPath + "src/main/resources/style.css");

//        snakeDemo();

//        MenuBox.init(root);
//        MenuBox.show();

//        SlotsBox box = SlotsBox.instance;
        root.getChildren().add(SnakePane.instance);
        root.getChildren().add(MainMenu.instance);
        SnakesPane.init();


    }

    private static void snakeDemo() {
        Snake snake = new Snake(Color.BLUE, Direction.RIGHT);
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }

            Platform.runLater(() -> {
                snake.goForward();
                snake.highlightSnake(true);
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }

            Platform.runLater(snake::turnRight);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }

            Platform.runLater(() -> {
                snake.turnLeft();
                snake.highlightSnake(false);
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ignored) {
            }

            Platform.runLater(snake::goForward);

        }).start();
    }

    public static Pane getRoot() {
        return root;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}