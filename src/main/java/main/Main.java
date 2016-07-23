package main;

import battlefield.Grid;
import battlefield.snake.Snake;
import events.KeyboardEvents;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import user_interface.menus.MainMenu;

public class Main extends Application {

    private static Pane root = new Pane();
    private static Pane snakeField = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        root.setPrefSize(Window.width, Window.height);
        Scene scene = new Scene(root);
        root.getChildren().add(snakeField);

        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setTitle("JavaFx Game. BattleSnake");

        primaryStage.setOnCloseRequest(event -> Timer.stop());
        primaryStage.setScene(scene);

        Grid.setParent(snakeField);
        Snake.setParent(snakeField);

        Grid.draw();
        Timer.start();
        MainMenu.initMenu(root);
        KeyboardEvents.initKeys(scene);

        primaryStage.show();

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