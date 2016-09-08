package user_interface.account.content.fight.slots;

import events.KeyboardEvents;
import events.Mode;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import main.SnakePane;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.User;
import user_interface.account.battlefield.menu.SnakesPane;
import user_interface.animation.TransitionAnimation;

import java.util.ArrayList;

public class SlotsBox extends HBox {

    public static final Slot mySlot = new Slot(User.getInstance().getSnakePlayer(), 1);
    public static final ArrayList<Slot> enemySlots = new ArrayList<>(3);

    public static SlotsBox instance = new SlotsBox();

    private SlotsBox() {
        double spacing = 5;
        double width = MainMenu.CONTENT_WIDTH - 2 * spacing;
        double height = WindowSettings.height * 0.1;

        setPrefSize(width, height);
        setAlignment(Pos.CENTER);
        setTranslateX(spacing);
        setSpacing(spacing);

        getChildren().add(mySlot);
        enemySlots.add(new Slot(2));
        enemySlots.add(new Slot(3));
        enemySlots.add(new Slot(4));

        enemySlots.forEach(slot -> getChildren().add(slot));

        Button startBattle = new Button("Почати бій");

        startBattle.setFont(Font.font(17));
        startBattle.setPrefSize(getPrefWidth() / 9.5, WindowSettings.height * 0.067);
        startBattle.setOnMouseClicked(event -> startBattle());

        getChildren().add(startBattle);
    }

    private void startBattle() {
        SnakesPane.update();
        KeyboardEvents.setMode(Mode.BATTLEFIELD_MODE);
        TransitionAnimation.start(MainMenu.instance, SnakePane.instance);
    }

    public static ArrayList<Slot> getEnemySlots() {
        return enemySlots;
    }
}
