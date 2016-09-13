package user_interface.account.battlefield.menu;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import user_interface.account.SnakePlayer;
import user_interface.account.User;

import java.util.ArrayList;
import java.util.Map;

public class ResultPane extends VBox {

    public static final ResultPane instance = new ResultPane();

    private static Map<User, Integer> newPlayersRatings;
    private static int winner;

    private static ArrayList<HBox> results = new ArrayList<>(4);

    private ResultPane() {
        setAlignment(Pos.CENTER);
        setMaxHeight(0);
        setSpacing(10);
    }

    public static void setNewPlayersRatings(Map<User, Integer> newPlayersRatings) {
        ResultPane.newPlayersRatings = newPlayersRatings;
    }

    public static void setWinner(int winnerIndex) {
        ResultPane.winner = winnerIndex;
    }

    public static void show() {

        int w = 0;
        for (Map.Entry<User, Integer> playerRating : newPlayersRatings.entrySet()) {
            SnakePlayer p = playerRating.getKey().getSnakePlayer();
            results.add(getResult(p.getAvatar(), p.getName(), p.getColor(), playerRating.getValue(), w == winner));
            w++;
        }

        Platform.runLater(() -> results.forEach(hBox -> instance.getChildren().add(hBox)));

    }

    public static void clearPane() {
        Platform.runLater(() -> {
            results.forEach(hBox -> instance.getChildren().remove(hBox));
            results.clear();
        });
    }

    private static HBox getResult(Image avatar, String snakeName, Color snakeColor, int newRating, boolean isWinner) {
        HBox leftBox = new HBox();
        HBox rightBox = new HBox();

        leftBox.setAlignment(Pos.CENTER_LEFT);
        rightBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(rightBox, Priority.ALWAYS);

        ImageView imageView = new ImageView(avatar);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        HBox.setMargin(imageView, new Insets(0, 10, 0, 0));

        Label name = new Label(snakeName);
        name.setFont(Font.font(16));
        name.setTextFill(snakeColor);
        name.setEffect(new Bloom());

        Label rating = new Label(String.valueOf(newRating));
        rating.setFont(Font.font(16));
        rating.setTextFill(isWinner ? Color.GREEN : Color.RED);
        rating.setEffect(new Bloom());

        leftBox.getChildren().add(imageView);
        leftBox.getChildren().add(name);
        rightBox.getChildren().add(rating);

        return new HBox(leftBox, rightBox);
    }

    public static void updateRatings() {
        if (newPlayersRatings == null) return;
        newPlayersRatings.forEach((user, integer) -> user.getSnakePlayer().setRating(integer));
    }

}
