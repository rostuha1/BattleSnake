package events;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import main.Main;
import main.SnakePane;
import user_interface.account.MainMenu;
import user_interface.account.battlefield.snake.Snake;
import user_interface.animation.TransitionAnimation;
import user_interface.menus.StartMenu;

public class KeyboardEvents {

    public static Snake snake;
    private static Scene scene = Main.getScene();
    private static boolean tab = false;

    private static TextField currentFocusedField;

    private static EventType<KeyEvent> keyEventType = KeyEvent.KEY_PRESSED;
    private static EventHandler<KeyEvent> currentEventFilter;

    private static int menuPosIndex = -1;

    public static void setMode(Mode mode) {
        switch (mode) {
            case BATTLEFIELD_MODE:
                battlefieldMode();
                break;
            case REGISTRATION_MENU_MODE:
                registrationMode();
                break;
            case AUTHORIZATION_MENU_MODE:
                authorizationMode();
                break;
            case MAIN_MENU_MODE:
                mainMenuMode();
                break;
            case NULL:
                nullMode();
        }
    }

    public static void setTab(boolean tab) {
        KeyboardEvents.tab = tab;
    }

    private static void nullMode() {
        currentFocusedField = null;
        scene.removeEventFilter(keyEventType, currentEventFilter);
        scene.setOnKeyPressed(null);
    }

    private static void battlefieldMode() {
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                backFromBattleField();
            }
        });
    }

    public static void backFromBattleField() {
        TransitionAnimation.start(SnakePane.instance, MainMenu.instance, () -> {
            scene.setOnKeyPressed(null);
            Snake.clearField();
        });
    }

    private static void registrationMode() {
        changeMenuMode(StartMenu.getRegLoginField(), StartMenu.getRegPassField(), StartMenu.getRegButton(), StartMenu.getRegBack());
    }

    private static void authorizationMode() {
        changeMenuMode(StartMenu.getAuthLoginField(), StartMenu.getAuthPassField(), StartMenu.getAuthButton(), StartMenu.getAuthBack());
    }

    private static void changeMenuMode(TextField loginField, PasswordField passwordField, Region btnSign, Region btnBack) {
        tab = false;
        if (currentEventFilter != null) scene.removeEventFilter(keyEventType, currentEventFilter);

        currentEventFilter = event -> {
            if (event.getCode() == KeyCode.TAB) {
                setFocus(tab ? passwordField : loginField);
                tab = !tab;
            }
        };

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                scene.setOnKeyReleased(null);
                if (currentEventFilter != null) scene.removeEventFilter(keyEventType, currentEventFilter);
                Mouse.click(btnSign);
            }
            if (event.getCode() == KeyCode.ESCAPE) {
                scene.setOnKeyReleased(null);
                if (currentEventFilter != null) scene.removeEventFilter(keyEventType, currentEventFilter);
                Mouse.click(btnBack);
            }
        });

        scene.addEventFilter(KeyEvent.KEY_PRESSED, currentEventFilter);

    }

    private static void setFocus(TextField field) {
        if (currentFocusedField != null) currentFocusedField.setFocusTraversable(false);
        currentFocusedField = field;
        field.setFocusTraversable(true);
    }

    private static void mainMenuMode() {

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                switch (menuPosIndex) {
                    case -1: setMenuPosIndex(2); break;
                    case 1: setMenuPosIndex(0); break;
                    case 2: setMenuPosIndex(1); break;
                    default: setMenuPosIndex(0);
                }
            }
            if (event.getCode() == KeyCode.DOWN) {
                switch (menuPosIndex) {
                    case -1: setMenuPosIndex(0); break;
                    case 0: setMenuPosIndex(1); break;
                    case 1: setMenuPosIndex(2); break;
                    default: setMenuPosIndex(2);
                }
            }
            if (event.getCode() == KeyCode.ENTER) {
                scene.setOnKeyPressed(null);
                mainMenuEnterEvent();
            }
        });

    }

    private static void setMenuPosIndex(int index) {
        if (index < 0 || index > 2) return;
        if (menuPosIndex == index) return;

        Mouse.mouseExit(StartMenu.getAuth());
        Mouse.mouseExit(StartMenu.getReg());
        Mouse.mouseExit(StartMenu.getExit());

        menuPosIndex = index;

        switch (index) {
            case 0:
                Mouse.hover(StartMenu.getAuth());
                break;
            case 1:
                Mouse.hover(StartMenu.getReg());
                break;
            case 2:
                Mouse.hover(StartMenu.getExit());
                break;
        }
    }

    private static void mainMenuEnterEvent() {

        switch (menuPosIndex) {
            case 0: Mouse.click(StartMenu.getAuth()); break;
            case 1: Mouse.click(StartMenu.getReg()); break;
            case 2: Mouse.click(StartMenu.getExit()); break;
        }

    }

}
