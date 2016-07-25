package user_interface.menus;

import javafx.scene.layout.Region;
import user_interface.Component;
import user_interface.ComponentBuilder;

public class StartMenu {

    public static final SubMenu mainMenu = getMainMenu();
    public static final SubMenu authorizationMenu = getAuthorizationMenu();
    public static final SubMenu registrationMenu = getRegistrationMenu();

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
//        Region auth = ComponentBuilder.create(Component.LABEL, "АВТОРИЗАЦІЯ");
        Region login = ComponentBuilder.create(Component.FIELD, "Ваш логін");
        Region password = ComponentBuilder.create(Component.FIELD, "Ваш пароль");
        Region confirmAuthorization = ComponentBuilder.create(Component.BUTTON, "АВТОРИЗУВАТИСЯ");
        Region optionsBack = ComponentBuilder.create(Component.BUTTON, "НАЗАД");

        optionsBack.setOnMouseClicked(event -> MenuBox.setSubMenu(mainMenu));

        return new SubMenu(login, password, confirmAuthorization, optionsBack);
    }

    public static SubMenu getRegistrationMenu() {
//        Region reg = ComponentBuilder.create(Component.LABEL, "РЕЄСТРАЦІЯ");
        Region login = ComponentBuilder.create(Component.FIELD, "Ваш логін");
        Region password = ComponentBuilder.create(Component.FIELD, "Ваш пароль");
        Region confirmRegistration = ComponentBuilder.create(Component.BUTTON, "ЗАРЕЄСТРУВАТИСЯ");
        Region optionsBack = ComponentBuilder.create(Component.BUTTON, "НАЗАД");

        optionsBack.setOnMouseClicked(event -> MenuBox.setSubMenu(mainMenu));

        return new SubMenu(login, password, confirmRegistration, optionsBack);
    }

}