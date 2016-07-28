package main;

import battlefield.Grid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import user_interface.Animation.AnimatedCircles;
import user_interface.account.MainMenu;

import java.nio.file.Paths;

public class Main extends Application {

    private static Pane root = new Pane();
    private static Pane snakeField = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        root.setPrefSize(WindowSettings.width, WindowSettings.height);
        root.getChildren().add(snakeField);

        Scene scene = new Scene(root);

        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setTitle("JavaFx Game. BattleSnake");

        primaryStage.setOnCloseRequest(event -> Timer.stop());
        primaryStage.setScene(scene);

        gameInit();

        primaryStage.show();

    }

    public static void gameInit() {
        Grid.setParent(snakeField);
//        Snake.setParent(snakeField);
//        Grid.draw();
//        Cells.draw(2, 1, Color.RED);
//        Timer.start();
//        cells[1][1].draw(CellType.DEFAULT);

        root.setStyle("-fx-background-color: rgb(35, 40, 30)");
        AnimatedCircles.createSpawnNodes(root);
        root.getChildren().add(new MainMenu());
        root.getStylesheets().add(Paths.get("").toAbsolutePath().toUri().normalize().toString() + "src/main/resources/style.css");
//        MenuBox.init(root);
//        MenuBox.show();

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