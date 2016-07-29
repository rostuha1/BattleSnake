package user_interface.account.content.fight;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import jfxtras.labs.util.event.MouseControlUtil;
import main.WindowSettings;
import user_interface.account.MainMenu;

public class SlotsBox extends HBox {

    SnakePlayer player = new SnakePlayer("snake1.png", "Ann", 1200, "Let's play!");

    public SlotsBox() {
        double spacing = 5;
        double width = MainMenu.CONTENT_WIDTH - 2 * spacing;
        double height = WindowSettings.height * 0.1;

        setPrefSize(width, height);
        setAlignment(Pos.CENTER);
        setTranslateX(spacing);
        setSpacing(spacing);

        SnakePlayer player1 = new SnakePlayer("default-snake1.png");
        SnakePlayer player2 = new SnakePlayer("default-snake2.png");
        SnakePlayer player3 = new SnakePlayer("default-snake3.png");

        Button startBattle = new Button("ПОЧАТИ БІЙ");
        startBattle.setFont(new Font(17));
        startBattle.setPrefSize(getPrefWidth() / 8, height / 3 * 2);

        getChildren().addAll(getHBox(player), getHBox(player1), getHBox(player2), getHBox(player3), startBattle);

    }

    private HBox getHBox(SnakePlayer player) {
        HBox hBox = new HBox();
        ImageView imageView = new ImageView(player.getAvatar());
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        Text text = new Text(player.getName() + "\n" + player.getRating());
        text.setFont(new Font(15));
        hBox.getChildren().addAll(imageView, text);
        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setMinSize(210, 75);
        hBox.setMaxSize(230, 75);
        hBox.setPadding(new Insets(0, 15, 0, 0));
        hBox.setStyle("-fx-border-width: 3px; -fx-border-color: rgb(120, 125, 75); " +
                "-fx-background-color: rgb(140, 145, 95); -fx-border-radius: 0px 0px 10px 10px; -fx-background-radius: 0 0 10 10");
        return hBox;
    }
}
