package user_interface.account.content.my_snake;

import client_server.User;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.Main;
import main.WindowSettings;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class MySnakeContent extends HBox {

    private VBox snakeAvatar = new VBox();
    private GridPane snakeInformation = new GridPane();
    private final double IMAGE_SIZE = 200;

    {
        setMaxSize(CONTENT_WIDTH * 0.75, WindowSettings.height * 0.75);
        setStyle("-fx-border-color: rgb(159, 188, 94); -fx-border-width: 4px");
        ImageView avatar = new ImageView();
        avatar.setImage(Main.user.getSnake().getAvatar());
        avatar.setFitHeight(IMAGE_SIZE);
        avatar.setFitWidth(IMAGE_SIZE);
        avatar.setStyle("-fx-border-color: white; -fx-border-width: 2px");
        Button changeAvatar = new Button("Змінити аватар");
        changeAvatar.setFont(new Font(13));
        changeAvatar.setPrefSize(IMAGE_SIZE * 0.75, 20);
        snakeAvatar.setSpacing(20);
        snakeAvatar.setAlignment(Pos.CENTER);
        snakeAvatar.getChildren().addAll(avatar, changeAvatar);
    }

    public MySnakeContent() {
        getChildren().addAll(snakeAvatar, snakeInformation);
    }
}
