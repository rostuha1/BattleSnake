package user_interface.account.content.intelligence.card_elements;

import javafx.scene.layout.GridPane;
import main.Receiver;

public class CardsPane extends GridPane {

    private Card[][] cards = Receiver.receiveUser().getCards();

    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(cards[i][j], i, j);
            }
        }
    }

}
