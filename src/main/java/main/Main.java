package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rendering.GridRender;
import rendering.RenderField;
import rendering.snake.Snake;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Main extends Application {

//    static {
//        System.setProperty("java.library.path", "native");
//    }

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static Pane root = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(root, screenSize.width, screenSize.height);

        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.setTitle("JavaFx Game. BattleSnake");

        primaryStage.setScene(scene);
        primaryStage.show();

        GridRender.getInstance().render();

        for (int i = 1; i < RenderField.SQUARE_NUMBER + 1; i++) {
            for (int j = 1; j < RenderField.SQUARE_NUMBER + 1; j++) {
                Snake.fillSquare(i, j);
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}