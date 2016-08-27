package client_server.I_O;

import client_server.I_O.Receiver.Receiver;
import user_interface.account.content.intelligence.card_elements.Card;

public class User {

    private int id;
    private String login;
    private String password;
    private SnakePlayer snakePlayer;
    private Card[][] cards; // 3 * 3

    private static User instance = Receiver.instance.receiveUser(); // ToDo. Must be downloaded from server

    public User() {}

    public User(String login, String password) {
        // ToDo. To remove

        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, SnakePlayer snakePlayer, Card[][] cards) {

        // ToDo. To remove

        this.id = id;
        this.login = login;
        this.password = password;
        this.snakePlayer = snakePlayer;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SnakePlayer getSnakePlayer() {
        return snakePlayer;
    }

    public void setSnakePlayer(SnakePlayer snakePlayer) {
        this.snakePlayer = snakePlayer;
    }

    public Card[][] getCards()
    {
        return cards;
    }

    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

    public static User getInstance() {
        return instance;
    }
}
