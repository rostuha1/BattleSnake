package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import user_interface.account.content.intelligence.Settings;
import user_interface.animation.AnimatedCircles;
import user_interface.menus.MenuBox;

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

        MenuBox.init(root);
        MenuBox.show();

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