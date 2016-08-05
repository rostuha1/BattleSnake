package user_interface.account.content.fight;

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
import javafx.scene.text.Text;
import main.WindowSettings;
import user_interface.account.MainMenu;

public class SnakeViewerPane extends VBox {

    private static final double WIDTH_SPACING = 25;
    private static final double HEIGHT_SPACING = 50;
    private static final double WIDTH = MainMenu.CONTENT_WIDTH / 2 + WIDTH_SPACING * 2;
    private static final double HEIGHT = WindowSettings.height / 1.5 + HEIGHT_SPACING * 2;

    {
        setMaxSize(WIDTH, HEIGHT);

        Label label = new Label("ВИБІР СУПРОТИВНИКІВ:");
        HBox.setMargin(label, new Insets(0, 80, 0, 0));
        label.setFont(new Font(18));
        label.setStyle("-fx-font-size: 18; -fx-text-fill: rgb(209, 214, 144); -fx-font-weight: bold");

        TextField textField = new TextField();
        textField.setPromptText("Пошук по імені...");
        textField.setFocusTraversable(false);

        Button btnFind = new Button("Шукати");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(label, textField, btnFind);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.setMaxHeight(20);
        setSpacing(20);

        ObservableList<SnakePlayer> list = FXCollections.observableArrayList();
        list.addAll(new SnakePlayer("snake1.png", "ann", 1010, "Let's fight with me!"),
                new SnakePlayer("snake2.png", "rost", 1500, "111"),
                new SnakePlayer("snake3.png", "chuvak", 1000, "I am a super snake :)"));

        SnakeList.getInstance().setList(list);

        Button btnSelect = new Button("ВИБРАТИ");
        btnSelect.setFont(new Font(17));
        btnSelect.setOnAction(event -> {
            MultipleSelectionModel<SnakePlayer> model = SnakeList.getInstance().getSelectionModel();
            if (model.getSelectedIndex() != -1)
            onSelect(model.getSelectedItem());
        });
        setAlignment(Pos.CENTER_RIGHT);

        getChildren().addAll(hBox, SnakeList.getInstance(), btnSelect);
    }

    private void onSelect(SnakePlayer enemy) {
        for (Slot slot : SlotsBox.slots) {
            if (!slot.isOccupied()) {
                slot.takeSlot(enemy);
                SnakeList.getInstance().getList().remove(enemy);
                SnakeList.getInstance().resize();
                break;
            }
        }
    }
}
