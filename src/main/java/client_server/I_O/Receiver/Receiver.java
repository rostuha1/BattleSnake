package client_server.I_O.Receiver;

import client_server.I_O.SnakePlayer;
import client_server.I_O.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import user_interface.account.battlefield.snake.Direction;
import user_interface.account.battlefield.snake.Position;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.intelligence.Role;
import user_interface.account.content.intelligence.card_elements.Card;

public class Receiver implements SnakeListReceiver, CardsReceiver, UserReceiver {

    public static final Receiver instance = new Receiver();

//    ObservableList<SnakePlayer> list = receiveSnakeList();
//    Card[][] cards = receiveCards();
//    User user = receiveUser();

    private Receiver() {}

    @Override
    public ObservableList<SnakePlayer> receiveSnakeList() {

        //ToDo. Must be downloaded from server

        Snake enemySnake1 = new Snake(new Position[]{
                new Position(1, 3),
                new Position(2, 3),
                new Position(3, 3),
                new Position(4, 3),
                new Position(5, 3),
                new Position(6, 3)
        }, Color.AQUA, Direction.DOWN);

        Snake enemySnake2 = new Snake(new Position[]{
                new Position(1, 5),
                new Position(2, 5),
                new Position(3, 5),
                new Position(4, 5),
                new Position(5, 5),
                new Position(6, 5)
        }, Color.LIGHTGREEN, Direction.DOWN);

        Snake enemySnake3 = new Snake(new Position[]{
                new Position(1, 7),
                new Position(2, 7),
                new Position(3, 7),
                new Position(4, 7),
                new Position(5, 7),
                new Position(6, 7)
        }, Color.CORAL, Direction.DOWN);

        ObservableList<SnakePlayer> list = FXCollections.observableArrayList();
        list.addAll(
                new SnakePlayer("snake2.png", "mike", 1500, "111", enemySnake1),
                new SnakePlayer("snake3.png", "john", 1000, "I am a super snake :)", enemySnake2),
                new SnakePlayer("snake4.png", "jack", 1010, "Let's fight with me!", enemySnake3)
        );

        return list;

    }

    @Override
    public Card[][] receiveCards() {

        // ToDo. Must be downloaded from server

        Card[][] cards = new Card[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cards[i][j] = new Card();
            }
        }

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


        return cards;
    }

    @Override
    public User receiveUser() {

        User user = new User();

        Snake snake = new Snake(Color.WHEAT, Direction.RIGHT);
        SnakePlayer snakePlayer = new SnakePlayer("snake1.png", "Ann", 1200, "Let's play!", snake);

        user.setSnakePlayer(snakePlayer);

        user.setId(1);
        user.setLogin("rostuha1");
        user.setPassword("12345");
        user.setCards(receiveCards());

        return user;
    }
}
