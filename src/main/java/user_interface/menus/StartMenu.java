package user_interface.menus;

import client_server_I_O.Client;
import client_server_I_O.classes.User;
import events.KeyboardEvents;
import events.Mode;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import main.Main;
import main.SnakePane;
import messages.Messenger;
import user_interface.Component;
import user_interface.ComponentBuilder;
import user_interface.account.MainMenu;
import user_interface.account.battlefield.menu.SnakesPane;
import user_interface.account.content.intelligence.Settings;

import static messages.MessageType.*;

public class StartMenu {

    private static final double BUTTON_OPACITY = 0.5;
    private static final Color BUTTON_COLOR = Color.web("0x195519");
    private static final Color TEXT_COLOR = Color.web("0x58B858");

    public static final SubMenu mainMenu = getMainMenu();
    public static final SubMenu authorizationMenu = getAuthorizationMenu();
    public static final SubMenu registrationMenu = getRegistrationMenu();

    private static TextField regLoginField;
    private static PasswordField regPassField;
    private static Region regButton;
    private static Region regBack;

    private static TextField authLoginField;
    private static PasswordField authPassField;
    private static Region authButton;
    private static Region authBack;

    private static Region auth;
    private static Region reg;
    private static Region exit;

    private static boolean lock;

    public static SubMenu getMainMenu() {
        Region authorization = ComponentBuilder.getButton("АВТОРИЗАЦІЯ", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region registration = ComponentBuilder.getButton("РЕЄСТРАЦІЯ", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region exitGame = ComponentBuilder.getButton("ВИХІД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);

        authorization.setOnMouseClicked(event -> {
            doButtonClickEffect(authorization);
            MenuBox.setSubMenu(authorizationMenu);
            KeyboardEvents.setMode(Mode.AUTHORIZATION_MENU_MODE);
        });
        registration.setOnMouseClicked(event -> {
            doButtonClickEffect(registration);
            MenuBox.setSubMenu(registrationMenu);
            KeyboardEvents.setMode(Mode.REGISTRATION_MENU_MODE);
        });
        exitGame.setOnMouseClicked(event -> {
            doButtonClickEffect(exitGame);
            KeyboardEvents.setMode(Mode.NULL);
            System.exit(0);
        });

        if (auth == null) auth = authorization;
        if (reg == null) reg = registration;
        if (exit == null) exit = exitGame;

        return new SubMenu(authorization, registration, exitGame);
    }

    public static SubMenu getAuthorizationMenu() {
        Region auth = ComponentBuilder.create(Component.LABEL, "АВТОРИЗАЦІЯ");
        TextField login = (TextField) ComponentBuilder.create(Component.FIELD, "Ваш логін");
        PasswordField password = (PasswordField) ComponentBuilder.create(Component.PASSWORD_FIELD, "Ваш пароль");
        Region confirmAuthorization = ComponentBuilder.getButton("ВХІД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region optionsBack = ComponentBuilder.getButton("НАЗАД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);

        login.setOnMouseClicked(event -> KeyboardEvents.setTab(true));
        password.setOnMouseClicked(event -> KeyboardEvents.setTab(false));

        optionsBack.setOnMouseClicked(backEvent(optionsBack, login, password));

        confirmAuthorization.setOnMouseClicked(event -> {
            doButtonClickEffect(confirmAuthorization);
            authorization(login.getText(), password.getText());
        });

        if (authLoginField == null) authLoginField = login;
        if (authPassField == null) authPassField = password;
        if (authButton == null) authButton = confirmAuthorization;
        if (authBack == null) authBack = optionsBack;

        return new SubMenu(auth, login, password, confirmAuthorization, optionsBack);
    }

    private static SubMenu getRegistrationMenu() {
        Region reg = ComponentBuilder.create(Component.LABEL, "РЕЄСТРАЦІЯ");
        TextField login = (TextField) ComponentBuilder.create(Component.FIELD, "Ваш логін");
        PasswordField password = (PasswordField) ComponentBuilder.create(Component.PASSWORD_FIELD, "Ваш пароль");
        Region confirmRegistration = ComponentBuilder.getButton("ЗАРЕЄСТРУВАТИСЯ", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region optionsBack = ComponentBuilder.getButton("НАЗАД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);

        login.setOnMouseClicked(event -> KeyboardEvents.setTab(true));
        password.setOnMouseClicked(event -> KeyboardEvents.setTab(false));

        optionsBack.setOnMouseClicked(backEvent(optionsBack, login, password));

        confirmRegistration.setOnMouseClicked(event -> {
            System.out.println(11);
            doButtonClickEffect(confirmRegistration);
            System.out.println(22);
            registration(login.getText(), password.getText());
        });

        if (regLoginField == null) regLoginField = login;
        if (regPassField == null) regPassField = password;
        if (regButton == null) regButton = confirmRegistration;
        if (regBack == null) regBack = optionsBack;

        return new SubMenu(reg, login, password, confirmRegistration, optionsBack);
    }

    private static void authorization(String login, String password) {
        new Thread(() -> {

            if (lock) return;

            if (Client.getConnectionThread() != null) {
                try {
                    Client.getConnectionThread().join();
                } catch (InterruptedException ignored) {
                }
            }

            User user = Client.getUser(login, password);

            if (user != null) {
                Platform.runLater(() -> Messenger.showMessage(SUCCESSFUL_AUTHORIZATION));
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ignored) {
                }
                Platform.runLater(StartMenu::goToAccount);
            } else
                Platform.runLater(() -> Messenger.showMessage(UNSUCCESSFUL_REGISTRATION));

            lock = false;
        }).start();
    }

    private static void registration(String login, String password) {
        new Thread(() -> {

            if (lock) return;

            User user = new User();
            user.setLogin(login);
            user.setPassword(password);

            if (Client.getConnectionThread() != null) {
                try {
                    Client.getConnectionThread().join();
                } catch (InterruptedException e) {
                }
            }

            if (Client.addUser(user)) {
                Platform.runLater(() -> Messenger.showMessage(SUCCESSFUL_REGISTRATION));
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ignored) {
                }
                KeyboardEvents.setMode(Mode.AUTHORIZATION_MENU_MODE);
                Platform.runLater(() -> MenuBox.setSubMenu(StartMenu.authorizationMenu));
            } else
                Platform.runLater(() -> Messenger.showMessage(UNSUCCESSFUL_REGISTRATION));

            lock = false;
        }).start();
    }

    private static void goToAccount() {
        MenuBox.hide();
        Main.getRoot().getChildren().add(SnakePane.instance);
        Main.getRoot().getChildren().add(MainMenu.instance);
        SnakesPane.init();
    }

    private static void doButtonClickEffect(Region optionsBack) {
        new Thread(() -> {
            Platform.runLater(() -> optionsBack.setEffect(Settings.itemEffect));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
            Platform.runLater(() -> optionsBack.setEffect(null));
        }).start();
    }

    private static EventHandler<? super MouseEvent> backEvent(Region btnBack, TextField login, PasswordField password) {
        return event -> {
            login.setFocusTraversable(false);
            password.setFocusTraversable(false);
            doButtonClickEffect(btnBack);
            MenuBox.setSubMenu(mainMenu);
            KeyboardEvents.setMode(Mode.MAIN_MENU_MODE);
        };
    }

    public static TextField getRegLoginField() {
        return regLoginField;
    }

    public static PasswordField getRegPassField() {
        return regPassField;
    }

    public static Region getRegButton() {
        return regButton;
    }

    public static Region getRegBack() {
        return regBack;
    }

    public static TextField getAuthLoginField() {
        return authLoginField;
    }

    public static PasswordField getAuthPassField() {
        return authPassField;
    }

    public static Region getAuthButton() {
        return authButton;
    }

    public static Region getAuthBack() {
        return authBack;
    }

    public static Region getAuth() {
        return auth;
    }

    public static Region getReg() {
        return reg;
    }

    public static Region getExit() {
        return exit;
    }
}