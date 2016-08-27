package user_interface.account.content.intelligence.card_elements;

import javafx.scene.layout.GridPane;
import user_interface.account.content.intelligence.Settings;

public class Card extends GridPane {

    private CardElement[][] elements = new CardElement[7][7];

    private CardDirection direction = CardDirection.FORWARD;

    {

        //ToDo. Must be removed. And must be initialized by using method "setElements"

        elements[0][0] = new CardElement();
        elements[0][1] = new CardElement();
        elements[0][2] = new CardElement();
        elements[0][3] = new CardElement();
        elements[0][4] = new CardElement();
        elements[0][5] = new CardElement();
        elements[0][6] = new CardElement();
        elements[1][0] = new CardElement();
        elements[1][1] = new CardElement();
        elements[1][2] = new CardElement();
        elements[1][3] = new CardElement();
        elements[1][4] = new CardElement();
        elements[1][5] = new CardElement();
        elements[1][6] = new CardElement();
        elements[2][0] = new CardElement();
        elements[2][1] = new CardElement();
        elements[2][2] = new CardElement();
        elements[2][3] = new CardElement();
        elements[2][4] = new CardElement();
        elements[2][5] = new CardElement();
        elements[2][6] = new CardElement();
        elements[3][0] = new CardElement();
        elements[3][1] = new CardElement();
        elements[3][2] = new CardElement();
        elements[3][3] = new CardElement();
        elements[3][4] = new CardElement();
        elements[3][5] = new CardElement();
        elements[3][6] = new CardElement();
        elements[4][0] = new CardElement();
        elements[4][1] = new CardElement();
        elements[4][2] = new CardElement();
        elements[4][3] = new CardElement();
        elements[4][4] = new CardElement();
        elements[4][5] = new CardElement();
        elements[4][6] = new CardElement();
        elements[5][0] = new CardElement();
        elements[5][1] = new CardElement();
        elements[5][2] = new CardElement();
        elements[5][3] = new CardElement();
        elements[5][4] = new CardElement();
        elements[5][5] = new CardElement();
        elements[5][6] = new CardElement();
        elements[6][0] = new CardElement();
        elements[6][1] = new CardElement();
        elements[6][2] = new CardElement();
        elements[6][3] = new CardElement();
        elements[6][4] = new CardElement();
        elements[6][5] = new CardElement();
        elements[6][6] = new CardElement();

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

    public void setElements(CardElement[][] elements) {
        this.elements = elements;
    }

    public CardDirection getDirection() {
        return direction;
    }

    public void setDirection(CardDirection direction) {
        this.direction = direction;
    }
}
