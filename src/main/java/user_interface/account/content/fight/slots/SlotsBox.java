package user_interface.account.content.fight.slots;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.content.fight.list.SnakePlayer;

import java.util.ArrayList;

public class SlotsBox extends HBox {

    public static ArrayList<Slot> enemySlots = new ArrayList<>(4);

    {
        double spacing = 5;
        double width = MainMenu.CONTENT_WIDTH - 2 * spacing;
        double height = WindowSettings.height * 0.1;

        setPrefSize(width, height);
        setAlignment(Pos.CENTER);
        setTranslateX(spacing);
        setSpacing(spacing);
    }

    public SlotsBox(SnakePlayer thisSnake) {

        Slot mySlot = new Slot(thisSnake);
        enemySlots.add(new Slot());
        enemySlots.add(new Slot());
        enemySlots.add(new Slot());

        Button startBattle = new Button("Почати бій");
        startBattle.setFont(new Font(17));
        startBattle.setPrefSize(getPrefWidth() / 9, WindowSettings.height * 0.067);

        getChildren().add(mySlot);

        for (Slot slot: enemySlots) {
            getChildren().add(slot);
        }
        getChildren().add(startBattle);
    }

}
