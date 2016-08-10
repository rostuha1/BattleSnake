package client_server;

import user_interface.account.content.intelligence.CardElements.Card;

public class User {

    private int id;
    private String login;
    private String password;
    private Card[] cards;

    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password, Card[] cards) {
        this.id = id;
        this.login = login;
        this.password = password;
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

    public Card[] getCards()
    {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
