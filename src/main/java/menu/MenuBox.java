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

public class MenuBox extends Pane {
    private static SubMenu subMenu;
    private static MenuBox menuBox;
    private static boolean isVisible;
    private static FadeTransition ft;

    public MenuBox() {
        menuBox = this;
        menuBox.setOpacity(0);
    }

    public void init(SubMenu subMenu)  {
        MenuBox.subMenu = subMenu;

        setVisible(false);
        isVisible = false;
        Rectangle bg = new Rectangle(Main.getRoot().getWidth(), Main.getRoot().getHeight());
        Image image = new Image("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\background.jpg");
        ImagePattern pattern = new ImagePattern(image);
        bg.setFill(pattern);
        bg.setOpacity(0.9);
        getChildren().addAll(bg, subMenu);
    }

    public void setSubMenu(SubMenu newMenu) {
        SubMenuAnimation.init(this, subMenu, newMenu);
        SubMenuAnimation.start();
        subMenu = newMenu;
    }

    private static class SubMenuAnimation {

        private static SubMenu currentMenu;
        private static SubMenu newMenu;

        private static final int duration = 500;

        private static Animation showAnimation = new Transition() {
            { setCycleDuration(Duration.millis(duration)); }
            @Override
            protected void interpolate(double frac) {
                newMenu.setOpacity(frac);
            }
        };
        private static Animation hideAnimation = new Transition() {
            { setCycleDuration(Duration.millis(duration)); }
            @Override
            protected void interpolate(double frac) {
                currentMenu.setOpacity(1 - frac);
            }
        };

        public static void init(MenuBox menuBox, SubMenu currentMenu, SubMenu newMenu) {
            SubMenuAnimation.currentMenu = currentMenu;
            SubMenuAnimation.newMenu = newMenu;

            hideAnimation.setOnFinished(event -> {
                newMenu.setOpacity(0);
                menuBox.getChildren().remove(currentMenu);
                menuBox.getChildren().add(newMenu);
                showAnimation.play();
            });
        }

        public static void start() {
            hideAnimation.play();
        }

    }

    public static void escapeEvent() {
        if (ft != null) ft.stop();
        ft = new FadeTransition(Duration.seconds(2), menuBox);
        if (!isVisible) {
            menuBox.setVisible(true);
            isVisible = true;
            ft.setFromValue(menuBox.getOpacity());
            ft.setToValue(1);
            ft.play();
        } else {
            isVisible = false;
            ft.setFromValue(menuBox.getOpacity());
            ft.setToValue(0);
            ft.setOnFinished(e -> menuBox.setVisible(false));
            ft.play();
        }
    }
}