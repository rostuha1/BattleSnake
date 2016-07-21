package menu;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import main.Main;

import java.nio.file.Paths;

public class MenuBox {
    private static SubMenu subMenu;
    private static boolean isVisible;
    private static FadeTransition ft;
    private static final Pane pane = new Pane();
    private static boolean pressLock;

    public static void init(Pane root, SubMenu subMenu) {
        MenuBox.subMenu = subMenu;

        Rectangle bg = new Rectangle(Main.getRoot().getWidth(), Main.getRoot().getHeight());
        Image image = new Image("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\background.jpg");
        ImagePattern imagePattern = new ImagePattern(image);

        bg.setFill(imagePattern);
        bg.setOpacity(0.9);

        isVisible = false;
        pane.setVisible(false);
        pane.setOpacity(0);
        pane.getChildren().addAll(bg, subMenu);

        root.getChildren().add(pane);
    }

    public static void setSubMenu(SubMenu newMenu) {
        if (pressLock) return;
        pressLock = true;
        SubMenuAnimation.init(pane, subMenu, newMenu);
        SubMenuAnimation.start();

        subMenu = newMenu;
    }

    private static class SubMenuAnimation {

        private static SubMenu currentMenu;
        private static SubMenu newMenu;

        static final int ESCAPE_EFFECT_DURATION = 500;
        static final int EFFECT_DURATION = 400;

        private static Animation showAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(EFFECT_DURATION));
            }

            @Override
            protected void interpolate(double frac) {
                newMenu.setOpacity(frac);
            }
        };
        private static Animation hideAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(EFFECT_DURATION));
            }

            @Override
            protected void interpolate(double frac) {
                currentMenu.setOpacity(1 - frac);
            }
        };

        public static void init(Pane pane, SubMenu currentMenu, SubMenu newMenu) {
            SubMenuAnimation.currentMenu = currentMenu;
            SubMenuAnimation.newMenu = newMenu;

            showAnimation.setOnFinished(event -> pressLock = false);
            hideAnimation.setOnFinished(event -> {
                newMenu.setOpacity(0);
                pane.getChildren().remove(currentMenu);
                pane.getChildren().add(newMenu);
                showAnimation.play();
            });
        }

        public static void start() {
            hideAnimation.play();
        }

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
}