package user_interface.animation;

import events.AdditionalOnFinishEvent;
import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.Main;
import org.controlsfx.control.Notifications;
import user_interface.account.battlefield.Grid;
import user_interface.menus.StartMenu;
import user_interface.menus.SubMenu;

public class TransitionAnimation {

    private static boolean pressLock;
    private static boolean pressLock2;

    public static final int ESCAPE_EFFECT_DURATION = 500;
    static int EFFECT_DURATION = 300;

    private static FadeTransition showAnimation = new FadeTransition();
    private static FadeTransition hideAnimation = new FadeTransition();

    static {
        showAnimation.setFromValue(0);
        showAnimation.setToValue(1);
        hideAnimation.setFromValue(1);
        hideAnimation.setToValue(0);

        showAnimation.setOnFinished(event -> pressLock = false);
    }

    public static void load(Pane pane) {

        Notifications.create().owner(new Stage()).showInformation();

        SubMenu mainMenu = StartMenu.getMainMenu();
        SubMenu newMenu = StartMenu.getAuthorizationMenu();

        pane.getChildren().addAll(mainMenu);

        hideAnimation.setDuration(Duration.millis(1));
        showAnimation.setDuration(Duration.millis(1));

        start(pane, mainMenu, newMenu);

        pane.getChildren().removeAll(mainMenu, newMenu);

        hideAnimation.setNode(null);
        showAnimation.setNode(null);

        hideAnimation.setDuration(Duration.millis(EFFECT_DURATION));
        showAnimation.setDuration(Duration.millis(EFFECT_DURATION));

    }

    public static boolean start(Pane parent, Pane currentMenu, Pane newMenu) {
        if (currentMenu == newMenu || pressLock) return false;
        pressLock = true;

        hideAnimation.setNode(currentMenu);
        showAnimation.setNode(newMenu);

        hideAnimation.setOnFinished(event -> {
            newMenu.setOpacity(0);
            if (parent instanceof BorderPane) {
                ((BorderPane) parent).setCenter(newMenu);
            } else {
                parent.getChildren().remove(currentMenu);
                parent.getChildren().add(newMenu);
            }
            showAnimation.play();
        });

        hideAnimation.play();

        return true;
    }

    public static void start(Pane hidePane, Pane showPane) {

        if (pressLock2) return;
        pressLock2 = true;

        FadeTransition showAnimation = new FadeTransition(Duration.millis(EFFECT_DURATION));
        FadeTransition hideAnimation = new FadeTransition(Duration.millis(EFFECT_DURATION));

        hideAnimation.setNode(hidePane);
        showAnimation.setNode(showPane);

        showAnimation.setFromValue(0);
        showAnimation.setToValue(1);
        hideAnimation.setFromValue(1);
        hideAnimation.setToValue(0);

        hidePane.setMouseTransparent(true);
        showPane.setMouseTransparent(false);

        showAnimation.setOnFinished(event -> pressLock2 = false);

        hideAnimation.setOnFinished(event -> {
            showPane.setOpacity(0);
            showAnimation.play();
        });

        hideAnimation.play();

    }
    public static void start(Pane hidePane, Pane showPane, AdditionalOnFinishEvent additionalOnFinishEvent) {

        if (additionalOnFinishEvent == null) start(hidePane, showPane);

        if (pressLock2) return;
        pressLock2 = true;

        FadeTransition showAnimation = new FadeTransition(Duration.millis(EFFECT_DURATION));
        FadeTransition hideAnimation = new FadeTransition(Duration.millis(EFFECT_DURATION));

        hideAnimation.setNode(hidePane);
        showAnimation.setNode(showPane);

        showAnimation.setFromValue(0);
        showAnimation.setToValue(1);
        hideAnimation.setFromValue(1);
        hideAnimation.setToValue(0);

        hidePane.setMouseTransparent(true);
        showPane.setMouseTransparent(false);

        showAnimation.setOnFinished(event -> {
            pressLock2 = false;
            additionalOnFinishEvent.doEvent();
        });

        hideAnimation.setOnFinished(event -> {
            showPane.setOpacity(0);
            showAnimation.play();
        });

        hideAnimation.play();

    }

}