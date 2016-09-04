package user_interface.account.content.intelligence.card_elements;

import javafx.scene.layout.GridPane;
import user_interface.account.content.intelligence.Settings;

public class Card extends GridPane {

    private CardElement[][] elements = new CardElement[7][7];

    public Card(CardElement[][] elements) {
        this.elements = elements;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                add(elements[i][j], i , j);
            }
        }

        GridPane.setMargin(this, Settings.gridInsets);
        setBackground(Settings.cardPaneBackground);
    }

    public CardElement[][] getElements() {
        return elements;
    }

}
