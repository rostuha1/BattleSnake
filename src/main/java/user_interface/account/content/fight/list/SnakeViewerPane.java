package user_interface.account.content.fight.list;

import client_server.SnakePlayer;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.content.fight.slots.Slot;
import user_interface.account.content.fight.slots.SlotsBox;

public class SnakeViewerPane extends VBox {

    private static final double WIDTH_SPACING = 25;
    private static final double HEIGHT_SPACING = 50;
    private static final double WIDTH = MainMenu.CONTENT_WIDTH / 2 + WIDTH_SPACING * 2;
    private static final double HEIGHT = WindowSettings.height / 1.5 + HEIGHT_SPACING * 2;
    private static HBox search = new HBox();
    private static SnakeList snakeList = SnakeList.getInstance();
    private static Button btnSelect = new Button();
    private static Label message = new Label();

    private static final SnakeViewerPane instance = new SnakeViewerPane();

    public static SnakeViewerPane getInstance() {
        return instance;
    }

    public static SnakeList getSnakeList() {
        return snakeList;
    }

    private SnakeViewerPane() {
        show(snakeList.getList());
    }

    public void show(ObservableList<SnakePlayer> list) {
        getChildren().removeAll(message, search, snakeList, btnSelect);
        if (list.isEmpty()) getChildren().add(message);
        else getChildren().addAll(search, snakeList, btnSelect);
    }

    {
        setMaxSize(WIDTH, HEIGHT);
        setSpacing(20);
        setAlignment(Pos.CENTER_RIGHT);

        Label label = new Label("ВИБІР СУПРОТИВНИКІВ:");
        HBox.setMargin(label, new Insets(0, 80, 0, 0));
        label.setFont(new Font(18));
        label.setStyle("-fx-font-size: 18; -fx-text-fill: rgb(209, 214, 144); -fx-font-weight: bold");

        TextField textField = new TextField();
        textField.setPromptText("Пошук по імені...");
        textField.setFocusTraversable(false);

        Button btnFind = new Button("Шукати");
        btnFind.setOnAction(event -> {
        });

        search.getChildren().addAll(label, textField, btnFind);
        search.setSpacing(10);
        search.setAlignment(Pos.CENTER_RIGHT);
        search.setMaxHeight(20);

        ObservableList<SnakePlayer> list = FXCollections.observableArrayList();
        list.addAll(new SnakePlayer("snake2.png", "mike", 1500, Color.AQUA, "111"),
                new SnakePlayer("snake3.png", "john", 1000, Color.LIGHTGREEN, "I am a super snake :)"),
                new SnakePlayer("snake4.png", "jack", 1010, Color.CORAL, "Let's fight with me!"));

        snakeList.setList(list);

        btnSelect.setText("ВИБРАТИ");
        btnSelect.setFont(new Font(17));
        btnSelect.setOnAction(event -> {
            MultipleSelectionModel<SnakePlayer> model = SnakeList.getInstance().getSelectionModel();
            if (model.getSelectedIndex() != -1) {
                onSelect(model.getSelectedItem());
                show(snakeList.getList());
            }
        });

        message.setText("ГРАВЦІВ НЕМАЄ");
        message.setStyle("-fx-text-fill: rgb(140, 145, 95); -fx-font-size: 26;");
        message.setTranslateX(-getMaxWidth() / 3);
    }

    private void onSelect(SnakePlayer enemy) {
        for (Slot slot : SlotsBox.enemySlots) {
            if (!slot.isOccupied()) {
                slot.takeSlot(enemy);
                SnakeList.getInstance().getList().remove(enemy);
                SnakeList.getInstance().resize();
                break;
            }
        }
    }

}
