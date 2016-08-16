package main;

import client_server.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import user_interface.account.MainMenu;
import client_server.SnakePlayer;
import user_interface.animation.AnimatedCircles;

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

        primaryStage.setOnCloseRequest(event -> Timer.stop());
        primaryStage.setScene(scene);

        stage = primaryStage;

        gameInit();

        primaryStage.show();

    }

    public static void gameInit() {
//        Grid.setParent(snakeField);
//        Snake.setParent(snakeField);
//        Grid.draw();
//        Cells.draw(2, 1, Color.RED);
//        Cells.draw(1, 1, Color.BROWN);
//        Timer.start();

        user.setSnake(new SnakePlayer("snake1.png", "Ann", 1200, Color.WHEAT, "Let's play!"));

        root.setStyle("-fx-background-color: rgb(35, 40, 30)");
        AnimatedCircles.createSpawnNodes(root);
        root.getStylesheets().add(Paths.get("").toAbsolutePath().toUri().normalize().toString() + "src/main/resources/style.css");

//        MenuBox.init(root);
//        MenuBox.show();

        root.getChildren().add(MainMenu.instance);

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