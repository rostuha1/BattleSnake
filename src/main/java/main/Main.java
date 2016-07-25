package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import user_interface.Animation.AnimatedCircles;
import user_interface.menus.MenuBox;

public class Main extends Application {

    private static Pane root = new Pane();
    private static Pane snakeField = new Pane();
    private static Scene scene = new Scene(root);

    @Override
    public void start(Stage primaryStage) throws Exception {

        root.setPrefSize(WindowSettings.width, WindowSettings.height);
//        root.getChildren().add(snakeField);

        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setTitle("JavaFx Game. BattleSnake");

        primaryStage.setOnCloseRequest(event -> Timer.stop());
        primaryStage.setScene(scene);

        gameInit();

        primaryStage.show();

    }

    public static void gameInit() {
//        Grid.setParent(snakeField);
//        Snake.setParent(snakeField);
//        Grid.draw();
//        Timer.start();

        root.setStyle("-fx-background-color: rgb(35, 40, 30)");
        AnimatedCircles.createSpawnNodes(root);

        MenuBox.init(root);
        MenuBox.show();



//        KeyboardEvents.initKeys(scene);
    }

    public static Pane getRoot() {
        return root;
    }

    public static Pane getSnakeField() {
        return snakeField;
    }

    public static void main(String[] args) {
        launch(args);
    }

}