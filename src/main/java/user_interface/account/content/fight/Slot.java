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
    private SnakePlayer currentPlayer = null;
    private boolean isOccupied = false;
    private ImageView avatar = new ImageView();
    private Text description = new Text();
    private ContextMenu contextMenu = new ContextMenu();


    {
        avatar.setFitHeight(60);
        avatar.setFitWidth(60);
        description.setFont(new Font(15));
        getChildren().addAll(avatar, description);

        setSpacing(15);
        setAlignment(Pos.CENTER_LEFT);
        setMinSize(220, 75);
        setMaxSize(220, 75);
        setPadding(new Insets(0, 15, 0, 0));
        setStyle("-fx-border-width: 3px; -fx-border-color: rgb(120, 125, 75); " +
                "-fx-background-color: rgb(140, 145, 95); -fx-border-radius: 0px 0px 10px 10px; -fx-background-radius: 0 0 10 10");

        MenuItem deleteSlot = new MenuItem("Звільнити слот");
        deleteSlot.setOnAction(event -> releaseSlot());
        contextMenu.getItems().add(deleteSlot);

    }

    public Slot() {
        takeSlot(DEFAULT_PLAYER);
        isOccupied = false;
        setDeleteProperty(false);
    }

    public Slot(SnakePlayer player) {
        this.currentPlayer = player;
        takeSlot(player);
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void takeSlot(SnakePlayer player) {
        getChildren().removeAll(avatar, description);
        this.currentPlayer = player;
        avatar.setImage(player.getAvatar());
        description.setText(player.getName() + "\n" + player.getRating());
        getChildren().addAll(avatar, description);
        isOccupied = true;
        setDeleteProperty(true);
    }

    public void releaseSlot() {
        SnakeList.getInstance().getList().add(currentPlayer);
        SnakeList.getInstance().resize();
        takeSlot(DEFAULT_PLAYER);
        isOccupied = false;
        setDeleteProperty(false);
    }

    public void setDeleteProperty(boolean isOccupied) {
        if (isOccupied) setOnContextMenuRequested(event -> contextMenu.show(this, Side.BOTTOM, 0, 10));
        else setOnContextMenuRequested(event -> contextMenu.hide());
    }

}
