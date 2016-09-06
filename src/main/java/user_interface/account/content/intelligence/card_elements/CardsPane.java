package user_interface.account.content.intelligence.card_elements;

import javafx.scene.layout.GridPane;
import main.Receiver;
import user_interface.account.User;

public class CardsPane extends GridPane {

    private Card[][] cards = User.getInstance().getCards();

    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(cards[i][j], i, j);
            }
        }
    }

}
