package user_interface.account.content.my_snake;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Main;
import main.WindowSettings;
import client_server.SnakePlayer;
import user_interface.ComponentBuilder;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class MySnakeContent extends HBox {

    private VBox snakeAvatar = new VBox();
    private GridPane snakeInformation = new GridPane();
    private final double IMAGE_SIZE = 200;
    private SnakePlayer snake = Main.user.getSnake();
    private double red = snake.getColor().getRed() * 255;
    private double green = snake.getColor().getGreen() * 255;
    private double blue = snake.getColor().getBlue() * 255;
    private final double WIDTH = CONTENT_WIDTH * 0.6;
    private final double HEIGHT = WindowSettings.height / 2;

    {
        setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 4px");
        setMaxSize(WIDTH, HEIGHT);

        ImageView avatar = new ImageView();
        avatar.setImage(Main.user.getSnake().getAvatar());
        avatar.setFitHeight(IMAGE_SIZE);
        avatar.setFitWidth(IMAGE_SIZE);

        Button changeAvatar = new Button("Змінити аватар");
        changeAvatar.setFont(new Font(13));
        changeAvatar.setPrefSize(IMAGE_SIZE * 0.75, 20);

        snakeAvatar.setSpacing(20);
        snakeAvatar.setAlignment(Pos.CENTER);
        snakeAvatar.setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 2px; " +
                "-fx-background-color: rgb(" + red + ", " + green + ", " + blue + ");");
        snakeAvatar.getChildren().addAll(avatar, changeAvatar);

        Label lblName = getLabel("Ім'я: ");
        Label lblRating = getLabel("Рейтинг: ");
        Label lblColor = getLabel("Колір: ");
        Label lblAbout = getLabel("Паспорт: ");
        TextField name = getTextField(snake.getName());
        Label rating = getLabel(String.valueOf(snake.getRating()));
        ColorPicker color = getColorPicker(snake.getColor());
        TextArea passport = getTextArea(snake.getAbout());
        HBox box = getHBox("Зберегти");

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

    }

    public MySnakeContent() {}


    private HBox getHBox(String text) {
        HBox box = new HBox();
        Button save = new Button(text);
        save.setFont(new Font(15));
        save.setStyle("-fx-background-color: rgb(92, 136, 59); -fx-border-color: rgb(62, 82, 37)");
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(save);
        return box;
    }

    private TextArea getTextArea(String about) {
        TextArea passport = new TextArea(snake.getAbout());
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
        textField.setStyle("-fx-font-size: 15; -fx-background-color: rgb(201, 231, 133); -fx-border-color: rgb(62, 82, 37)");
        textField.setMaxWidth(300);
        return textField;
    }



}
