package client_server_I_O.classes;

import java.io.Serializable;

public class User implements Serializable{

    private long id;
    private String login;
    private String password;
    private SnakePlayer snakePlayer;
    private Card[][] cards; // 3 * 3

    public User() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
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

    public Card[][] getCards() {
        return cards;
    }
    public void setCards(Card[][] cards) {
        this.cards = cards;
    }

}
