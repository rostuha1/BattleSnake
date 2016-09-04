package user_interface.menus;

import client_server_I_O.Client;
import client_server_I_O.classes.User;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import messages.Messenger;
import user_interface.Component;
import user_interface.ComponentBuilder;

import static messages.MessageType.*;

public class StartMenu {

    private static final double BUTTON_OPACITY = 0.5;
    private static final Color BUTTON_COLOR = Color.web("0x195519");
    private static final Color TEXT_COLOR = Color.web("0x58B858");

    public static final SubMenu mainMenu = getMainMenu();
    public static final SubMenu authorizationMenu = getAuthorizationMenu();
    public static final SubMenu registrationMenu = getRegistrationMenu();

    public static SubMenu getMainMenu() {
        Region authorization = ComponentBuilder.getButton("АВТОРИЗАЦІЯ", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region registration = ComponentBuilder.getButton("РЕЄСТРАЦІЯ", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region exitGame = ComponentBuilder.getButton("ВИХІД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);

        authorization.setOnMouseClicked(event -> MenuBox.setSubMenu(authorizationMenu));
        registration.setOnMouseClicked(event -> MenuBox.setSubMenu(registrationMenu));
        exitGame.setOnMouseClicked(event -> System.exit(0));

        return new SubMenu(authorization, registration, exitGame);
    }

    public static SubMenu getAuthorizationMenu() {
        Region auth = ComponentBuilder.create(Component.LABEL, "АВТОРИЗАЦІЯ");
        TextField login = (TextField) ComponentBuilder.create(Component.FIELD, "Ваш логін");
        PasswordField password = (PasswordField) ComponentBuilder.create(Component.PASSWORD_FIELD, "Ваш пароль");
        Region confirmAuthorization = ComponentBuilder.getButton("ВХІД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region optionsBack = ComponentBuilder.getButton("НАЗАД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);

        optionsBack.setOnMouseClicked(event -> MenuBox.setSubMenu(mainMenu));
        confirmAuthorization.setOnMouseClicked(event -> authorization(login.getText(), password.getText()));

        return new SubMenu(auth, login, password, confirmAuthorization, optionsBack);
    }

    public static SubMenu getRegistrationMenu() {
        Region reg = ComponentBuilder.create(Component.LABEL, "РЕЄСТРАЦІЯ");
        TextField login = (TextField) ComponentBuilder.create(Component.FIELD, "Ваш логін");
        PasswordField password = (PasswordField) ComponentBuilder.create(Component.PASSWORD_FIELD, "Ваш пароль");
        Region confirmRegistration = ComponentBuilder.getButton("ЗАРЕЄСТРУВАТИСЯ", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);
        Region optionsBack = ComponentBuilder.getButton("НАЗАД", BUTTON_OPACITY, TEXT_COLOR, BUTTON_COLOR);

        optionsBack.setOnMouseClicked(event -> MenuBox.setSubMenu(mainMenu));
        confirmRegistration.setOnMouseClicked(event -> registration(login.getText(), password.getText()));

        return new SubMenu(reg, login, password, confirmRegistration, optionsBack);
    }

    private static void authorization(String login, String password) {
//        new Thread(() -> {
            User user = new User();
            user.setLogin(login);
            user.setLogin(password);

            System.out.println(Client.getUser(login, password));
//        }).start();
    }

    private static void registration(String login, String password) {
//        new Thread(() -> {
            User user = new User();
            user.setLogin(login);
            user.setLogin(password);

            System.out.println(Client.addUser(user));
//        }).start();
    }

}