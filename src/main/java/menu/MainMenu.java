package menu;

import events.KeyboardEvents;
import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import main.Main;

public class MainMenu {

    private static final MenuBox menuBox = new MenuBox();

    private static SubMenu getMainMenu(){
        StackPane authorization = ComponentBuilder.create(Component.BUTTON, "АВТОРИЗАЦІЯ");
        StackPane registration = ComponentBuilder.create(Component.BUTTON, "РЕЄСТРАЦІЯ");
        StackPane exitGame = ComponentBuilder.create(Component.BUTTON, "ВИХІД");

        authorization.setOnMouseClicked(event -> menuBox.setSubMenu(getAuthorizationMenu()));
        registration.setOnMouseClicked(event -> menuBox.setSubMenu(getRegistrationMenu()));
        exitGame.setOnMouseClicked(event -> System.exit(0));

        return new SubMenu(authorization, registration, exitGame);
    }

    private static SubMenu getAuthorizationMenu() {
        StackPane auth = ComponentBuilder.create(Component.LABEL, "АВТОРИЗАЦІЯ");
        StackPane login = ComponentBuilder.create(Component.FIELD, "Ваш логін");
        StackPane password = ComponentBuilder.create(Component.FIELD, "Ваш пароль");
        StackPane confirmAuthorization = ComponentBuilder.create(Component.BUTTON, "ВХІД");
        StackPane optionsBack = ComponentBuilder.create(Component.BUTTON, "Назад");

        optionsBack.setOnMouseClicked(event -> menuBox.setSubMenu(getMainMenu()));

        return new SubMenu(auth, login, password, confirmAuthorization, optionsBack);
    }

    private static SubMenu getRegistrationMenu() {
        StackPane reg = ComponentBuilder.create(Component.LABEL, "РЕЄСТРАЦІЯ");
        StackPane login = ComponentBuilder.create(Component.FIELD, "Ваш логін");
        StackPane password = ComponentBuilder.create(Component.FIELD, "Ваш пароль");
        StackPane confirmRegistration = ComponentBuilder.create(Component.BUTTON, "ЗАРЕЄСТРУВАТИСЯ");
        StackPane optionsBack = ComponentBuilder.create(Component.BUTTON, "Назад");

        optionsBack.setOnMouseClicked(event -> menuBox.setSubMenu(getMainMenu()));

        return new SubMenu(reg, login, password, confirmRegistration, optionsBack);
    }

    public static void initMenu(Scene scene) {
        menuBox.init(getMainMenu());
        Main.getRoot().getChildren().add(menuBox);
        KeyboardEvents.menuBox = menuBox;
    }

}