package user_interface.account.content.fight.list;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import user_interface.account.MainMenu;
import user_interface.account.User;

public class SnakePlayerList extends ListView<User> {

    private static final double AVATAR_SIZE = 60;
    public static final double CELL_SIZE = AVATAR_SIZE + 20;
    private static final double WIDTH = MainMenu.CONTENT_WIDTH / 2;
    private static final double HEIGHT = CELL_SIZE * 5 + 2;
    private static final SnakePlayerList instance = new SnakePlayerList();
    private static ObservableList<User> mainList;
    public static ObservableList<User> usersList = Adapter.getUsersList(Client.getUsers());


    public static SnakePlayerList getInstance() {
        return instance;
    }

    private SnakePlayerList() {
        setPrefSize(0, 0);
        setFixedCellSize(CELL_SIZE);
        setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> param) {
                ListCell<User> cell = new ListCell<User>() {
                    @Override
                    protected void updateItem(User player, boolean b) {
                        super.updateItem(player, b);
                        if (player != null) {
                            Image img = player.getSnakePlayer().getAvatar();
                            ImageView imageView = new ImageView(img);
                            imageView.setFitWidth(AVATAR_SIZE);
                            imageView.setFitHeight(AVATAR_SIZE);
                            setGraphic(imageView);
                            setText(player.getSnakePlayer().toString());
                        }
                    }
                };
                return cell;
            }
        });

    }

    public ObservableList<User> getList() {
        return getItems();
    }

    public void setList(ObservableList<User> list) {
        setItems(list);
        resize();
//        SnakeViewerPane.getInstance().show(list);
    }

    public void resize() {
        ObservableList<User> list = getItems();
        if (list.size() < 5) setPrefSize(WIDTH, list.size() * CELL_SIZE + 2);
        else setPrefSize(WIDTH, HEIGHT);
    }

}
