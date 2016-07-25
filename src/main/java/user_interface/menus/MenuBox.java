package user_interface.menus;

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import main.WindowSettings;
import user_interface.Centering;

public class MenuBox {
    private static SubMenu subMenu;
    private static boolean isVisible;
    private static FadeTransition ft;
    private static final Pane pane = new Pane();
    private static boolean pressLock;

    static {
        pane.setPrefSize(WindowSettings.width, WindowSettings.height);
    }

    public static void init(Pane root) {
        MenuBox.subMenu = StartMenu.mainMenu;

        SubMenuAnimation.load(pane);

        pane.setVisible(false);
        pane.getChildren().add(subMenu);
        Centering.centering(subMenu, pane);

        root.getChildren().add(pane);
    }

    public static void setSubMenu(SubMenu newMenu) {
        if (pressLock) return;
        pressLock = true;

        Centering.centering(newMenu, pane);
        SubMenuAnimation.start(subMenu, newMenu);

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
        ft = new FadeTransition(Duration.millis(SubMenuAnimation.ESCAPE_EFFECT_DURATION), pane);
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

    private static class SubMenuAnimation {

        private static Pane pane;

        static final int ESCAPE_EFFECT_DURATION = 500;
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
            SubMenuAnimation.pane = pane;

            SubMenu mainMenu = StartMenu.getMainMenu();
            SubMenu newMenu = StartMenu.getAuthorizationMenu();

            pane.getChildren().addAll(mainMenu);

            hideAnimation.setDuration(Duration.millis(1));
            showAnimation.setDuration(Duration.millis(1));

            start(mainMenu, newMenu);

            pane.getChildren().removeAll(mainMenu, newMenu);

            hideAnimation.setNode(null);
            showAnimation.setNode(null);

            hideAnimation.setDuration(Duration.millis(EFFECT_DURATION));
            showAnimation.setDuration(Duration.millis(EFFECT_DURATION));
        }

        public static void start(SubMenu currentMenu, SubMenu newMenu) {
            hideAnimation.setNode(currentMenu);
            showAnimation.setNode(newMenu);

            hideAnimation.setOnFinished(event -> {
                newMenu.setOpacity(0);
                pane.getChildren().remove(currentMenu);
                pane.getChildren().add(newMenu);
                showAnimation.play();
            });

            hideAnimation.play();
        }

    }


}