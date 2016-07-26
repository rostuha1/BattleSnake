package user_interface.menus;

import client_server.ServerResponse;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import messages.Messenger;
import user_interface.Component;
import user_interface.ComponentBuilder;

import static messages.MessageType.SUCCESSFUL_AUTHORIZATION;
import static messages.MessageType.SUCCESSFUL_REGISTRATION;
import static messages.MessageType.UNAVAILABLE_SERVER;
import static messages.MessageType.UNSUCCESSFUL_AUTHORIZATION;
import static messages.MessageType.UNSUCCESSFUL_REGISTRATION;

public class StartMenu {

    public static final SubMenu mainMenu = getMainMenu();
    public static final SubMenu authorizationMenu = getAuthorizationMenu();
    public static final SubMenu registrationMenu = getRegistrationMenu();

    private static ServerResponse response = new ServerResponse();

    public static SubMenu getMainMenu() {
        Region authorization = ComponentBuilder.create(Component.BUTTON, "АВТОРИЗАЦІЯ");
        Region registration = ComponentBuilder.create(Component.BUTTON, "РЕЄСТРАЦІЯ");
        Region exitGame = ComponentBuilder.create(Component.BUTTON, "ВИХІД");

        authorization.setOnMouseClicked(event -> MenuBox.setSubMenu(authorizationMenu));
        registration.setOnMouseClicked(event -> MenuBox.setSubMenu(registrationMenu));
        exitGame.setOnMouseClicked(event -> System.exit(0));

        return new SubMenu(authorization, registration, exitGame);
    }
    public static SubMenu getAuthorizationMenu() {
        Region auth = ComponentBuilder.create(Component.LABEL, "АВТОРИЗАЦІЯ");
        TextField login = (TextField) ComponentBuilder.create(Component.FIELD, "Ваш логін");
        PasswordField password = (PasswordField) ComponentBuilder.create(Component.PASSWORD_FIELD, "Ваш пароль");
        Region confirmAuthorization = ComponentBuilder.create(Component.BUTTON, "ВХІД");
        Region optionsBack = ComponentBuilder.create(Component.BUTTON, "НАЗАД");

        confirmAuthorization.setOnMouseClicked(event -> {
            switch (response.authorizationResponse(login.getText(), password.getText())){
                case SUCCESSFUL_AUTHORIZATION: Messenger.showMessage(SUCCESSFUL_AUTHORIZATION); break;
                case UNSUCCESSFUL_AUTHORIZATION: Messenger.showMessage(UNSUCCESSFUL_AUTHORIZATION); break;
                case UNAVAILABLE_SERVER: Messenger.showMessage(UNAVAILABLE_SERVER); break;
            }
        });
        optionsBack.setOnMouseClicked(event -> MenuBox.setSubMenu(mainMenu));

        return new SubMenu(auth, login, password, confirmAuthorization, optionsBack);
    }
    public static SubMenu getRegistrationMenu() {
        Region reg = ComponentBuilder.create(Component.LABEL, "РЕЄСТРАЦІЯ");
        TextField login = (TextField) ComponentBuilder.create(Component.FIELD, "Ваш логін");
        PasswordField password = (PasswordField) ComponentBuilder.create(Component.PASSWORD_FIELD, "Ваш пароль");
        Region confirmRegistration = ComponentBuilder.create(Component.BUTTON, "ЗАРЕЄСТРУВАТИСЯ");
        Region optionsBack = ComponentBuilder.create(Component.BUTTON, "НАЗАД");

        confirmRegistration.setOnMouseClicked(event -> {
            switch (response.registrationResponse(login.getText(), password.getText())){
                case SUCCESSFUL_REGISTRATION: Messenger.showMessage(SUCCESSFUL_REGISTRATION); break;
                case UNSUCCESSFUL_REGISTRATION: Messenger.showMessage(UNSUCCESSFUL_REGISTRATION); break;
                case UNAVAILABLE_SERVER: Messenger.showMessage(UNAVAILABLE_SERVER); break;
            }
        });
        optionsBack.setOnMouseClicked(event -> MenuBox.setSubMenu(mainMenu));

        return new SubMenu(reg, login, password, confirmRegistration, optionsBack);
    }

}