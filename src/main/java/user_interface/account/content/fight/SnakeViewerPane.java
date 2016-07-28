package user_interface.account.content.fight;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.WindowSettings;
import user_interface.account.MainMenu;

public class SnakeViewerPane extends VBox {

    private static final double WIDTH_SPACING = 25;
    private static final double HEIGHT_SPACING = 50;
    private static final double WIDTH = MainMenu.CONTENT_WIDTH / 2 + WIDTH_SPACING * 2;
    private static final double HEIGHT = WindowSettings.height / 2 + HEIGHT_SPACING * 2;

    public SnakeViewerPane() {
        setPrefSize(WIDTH, HEIGHT);

        TextField textField = new TextField();
        textField.setPromptText("Пошук по імені...");
        textField.setFocusTraversable(false);

        Button btnFind = new Button("Шукати");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField, btnFind);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setMaxHeight(20);
        setSpacing(20);
        SnakeList snakeList = new SnakeList();

        getChildren().addAll(hBox, snakeList);
    }
}
