package client_server;

import user_interface.account.content.intelligence.card_elements.Card;

public class User {

    private int id;
    private String login;
    private String password;
    private SnakePlayer snake;
    private Card[] cards;

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, SnakePlayer snake, Card[] cards) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.snake = snake;
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

    public SnakePlayer getSnake() {
        return snake;
    }

    public void setSnake(SnakePlayer snake) {
        this.snake = snake;
    }

    public Card[] getCards()
    {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
