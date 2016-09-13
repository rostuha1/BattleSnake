package messages;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Messenger {

    public static void showMessage(MessageType messageType) {
        switch (messageType) {
            case SUCCESSFUL_AUTHORIZATION: {
                Notifications.create()
                        .text("Авторизація...")
                        .hideAfter(Duration.seconds(1))
                        .showInformation();
                break;
            }
            case SUCCESSFUL_REGISTRATION: {
                Notifications.create()
                        .text("Успішна реєстрація")
                        .hideAfter(Duration.seconds(0.5))
                        .showInformation();
                break;
            }
            case UNSUCCESSFUL_AUTHORIZATION: {
                Notifications.create()
                        .title("Помилка авторизації")
                        .text("Перевірте правильність введених даних!")
                        .hideAfter(Duration.seconds(0.5))
                        .showError();
                break;
            }
            case UNSUCCESSFUL_REGISTRATION: {
                Notifications.create()
                        .title("Невдала реєстрація")
                        .text("Перевірте правильність введених даних!")
                        .hideAfter(Duration.seconds(0.5))
                        .showError();
                break;
            }
            case UNAVAILABLE_SERVER: {
                Notifications.create()
                        .text("Сервер недоступний :(")
                        .hideAfter(Duration.seconds(3))
                        .showError();
                break;
            }
            case SERVER_CONNECTED: {
                Notifications.create()
                        .text("Під'єднано").position(Pos.BOTTOM_RIGHT)
                        .hideAfter(Duration.seconds(2))
                        .showInformation();
                break;
            }
            case SAVED: {
                Notifications.create()
                        .text("Збережено").position(Pos.BOTTOM_LEFT)
                        .hideAfter(Duration.seconds(0.5))
                        .showInformation();
                break;
            }
            case SAVE_FAIL: {
                Notifications.create()
                        .text("Помилка збереження").position(Pos.BOTTOM_LEFT)
                        .hideAfter(Duration.seconds(0.5))
                        .showError();
                break;
            }
            case STARTING_GAME: {
                Notifications.create()
                        .text("Початок гри...").position(Pos.BOTTOM_LEFT)
                        .hideAfter(Duration.seconds(2))
                        .showInformation();
                break;
            }
            case CHOOSE_ENEMY: {
                Notifications.create()
                        .text("Оберіть ворога!").position(Pos.BOTTOM_LEFT)
                        .hideAfter(Duration.seconds(1))
                        .showError();
                break;
            }
            case GAME_EARLY_FINISHED: {
                Notifications.create()
                        .text("Дострокове завершення гри").position(Pos.BOTTOM_LEFT)
                        .hideAfter(Duration.seconds(1))
                        .showInformation();
                break;
            }
        }
    }

}
