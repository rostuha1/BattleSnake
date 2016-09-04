package messages;

import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

public class Messenger {

    public static void showMessage(MessageType messageType) {
        switch (messageType) {
            case SUCCESSFUL_AUTHORIZATION: {
                Notifications.create().text("Успішно авторизувалися")
                        .showInformation();
                break;
            }
            case SUCCESSFUL_REGISTRATION: {
                Notifications.create().text("Успішна реєстрація")
                        .showInformation();
                break;
            }
            case UNSUCCESSFUL_AUTHORIZATION: {
                Notifications.create()
                        .title("Помилка авторизації")
                        .text("Перевірте правильність введених даних!")
                        .showError();
                break;
            }
            case UNSUCCESSFUL_REGISTRATION: {
                Notifications.create()
                        .title("Невдала реєстрація")
                        .text("Перевірте правильність введених даних!")
                        .showError();
                break;
            }
            case UNAVAILABLE_SERVER: {
                Notifications.create()
                        .text("Сервер недоступний :(").position(Pos.BOTTOM_LEFT)
                        .showError();
                break;
            }
        }
    }

}
