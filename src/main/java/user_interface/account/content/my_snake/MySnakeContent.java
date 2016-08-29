package user_interface.account.content.my_snake;

import user_interface.account.SnakePlayer;
import user_interface.account.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import main.Main;
import main.WindowSettings;

import java.io.File;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class MySnakeContent extends HBox {

    private SnakePlayer snakePlayer = User.getInstance().getSnakePlayer();

    private final double IMAGE_SIZE = 200;
    private final double HEIGHT = WindowSettings.height / 2;
    private final double WIDTH = CONTENT_WIDTH * 0.6;
    private final double IMAGE_SPACING = 15;

    private double red = snakePlayer.getColor().getRed() * 255;
    private double green = snakePlayer.getColor().getGreen() * 255;
    private double blue = snakePlayer.getColor().getBlue() * 255;

    private Label lblName = getLabel("Ім'я: ");
    private Label lblRating = getLabel("Рейтинг: ");
    private Label lblColor = getLabel("Колір: ");
    private Label lblAbout = getLabel("Паспорт: ");
    private Label rating = getLabel(String.valueOf(snakePlayer.getRating()));

    private GridPane snakeInformation = new GridPane();
    private StackPane snakeAvatar = new StackPane();
    private ImageView avatar = new ImageView();
    private TextField name = getTextField(snakePlayer.getName());
    private ColorPicker color = getColorPicker(snakePlayer.getColor());
    private TextArea passport = getTextArea(snakePlayer.getAbout());
    private Button save = getButton("Зберегти");

    private FileChooser fileChooser = new FileChooser();
    private DoubleClickTimer dc = new DoubleClickTimer();

    {
        setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 4px");
        setMaxSize(WIDTH, HEIGHT);

        avatar.setImage(User.getInstance().getSnakePlayer().getAvatar());
        avatar.setFitHeight(IMAGE_SIZE);
        avatar.setFitWidth(IMAGE_SIZE);
        avatar.setOnMouseClicked(event -> {
            dc.currentTime = System.currentTimeMillis();

            if (dc.lastTime != 0 && dc.currentTime != 0) {
                dc.diff = dc.currentTime - dc.lastTime;
                dc.isDoubleClicked = dc.diff <= 215;
            }

            dc.lastTime = dc.currentTime;

            if (dc.isDoubleClicked) {
                File selectedFile = fileChooser.showOpenDialog(Main.getScene().getWindow());
                if (selectedFile != null) avatar.setImage(new Image(selectedFile.toURI().toString()));
            }

        });

        snakeAvatar.setMinWidth(IMAGE_SIZE + IMAGE_SPACING * 2);
        snakeAvatar.setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 2px; " +
                "-fx-background-color: rgb(" + red + ", " + green + ", " + blue + ");");
        snakeAvatar.getChildren().add(avatar);

        save.setOnAction(event -> save(avatar.getImage(), name.getText(), color.getValue(), passport.getText()));
        HBox box = new HBox();
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(save);

        snakeInformation.addRow(0, lblName, name);
        snakeInformation.addRow(1, lblColor, color);
        snakeInformation.addRow(2, lblAbout, passport);
        snakeInformation.addRow(3, lblRating, rating);
        snakeInformation.add(box, 1, 4);

        snakeInformation.setVgap(20);
        snakeInformation.setAlignment(Pos.CENTER);
        snakeInformation.setPadding(new Insets(25, 25, 25, 25));
        snakeInformation.getColumnConstraints().add(new ColumnConstraints(100));
        snakeInformation.setStyle("-fx-background-color: rgb(159, 188, 94)");

        getChildren().addAll(snakeAvatar, snakeInformation);

        fileChooser.setTitle("Upload a picture");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));

    }

    public MySnakeContent() {}

    private void save(Image avatar, String name, Color color, String about) {

        if (avatar != null) User.getInstance().getSnakePlayer().setAvatar(avatar);
        else this.avatar.setImage(User.getInstance().getSnakePlayer().getAvatar());

        if (!name.isEmpty()) User.getInstance().getSnakePlayer().setName(name);
        else this.name.setText(User.getInstance().getSnakePlayer().getName());

        if (!about.isEmpty()) User.getInstance().getSnakePlayer().setAbout(about);
        else this.passport.setText(User.getInstance().getSnakePlayer().getAbout());

        if (color != null) {
            User.getInstance().getSnakePlayer().setColor(color);
            snakeAvatar.setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 2px; " +
                    "-fx-background-color: rgb(" + color.getRed() * 255 + ", " + color.getGreen() * 255 +
                    ", " + color.getBlue() * 255 + ");");
        } else this.color.setValue(User.getInstance().getSnakePlayer().getColor());
    }

    private Button getButton(String text) {
        Button save = new Button(text);
        save.setFont(new Font(15));
        save.setStyle("-fx-background-color: rgb(92, 136, 59); -fx-border-color: rgb(62, 82, 37)");
        return save;
    }

    private TextArea getTextArea(String about) {
        TextArea passport = new TextArea(snakePlayer.getAbout());
        passport.setMaxHeight(70);
        return passport;
    }

    private ColorPicker getColorPicker(Color snakeColor) {
        ColorPicker color = new ColorPicker();
        color.setStyle("-fx-font-size: 15; -fx-border-color: rgb(62, 82, 37); -fx-background-color: rgb(201, 231, 133)");
        color.setValue(snakeColor);
        return color;
    }

    private Label getLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-font-style: italic;" +
                " -fx-text-fill: rgb(62, 82, 37)");
        return label;
    }

    private TextField getTextField(String info) {
        TextField textField = new TextField(info);
        textField.setFocusTraversable(false);
        textField.setStyle("-fx-font-size: 15; -fx-background-color: rgb(201, 231, 133); -fx-border-color: rgb(62, 82, 37)");
        textField.setMaxWidth(300);
        return textField;
    }

    private static class DoubleClickTimer {
        boolean isDoubleClicked = false;
        long currentTime = 0;
        long lastTime = 0;
        long diff = 0;
    }

}
