package user_interface.account.content.intelligence.cardElements;

import javafx.scene.layout.GridPane;

public class CardsPane extends GridPane{

    private Card[][] cards = new Card[3][3];

    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(cards[i][j] = new Card(), i, j);
            }
        }
    }

}
