package user_interface.account.content.my_snake;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Main;
import main.WindowSettings;
import client_server.SnakePlayer;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class MySnakeContent extends HBox {

    private VBox snakeAvatar = new VBox();
    private GridPane snakeInformation = new GridPane();
    private final double IMAGE_SIZE = 200;
    private SnakePlayer snake = Main.user.getSnake();
    private double red = snake.getColor().getRed() * 255;
    private double green = snake.getColor().getGreen() * 255;
    private double blue = snake.getColor().getBlue() * 255;
    private final double WIDTH = CONTENT_WIDTH * 0.75;
    private final double HEIGHT = WindowSettings.height / 2;

    {
        setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 4px");
        setMaxSize(WIDTH, HEIGHT);

        ImageView avatar = new ImageView();
        avatar.setImage(Main.user.getSnake().getAvatar());
//        avatar.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-background-color: deeppink");
        avatar.setFitHeight(IMAGE_SIZE);
        avatar.setFitWidth(IMAGE_SIZE);

        Button changeAvatar = new Button("Змінити аватар");
        changeAvatar.setFont(new Font(13));
        changeAvatar.setPrefSize(IMAGE_SIZE * 0.75, 20);

        snakeAvatar.setSpacing(20);
        snakeAvatar.setAlignment(Pos.CENTER);
        snakeAvatar.setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 2px; " +
                "-fx-background-color: rgb(" + red + ", " + green + ", " + blue + ");");
//        snake.getColor()
        snakeAvatar.getChildren().addAll(avatar, changeAvatar);

        Label lblName = getLabel("Ім'я: ");
        Label lblRating = getLabel("Рейтинг: ");
        Label lblColor = getLabel("Колір: ");
        Label lblAbout = getLabel("Паспорт: ");

        TextField name = getTextField(snake.getName());
        Label rating = getLabel(String.valueOf(snake.getRating()));
        ColorPicker color = new ColorPicker();
        color.setStyle("-fx-font-size: 15");
        color.setValue(snake.getColor());
        TextArea passport = new TextArea(snake.getAbout());
        passport.setStyle("-fx-font-size: 15");
        passport.setMaxHeight(70);

        Button save = new Button("Зберегти");
        save.setFont(new Font(15));
        HBox box = new HBox();
        box.setAlignment(Pos.BOTTOM_RIGHT);
        box.getChildren().add(save);

        snakeInformation.addRow(0, lblName, name);
        snakeInformation.addRow(1, lblRating, rating);
        snakeInformation.addRow(2, lblColor, color);
        snakeInformation.addRow(3, lblAbout, passport);
        snakeInformation.add(box, 1, 4);
//        snakeInformation.setHgap(50);
        snakeInformation.setVgap(20);
        snakeInformation.setAlignment(Pos.CENTER);
        snakeInformation.setPadding(new Insets(25, 25, 25, 25));
//        snakeInformation.setGridLinesVisible(true);
        snakeInformation.getColumnConstraints().add(new ColumnConstraints(100));
        snakeInformation.setStyle("-fx-background-color: rgb(159, 188, 94)");

        getChildren().addAll(snakeAvatar, snakeInformation);

    }

    public MySnakeContent() {}

    private Label getLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-font-size: 15; -fx-font-weight: bold; -fx-font-style: italic;" +
                " -fx-text-fill: rgb(62, 82, 37)");
        return label;
    }

    private TextField getTextField(String info) {
        TextField textField = new TextField(info);
        textField.setStyle("-fx-font-size: 15; -fx-background-color: rgb(62, 82, 37) , rgb(159, 188, 94) , transparent;\n" +
                "    -fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;");
        textField.setMaxWidth(300);

        return textField;
    }

}
