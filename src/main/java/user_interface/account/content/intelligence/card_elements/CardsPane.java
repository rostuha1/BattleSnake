package user_interface.account.content.intelligence.card_elements;

import javafx.scene.layout.GridPane;
import user_interface.account.content.intelligence.Role;

public class CardsPane extends GridPane{

    private Card[][] cards = new Card[3][3];

    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(cards[i][j] = new Card(), i, j);
            }
        }
        example();
    }

    private void example() { //ToDo -> to delete
        Card card = cards[1][1];

        card.getElements()[0][0].setRole(Role.OWN_HEAD);
        card.getElements()[1][0].setRole(Role.A_O_OWN_HEAD);
        card.getElements()[2][0].setRole(Role.A_P_OWN_HEAD);
        card.getElements()[3][0].setRole(Role.OR_OWN_HEAD);
        card.getElements()[4][0].setRole(Role.EXCEPT_OWN_HEAD);

        card.getElements()[0][1].setRole(Role.OWN_BODY);
        card.getElements()[1][1].setRole(Role.A_O_OWN_BODY);
        card.getElements()[2][1].setRole(Role.A_P_OWN_BODY);
        card.getElements()[3][1].setRole(Role.OR_OWN_BODY);
        card.getElements()[4][1].setRole(Role.EXCEPT_OWN_BODY);

        card.getElements()[0][2].setRole(Role.OWN_TAIL);
        card.getElements()[1][2].setRole(Role.A_O_OWN_TAIL);
        card.getElements()[2][2].setRole(Role.A_P_OWN_TAIL);
        card.getElements()[3][2].setRole(Role.OR_OWN_TAIL);
        card.getElements()[4][2].setRole(Role.EXCEPT_OWN_TAIL);

        card.getElements()[0][4].setRole(Role.ENEMY_HEAD);
        card.getElements()[1][4].setRole(Role.A_O_ENEMY_HEAD);
        card.getElements()[2][4].setRole(Role.A_P_ENEMY_HEAD);
        card.getElements()[3][4].setRole(Role.OR_ENEMY_HEAD);
        card.getElements()[4][4].setRole(Role.EXCEPT_ENEMY_HEAD);

        card.getElements()[0][5].setRole(Role.ENEMY_BODY);
        card.getElements()[1][5].setRole(Role.A_O_ENEMY_BODY);
        card.getElements()[2][5].setRole(Role.A_P_ENEMY_BODY);
        card.getElements()[3][5].setRole(Role.OR_ENEMY_BODY);
        card.getElements()[4][5].setRole(Role.EXCEPT_ENEMY_BODY);

        card.getElements()[0][6].setRole(Role.ENEMY_TAIL);
        card.getElements()[1][6].setRole(Role.A_O_ENEMY_TAIL);
        card.getElements()[2][6].setRole(Role.A_P_ENEMY_TAIL);
        card.getElements()[3][6].setRole(Role.OR_ENEMY_TAIL);
        card.getElements()[4][6].setRole(Role.EXCEPT_ENEMY_TAIL);

        card.getElements()[6][1].setRole(Role.BARRIER);
        card.getElements()[6][2].setRole(Role.A_O_BARRIER);
        card.getElements()[6][3].setRole(Role.A_P_BARRIER);
        card.getElements()[6][4].setRole(Role.OR_BARRIER);
        card.getElements()[6][5].setRole(Role.EXCEPT_BARRIER);
    }

}
