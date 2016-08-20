package user_interface;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ComponentBuilder {

    public static final int ITEM_WIDTH = 300;
    public static final int ITEM_HEIGHT = 30;

    public static final double TRANSITION_DURATION = 0.5;
    public static final Color BUTTON_COLOR = Color.web("0x2A7A2A");
    public static final Color BUTTON_TEXT_COLOR = Color.web("0x73D123");

    public static Region create(Component component, String text) {
        switch (component) {
            case FIELD:
                return getField(Component.FIELD, text);
            case PASSWORD_FIELD:
                return getField(Component.PASSWORD_FIELD, text);
            case LABEL:
                return getLabel(text);
            case BUTTON:
                return getButton(text);
            default:
                return new Region();
        }
    }

    private static Region getLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 16;" +
                "-fx-text-fill: #58B858;" +
                "-fx-font-weight: bold");
        return label;
    }

    private static TextField getField(Component component, String text) {
        TextField field;
        switch (component) {
            case FIELD:
                field = new TextField();
                break;
            case PASSWORD_FIELD:
                field = new PasswordField();
                break;
            default:
                field = new TextField();
        }

        field.setFocusTraversable(false);
        field.setPromptText(text);
        field.setStyle("-fx-background-color: #a9a9a9 , white , white; \n" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1; " +
                "-fx-font-size: 16");

        field.setPrefWidth(300);
        field.setPrefHeight(1);

        return field;
    }

    private static Region getButton(String text) {
        return getButton(text, 16, ITEM_WIDTH, ITEM_HEIGHT);
    }

    public static  Region getButton(String text, double textSize, double width, double height) {
        return getButton(text, textSize, width, height , 1);
    }

    public static Region getButton(String text, double textSize, double width, double height, double opacity) {
        StackPane stackPane = new StackPane();

        Rectangle bg = new Rectangle(width, height, BUTTON_COLOR);
        bg.setOpacity(opacity);

        Text textButton = new Text(text);
        textButton.setFill(BUTTON_TEXT_COLOR);
        textButton.setFont(Font.font("Arial", FontWeight.BOLD, textSize));

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
