package user_interface.account.content.fight.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.User;
import user_interface.account.content.fight.slots.Slot;
import user_interface.account.content.fight.slots.SlotsBox;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class SnakeViewerPane extends VBox {

    private static final double WIDTH_SPACING = 25;
    private static final double HEIGHT_SPACING = 50;
    private static final double WIDTH = MainMenu.CONTENT_WIDTH / 2 + WIDTH_SPACING * 2;
    private static final double HEIGHT = WindowSettings.height / 1.5 + HEIGHT_SPACING * 2;

    private static HBox search = new HBox();
    private static SnakePlayerList snakePlayerList = SnakePlayerList.getInstance();
    private static Button btnSelect = new Button();
    private static Label message = new Label();

    private static TextField textField;

    private static final SnakeViewerPane instance = new SnakeViewerPane();

    {
        setMaxSize(WIDTH, HEIGHT);
        setSpacing(20);
        setAlignment(Pos.CENTER_RIGHT);

        Label label = new Label("ВИБІР СУПРОТИВНИКІВ:");
        HBox.setMargin(label, new Insets(0, 80, 0, 0));
        label.setFont(new Font(18));
        label.setStyle("-fx-font-size: 18; -fx-text-fill: rgb(209, 214, 144); -fx-font-weight: bold");

        textField = new TextField();
        textField.setPromptText("Пошук по імені...");
        textField.setOnKeyReleased(event -> {
            ObservableList<User> newList = getSearchedList(SnakePlayerList.getInstance().getMainList(), textField.getText());
            if (newList == null) return;
            SnakePlayerList.getInstance().setList(newList);
        });
        textField.setFocusTraversable(false);

        search.getChildren().addAll(label, textField);
        search.setSpacing(10);
        search.setAlignment(Pos.CENTER_RIGHT);
        search.setMaxHeight(20);

        btnSelect.setText("ВИБРАТИ");
        btnSelect.setFont(new Font(17));
        btnSelect.setOnAction(event -> {
            MultipleSelectionModel<User> model = SnakePlayerList.getInstance().getSelectionModel();
            if (model.getSelectedIndex() != -1) {
                onSelect(model.getSelectedItem());
                show(snakePlayerList.getList());
            }
        });

        message.setText("ГРАВЦІВ НЕМАЄ");
        message.setStyle("-fx-text-fill: rgb(140, 145, 95); -fx-font-size: 26;");
        message.setTranslateX(-getMaxWidth() / 3);
    }

    private SnakeViewerPane() {
        show(snakePlayerList.getList());
    }

    public static SnakeViewerPane getInstance() {
        return instance;
    }

    public static SnakePlayerList getSnakePlayerList() {
        return snakePlayerList;
    }

    public void show(ObservableList<User> list) {
        getChildren().removeAll(message, search, snakePlayerList, btnSelect);
        if (list.isEmpty()) getChildren().add(message);
        else getChildren().addAll(search, snakePlayerList, btnSelect);
    }

    private void onSelect(User enemy) {
        for (Slot slot : SlotsBox.enemySlots) {
            if (!slot.isOccupied()) {
                textField.clear();
                SnakePlayerList.getInstance().setDefaultMainList();

                slot.takeSlot(enemy);
                SnakePlayerList.getInstance().getList().remove(enemy);
                SnakePlayerList.getInstance().resize();
                break;
            }
        }
    }

    private ObservableList<User> getSearchedList(ObservableList<User> mainList, String name) {

        if (name.isEmpty()) {
            SnakePlayerList.getInstance().setDefaultMainList();
            return null;
        }

        List<User> resultList = new LinkedList<>();

        mainList.forEach(user -> {
            if (user.getSnakePlayer().getName().contains(name)) {
                resultList.add(user);
            }
        });

        return FXCollections.observableArrayList(resultList);
    }

}
