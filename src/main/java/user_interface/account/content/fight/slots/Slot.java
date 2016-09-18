package user_interface.account.content.fight.slots;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import user_interface.account.User;
import user_interface.account.content.fight.list.SnakePlayerList;
import user_interface.account.SnakePlayer;
import user_interface.account.content.fight.list.SnakeViewerPane;

public class Slot extends HBox {

    private User currentPlayer = null;
    private boolean isOccupied = false;
    private ImageView avatar = new ImageView();
    private Text description = new Text();
    private ContextMenu contextMenu = new ContextMenu();
    private int index;

    {
        avatar.setFitHeight(60);
        avatar.setFitWidth(60);
        description.setFont(new Font(15));
        getChildren().addAll(avatar, description);

        setSpacing(15);
        setAlignment(Pos.CENTER_LEFT);
        setMinSize(225, 75);
        setMaxSize(225, 75);
        setPadding(new Insets(0, 0, 0, 10));
        setBackground(new Background(new BackgroundFill(SnakePlayer.DEFAULT_SNAKE_PLAYER.getColor(), new CornerRadii(0, 0, 10, 10, false), null)));
        setBorder(new Border(new BorderStroke(Color.rgb(120, 125, 75), BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 10, 10, false), new BorderWidths(3), null)));
    }

    public Slot(int index) {
        this.index = index;
        takeSlot(User.DEFAULT_USER);
        isOccupied = false;
        MenuItem deleteSlot = new MenuItem("Звільнити слот");
        deleteSlot.setOnAction(event -> {
            releaseSlot();
            SlotsBox.reset();
        });
        contextMenu.getItems().add(deleteSlot);
        setOnContextMenuRequested(null);
    }

    public Slot(User player, int index) {
        this.index = index;
        takeSlot(player);
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void takeSlot(User player) {
        getChildren().removeAll(avatar, description);
        this.currentPlayer = player;
        updateSlot(player);
        getChildren().addAll(avatar, description);
        isOccupied = true;
        setOnContextMenuRequested(event -> contextMenu.show(this, Side.BOTTOM, 0, 10));
    }

    public void releaseSlot() {
        if (currentPlayer != User.DEFAULT_USER)
            SnakePlayerList.getInstance().getList().add(currentPlayer);
        SnakePlayerList.getInstance().resize();
        SnakeViewerPane.getInstance().show(SnakeViewerPane.getSnakePlayerList().getItems());
        takeSlot(User.DEFAULT_USER);
        isOccupied = false;
        setOnContextMenuRequested(null);
    }

    public void clear() {
        currentPlayer = User.DEFAULT_USER;
        updateSlot(currentPlayer);
        isOccupied = false;
        setOnContextMenuRequested(null);
    }

    public void updateSlot(User player) {
        avatar.setImage(player.getSnakePlayer().getAvatar());
        description.setText(player.getSnakePlayer().getName() + "\n" + player.getSnakePlayer().getRating());
        setBackground(new Background(new BackgroundFill(player.getSnakePlayer().getColor(), new CornerRadii(0, 0, 10, 10, false), null)));
    }

    public Image getAvatar() {
        return avatar.getImage();
    }

    public ImageView getAvatarViev() {
        return avatar;
    }

    public User getCurrentPlayer() {
        return currentPlayer;
    }

    public int getIndex() {
        return index;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
