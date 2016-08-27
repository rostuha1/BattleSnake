package user_interface.account.content.intelligence.card_elements;

import client_server.I_O.Receiver.Receiver;
import javafx.scene.layout.GridPane;
import user_interface.account.content.intelligence.Role;

public class CardsPane extends GridPane {

    private Card[][] cards = Receiver.instance.receiveUser().getCards();

    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(cards[i][j], i, j);
            }
        }
    }

}
