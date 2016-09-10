package user_interface.account.battlefield.menu;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GameSpeedChanger extends VBox {

    private static final int MIN_VALUE = 0;
    private static final int START_VALUE = 1;
    private static final int MAX_VALUE = 10;
    private static final int VALUE_LABEL_WIDTH = 38;
    private static final double SLIDER_BOX_SPACING = 20;

    private double stepsPerSecond = 1.0;

    public static final GameSpeedChanger instance = new GameSpeedChanger();

    private GameSpeedChanger() {
        setAlignment(Pos.CENTER);
        setMaxHeight(0);
        setSpacing(10);

        Label label = new Label("Швидкість");
        Label sliderValue = new Label("1.00");
        Slider slider = new Slider(MIN_VALUE, MAX_VALUE, START_VALUE);
        HBox sliderBox = new HBox();

        label.setStyle("" +
                "-fx-font-size: 20;" +
                "-fx-text-fill: #887322"
        );
        label.setEffect(new Bloom());

        sliderValue.setPrefWidth(VALUE_LABEL_WIDTH);
        sliderValue.setStyle("" +
                "-fx-font-size: 16;" +
                "-fx-text-fill: #616188"
        );
        sliderValue.setEffect(new Bloom());

        HBox.setHgrow(slider, Priority.ALWAYS);
        slider.setEffect(new ColorAdjust(-0.2, -0.3, -0.3, -0.6));
        slider.setShowTickLabels(true);
        slider.setEffect(new Bloom(3));
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            stepsPerSecond = newValue.doubleValue();
            sliderValue.setText(String.format("%.2f", stepsPerSecond));
        });

        sliderBox.setAlignment(Pos.TOP_CENTER);
        sliderBox.setSpacing(SLIDER_BOX_SPACING);
        sliderBox.getChildren().add(slider);
        sliderBox.getChildren().add(sliderValue);

        getChildren().add(label);
        getChildren().add(sliderBox);
    }

    public static void sleepForNextStep() {
        if (instance.stepsPerSecond == 0.0) {
            pause();
            return;
        }

        try {
            Thread.sleep((long) (1000 / instance.stepsPerSecond));
        } catch (InterruptedException ignored) {
        }
    }

    private static void pause() {
        while (instance.stepsPerSecond == 0.0) {
            try { Thread.sleep(1); } catch (InterruptedException ignored) {}
        }
    }

}
