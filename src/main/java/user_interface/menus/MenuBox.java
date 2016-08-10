package user_interface.menus;

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.WindowSettings;
import org.controlsfx.control.Notifications;
import user_interface.Centering;
import user_interface.animation.TransitionAnimation;

public class MenuBox {
    private static SubMenu subMenu;
    private static boolean isVisible;
    private static FadeTransition ft;
    private static final Pane pane = new Pane();

    static {
        pane.setPrefSize(WindowSettings.width, WindowSettings.height);
    }

    public static void init(Pane root) {
        MenuBox.subMenu = StartMenu.mainMenu;

        TransitionAnimation.load(pane);

        pane.setVisible(false);
        pane.getChildren().add(subMenu);
        Centering.centering(subMenu, pane);

        root.getChildren().add(pane);
    }

    public static void setSubMenu(SubMenu newMenu) {
        if (TransitionAnimation.start(pane, subMenu, newMenu)) Centering.centering(newMenu, pane);

        subMenu = newMenu;
    }

    public static void show() {
        isVisible = true;
        pane.setVisible(true);
    }

    public static void hide() {
        isVisible = false;
        pane.setVisible(false);
    }

    public static void escapeEvent() {
        if (ft != null) ft.stop();
        ft = new FadeTransition(Duration.millis(TransitionAnimation.ESCAPE_EFFECT_DURATION), pane);
        if (!isVisible) {
            pane.setVisible(true);
            isVisible = true;
            ft.setFromValue(pane.getOpacity());
            ft.setToValue(1);
            ft.play();
        } else {
            isVisible = false;
            ft.setFromValue(pane.getOpacity());
            ft.setToValue(0);
            ft.setOnFinished(e -> pane.setVisible(false));
            ft.play();
        }
    }

    public static Pane getMenuBox() {
        return pane;
    }

}