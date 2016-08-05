package user_interface.account.content.fight;

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
    private static final SnakeList instance = new SnakeList();

    public static SnakeList getInstance() {
        return instance;
    }

    private SnakeList() {
        setPrefSize(0, 0);
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
        return getItems();
    }

    public void setList(ObservableList<SnakePlayer> list) {
        setItems(list);
        resize();
    }

    public void resize() {
        ObservableList<SnakePlayer> list = getItems();
        if (list.size() < 5) setPrefSize(WIDTH, list.size() * CELL_SIZE + 2);
        else setPrefSize(WIDTH, HEIGHT);
    }

}
