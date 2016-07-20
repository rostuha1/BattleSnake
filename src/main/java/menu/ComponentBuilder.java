package menu;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

public class ComponentBuilder {

    public static final int ITEM_WIDTH = 300;
    public static final int ITEM_HEIGHT = 30;
    public static final double TRANSITION_DURATION = 0.5;
    public static final Color BUTTON_COLOR = Color.web("0x195519");
    public static final Color BUTTON_TEXT_COLOR = Color.web("0x58B858");

    public static StackPane create(Component component, String text) {
        if (component == Component.LABEL) return getLabel(text);
        else if (component == Component.FIELD) return getField(text);
        else return getButton(text);
    }

    private static StackPane getLabel(String text) {
        StackPane stackPane = new StackPane();
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 16;" +
                "-fx-text-fill: #58B858;" +
                "-fx-font-weight: bold");
        stackPane.getChildren().add(label);
        return stackPane;
    }

    private static StackPane getField(String text) {
        StackPane stackPane = new StackPane();
        TextField textField = new TextField();
        textField.setFocusTraversable(false);
        textField.setPromptText(text);
        textField.setStyle("-fx-background-color: #a9a9a9 , white , white; \n" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1; " +
                "-fx-font-size: 16;" +
                "-fx-fill-height: 5");

        textField.setPrefWidth(300);
        textField.setPrefHeight(1);
        stackPane.getChildren().add(textField);

        return stackPane;
    }

    private static StackPane getButton(String text) {
        StackPane stackPane = new StackPane();
        Rectangle bg = new Rectangle(ITEM_WIDTH, ITEM_HEIGHT, BUTTON_COLOR);
        bg.setOpacity(0.5);

        Text textButton = new Text(text);
        textButton.setFill(BUTTON_TEXT_COLOR);
        textButton.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().addAll(bg, textButton);
        FillTransition st = new FillTransition(Duration.seconds(TRANSITION_DURATION), bg);
        stackPane.setOnMouseEntered(event -> {
            st.setFromValue(Color.DARKGRAY);
            st.setToValue(Color.DARKGOLDENROD);
            st.setCycleCount(Animation.INDEFINITE);
            st.setAutoReverse(true);
            st.play();
        });
        stackPane.setOnMouseExited(event -> {
            st.stop();
            bg.setFill(BUTTON_COLOR);
        });
        return stackPane;
    }

}
