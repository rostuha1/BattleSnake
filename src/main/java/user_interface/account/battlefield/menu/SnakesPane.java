package user_interface.account.battlefield.menu;

import client_server.I_O.SnakePlayer;
import javafx.geometry.Pos;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.fight.slots.Slot;
import user_interface.account.content.fight.slots.SlotsBox;
import user_interface.account.content.intelligence.Settings;

public class SnakesPane extends HBox {

    private final Slot firstSlot = SlotsBox.mySlot;
    private final Slot secondSlot = SlotsBox.enemySlots.get(0);
    private final Slot thirdSlot = SlotsBox.enemySlots.get(1);
    private final Slot fourthSlot = SlotsBox.enemySlots.get(2);

    private final ImageView firstSnake = new ImageView(firstSlot.getAvatar());
    private final ImageView secondSnake = new ImageView(secondSlot.getAvatar());
    private final ImageView thirdSnake = new ImageView(thirdSlot.getAvatar());
    private final ImageView fourthSnake = new ImageView(fourthSlot.getAvatar());

    private static ImageView selectedSnakeImage = null;
    private static Snake selectedSnake = null;
    private static volatile byte snakesNumber;

    public static SnakesPane instance;

    private SnakesPane() {
        setAlignment(Pos.CENTER);

        HBox.setMargin(firstSnake, Settings.hInsets);
        HBox.setMargin(secondSnake, Settings.hInsets);
        HBox.setMargin(thirdSnake, Settings.hInsets);
        HBox.setMargin(fourthSnake, Settings.hInsets);

        firstSnake.setOnMouseClicked(event -> highlightSnake(firstSlot.getCurrentPlayer().getSnake(), firstSnake));
        secondSnake.setOnMouseClicked(event -> highlightSnake(secondSlot.getCurrentPlayer().getSnake(), secondSnake));
        thirdSnake.setOnMouseClicked(event -> highlightSnake(thirdSlot.getCurrentPlayer().getSnake(), thirdSnake));
        fourthSnake.setOnMouseClicked(event -> highlightSnake(fourthSlot.getCurrentPlayer().getSnake(), fourthSnake));
    }

    public static void init() {
        instance = new SnakesPane();
    }

    public static void update() {

        snakesNumber = 0;

        setSnake(instance.firstSnake, instance.firstSlot);
        setSnake(instance.secondSnake, instance.secondSlot);
        setSnake(instance.thirdSnake, instance.thirdSlot);
        setSnake(instance.fourthSnake, instance.fourthSlot);

        if (snakesNumber <= 1) {
            ControlMenu.instance.getChildren().remove(instance);
            return;
        }

        double imageSize = ControlMenu.SIDE_PLACE_WIDTH / snakesNumber - 40;

        instance.firstSnake.setFitHeight(imageSize);
        instance.firstSnake.setFitWidth(imageSize);
        instance.secondSnake.setFitHeight(imageSize);
        instance.secondSnake.setFitWidth(imageSize);
        instance.thirdSnake.setFitHeight(imageSize);
        instance.thirdSnake.setFitWidth(imageSize);
        instance.fourthSnake.setFitHeight(imageSize);
        instance.fourthSnake.setFitWidth(imageSize);

        if (!ControlMenu.instance.getChildren().contains(instance))
            ControlMenu.instance.getChildren().add(instance);

    }

    private void highlightSnake(Snake snake, ImageView imageView) {
        if (selectedSnakeImage == imageView) {
            selectedSnakeImage.setEffect(null);
            selectedSnakeImage = null;
            selectedSnake.highlightSnake(false);
            selectedSnake = null;
            return;
        }

        if (selectedSnakeImage != null) selectedSnakeImage.setEffect(null);
        if (selectedSnake != null) selectedSnake.highlightSnake(false);

        selectedSnakeImage = imageView;
        selectedSnakeImage.setEffect(Settings.itemEffect);
        selectedSnake = snake;
        selectedSnake.highlightSnake(true);
    }

    private static void setSnake(ImageView snake, Slot slot) {
        if (slot.getCurrentPlayer().getAvatar() == SnakePlayer.DEFAULT_AVATAR) {
            instance.getChildren().remove(snake);
            return;
        }
        if (!instance.getChildren().contains(snake)) instance.getChildren().add(snake);
        new Thread(() -> snake.setImage(setSnakeBackground(slot.getAvatar(), slot.getCurrentPlayer().getColor()))).start();
        snakesNumber++;
    }

    public static Image setSnakeBackground(Image snakeImage, Color snakeColor) {
        WritableImage result = new WritableImage((int) snakeImage.getWidth(), (int) snakeImage.getHeight());

        PixelReader pixelReader = snakeImage.getPixelReader();
        PixelWriter pixelWriter = result.getPixelWriter();

        for (int i = 0; i < snakeImage.getWidth(); i++) {
            for (int j = 0; j < snakeImage.getHeight(); j++) {
                if (pixelReader.getColor(i, j).getOpacity() == 0.0)
                    pixelWriter.setColor(i, j, snakeColor);
                else pixelWriter.setColor(i, j, pixelReader.getColor(i, j));
            }
        }

        return result;
    }

}
