package user_interface.account.content.fight.slots;

import client_server_I_O.Client;
import events.KeyboardEvents;
import events.Mode;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import main.Receiver;
import main.SnakePane;
import main.WindowSettings;
import messages.MessageType;
import messages.Messenger;
import user_interface.account.MainMenu;
import user_interface.account.User;
import user_interface.account.battlefield.Game;
import user_interface.account.battlefield.menu.GameSpeedChanger;
import user_interface.account.battlefield.menu.SnakesPane;
import user_interface.animation.TransitionAnimation;

import java.util.ArrayList;

public class SlotsBox extends HBox {

    public static final Slot mySlot = new Slot(User.getInstance(), 1);
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
        new Thread(() -> {

            String first = getFirstLogin();
            String second = getSecondLogin();
            String third = getThirdLogin();
            String fourth = getFourthLogin();

            if (second == null) {
                Platform.runLater(() -> Messenger.showMessage(MessageType.CHOOSE_ENEMY));
                return;
            }

            SnakesPane.reset();

            Platform.runLater(SnakesPane::update);
            Platform.runLater(() -> KeyboardEvents.setMode(Mode.BATTLEFIELD_MODE));
            TransitionAnimation.start(MainMenu.instance, SnakePane.instance);
            Platform.runLater(() -> Messenger.showMessage(MessageType.STARTING_GAME));

            GameSpeedChanger.reset();

//            Game.play(Receiver.getGameResult(first, second, third, fourth));
            Game.play(Client.getGameResult(first, second, third, fourth));
        }).start();

    }

    public static ArrayList<Slot> getEnemySlots() {
        return enemySlots;
    }

    private static String getFirstLogin() {
        return User.getInstance().getLogin();
    }

    private static String getSecondLogin() {
        return getLogin(0);
    }

    private static String getThirdLogin() {
        return getLogin(1);
    }

    private static String getFourthLogin() {
        return getLogin(2);
    }

    private static String getLogin(int index) {
        User u = enemySlots.get(index).getCurrentPlayer();
        return u == User.DEFAULT_USER ? null : u.getLogin();
    }

    public static User getPlayer(int index) {
        User u = enemySlots.get(index).getCurrentPlayer();
        return u == User.DEFAULT_USER ? null : u;
    }

    public static void updateRating(int slotIndex, User user) {
        Platform.runLater(()->{
            switch (slotIndex) {
                case 0: mySlot.updateSlot(user); break;
                case 1: enemySlots.get(0).updateSlot(user); break;
                case 2: enemySlots.get(1).updateSlot(user); break;
                case 3: enemySlots.get(2).updateSlot(user); break;
            }
        });
    }

    public static void reset() {
        User first = enemySlots.get(0).getCurrentPlayer();
        User second = enemySlots.get(1).getCurrentPlayer();
        User third = enemySlots.get(2).getCurrentPlayer();

        reset(first == User.DEFAULT_USER, second == User.DEFAULT_USER, third == User.DEFAULT_USER);
    }

    private static void reset(boolean isFirstDefault, boolean isSecondDefault, boolean isThirdDefault) {
        if (isFirstDefault && isSecondDefault && !isThirdDefault) {
            swap(0, 2);
        }
        if (isFirstDefault && !isSecondDefault && isThirdDefault) {
            swap(0, 1);
        }
        if (isFirstDefault && !isSecondDefault && !isThirdDefault) {
            swap(0, 2);
        }
        if (!isFirstDefault && isSecondDefault && !isThirdDefault) {
            swap(1, 2);
        }
    }

    private static void swap(int firstSlot, int secondSlot) {
        User u2 = enemySlots.get(secondSlot).getCurrentPlayer();

        enemySlots.get(firstSlot).takeSlot(u2);
        enemySlots.get(secondSlot).takeSlot(User.DEFAULT_USER);
        enemySlots.get(secondSlot).setOccupied(false);
    }

}
