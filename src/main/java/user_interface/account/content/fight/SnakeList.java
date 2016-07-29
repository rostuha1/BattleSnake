package user_interface.account.content.fight;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import user_interface.account.MainMenu;

public class SnakeList extends ListView<SnakePlayer> {

    private static final double AVATAR_SIZE = 60;
    public static final double CELL_SIZE = AVATAR_SIZE + 20;
    private static final double WIDTH = MainMenu.CONTENT_WIDTH / 2;
    private static final double HEIGHT = CELL_SIZE * 5 + 2;
    private ObservableList<SnakePlayer> list = FXCollections.observableArrayList();

    public SnakeList() {
        list.addAll(new SnakePlayer("snake1.png", "ann", 1010, "Let's fight with me!"),
                new SnakePlayer("snake2.png", "rost", 1500, "111"),
                new SnakePlayer("snake3.png", "chuvak", 1000, "I am a super snake :)"));
        if (list.size() < 5) setPrefSize(WIDTH, list.size() * CELL_SIZE + 2);
        else setPrefSize(WIDTH, HEIGHT);
        setItems(list);

        setFixedCellSize(CELL_SIZE);
        setCellFactory(new Callback<ListView<SnakePlayer>, ListCell<SnakePlayer>>() {
            @Override
            public ListCell<SnakePlayer> call(ListView<SnakePlayer> param) {
                ListCell<SnakePlayer> cell = new ListCell<SnakePlayer>() {
                    @Override
                    protected void updateItem(SnakePlayer player, boolean b) {
                        super.updateItem(player, b);
                        if (player != null) {
                            Image img = player.getAvatar();
                            ImageView imageView = new ImageView(img);
                            imageView.setFitWidth(AVATAR_SIZE);
                            imageView.setFitHeight(AVATAR_SIZE);
                            setGraphic(imageView);
                            setText(player.toString());
                        }
                    }
                };
                return cell;
            }
        });

    }

    public ObservableList<SnakePlayer> getList() {
        return list;
    }
}
