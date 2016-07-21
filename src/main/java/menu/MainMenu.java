package menu;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import main.Main;

public class MainMenu {

    private static final MenuBox menuBox = new MenuBox();

    private static SubMenu getMainMenu(){
        Region authorization = ComponentBuilder.create(Component.BUTTON, "АВТОРИЗАЦІЯ");
        Region registration = ComponentBuilder.create(Component.BUTTON, "РЕЄСТРАЦІЯ");
        Region exitGame = ComponentBuilder.create(Component.BUTTON, "ВИХІД");

        authorization.setOnMouseClicked(event -> menuBox.setSubMenu(getAuthorizationMenu()));
        registration.setOnMouseClicked(event -> menuBox.setSubMenu(getRegistrationMenu()));
        exitGame.setOnMouseClicked(event -> System.exit(0));

        return new SubMenu(authorization, registration, exitGame);
    }

    private static SubMenu getAuthorizationMenu() {
        Region auth = ComponentBuilder.create(Component.LABEL, "АВТОРИЗАЦІЯ");
        Region login = ComponentBuilder.create(Component.FIELD, "Ваш логін");
        Region password = ComponentBuilder.create(Component.FIELD, "Ваш пароль");
        Region confirmAuthorization = ComponentBuilder.create(Component.BUTTON, "ВХІД");
        Region optionsBack = ComponentBuilder.create(Component.BUTTON, "НАЗАД");

        optionsBack.setOnMouseClicked(event -> menuBox.setSubMenu(getMainMenu()));

        return new SubMenu(auth, login, password, confirmAuthorization, optionsBack);
    }

    private static SubMenu getRegistrationMenu() {
        Region reg = ComponentBuilder.create(Component.LABEL, "РЕЄСТРАЦІЯ");
        Region login = ComponentBuilder.create(Component.FIELD, "Ваш логін");
        Region password = ComponentBuilder.create(Component.FIELD, "Ваш пароль");
        Region confirmRegistration = ComponentBuilder.create(Component.BUTTON, "ЗАРЕЄСТРУВАТИСЯ");
        Region optionsBack = ComponentBuilder.create(Component.BUTTON, "НАЗАД");

        optionsBack.setOnMouseClicked(event -> menuBox.setSubMenu(getMainMenu()));

        return new SubMenu(reg, login, password, confirmRegistration, optionsBack);
    }

    public static void initMenu(Scene scene) {
        menuBox.init(getMainMenu());
        Main.getRoot().getChildren().add(menuBox);
    }

}