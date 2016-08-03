package user_interface.account.content.fight;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Slot extends HBox {

    private final SnakePlayer DEFAULT_PLAYER = new SnakePlayer("default-snake.png");
    private boolean isOccupied = false;
    private ImageView avatar = new ImageView();
    private Text description = new Text();


    {
        avatar.setFitHeight(60);
        avatar.setFitWidth(60);
        description.setFont(new Font(15));
        getChildren().addAll(avatar, description);
        setSpacing(15);
        setAlignment(Pos.CENTER_LEFT);
        setMinSize(210, 75);
        setMaxSize(230, 75);
        setPadding(new Insets(0, 15, 0, 0));
        setStyle("-fx-border-width: 3px; -fx-border-color: rgb(120, 125, 75); " +
                "-fx-background-color: rgb(140, 145, 95); -fx-border-radius: 0px 0px 10px 10px; -fx-background-radius: 0 0 10 10");
    }

    public Slot() {
        releaseSlot();
    }

    public Slot(SnakePlayer player) {
        takeSlot(player);

    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void takeSlot(SnakePlayer player) {
        getChildren().removeAll(avatar, description);
        avatar.setImage(player.getAvatar());
        description.setText(player.getName() + "\n" + player.getRating());
        getChildren().addAll(avatar, description);
        isOccupied = true;
    }

    public void releaseSlot() {
        takeSlot(DEFAULT_PLAYER);
        isOccupied = false;
    }

    public Slot setDeleteProperty() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem deleteSlot = new MenuItem("Звільнити слот");
        contextMenu.getItems().add(deleteSlot);
        deleteSlot.setOnAction(event -> releaseSlot());
        setOnContextMenuRequested(e -> contextMenu.show(this, Side.BOTTOM, 0, 10));
        return this;
    }

}
