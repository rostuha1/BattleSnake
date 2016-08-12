package user_interface.account.content.fight.slots;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import user_interface.account.content.fight.list.SnakeList;
import user_interface.account.content.fight.list.SnakePlayer;
import user_interface.account.content.fight.list.SnakeViewerPane;

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
        setBackground(new Background(new BackgroundFill(DEFAULT_PLAYER.getColor(), new CornerRadii(0, 0, 10, 10, false), null)));
        setBorder(new Border(new BorderStroke(Color.rgb(120, 125, 75), BorderStrokeStyle.SOLID, new CornerRadii(0, 0, 10, 10, false), new BorderWidths(3), null)));
//        setStyle("-fx-border-width: 3px; -fx-border-color: ); " +
//                "-fx-background-color: rgb(140, 145, 95) ; -fx-border-radius: 0px 0px 10px 10px; -fx-background-radius: 0 0 10 10");

    }

    public Slot() {
        takeSlot(DEFAULT_PLAYER);
        isOccupied = false;
        MenuItem deleteSlot = new MenuItem("Звільнити слот");
        deleteSlot.setOnAction(event -> releaseSlot());
        contextMenu.getItems().add(deleteSlot);
        setOnContextMenuRequested(null);

    }

    public Slot(SnakePlayer player) {
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
        setBackground(new Background(new BackgroundFill(player.getColor(), new CornerRadii(0, 0, 10, 10, false), null)));
        setOnContextMenuRequested(event -> contextMenu.show(this, Side.BOTTOM, 0, 10));
    }

    public void releaseSlot() {
        SnakeList.getInstance().getList().add(currentPlayer);
        SnakeList.getInstance().resize();
        SnakeViewerPane.getInstance().show(SnakeViewerPane.getSnakeList().getItems());
        takeSlot(DEFAULT_PLAYER);
        isOccupied = false;
        setOnContextMenuRequested(null);
    }


}
