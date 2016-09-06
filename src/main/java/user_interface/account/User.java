package user_interface.account;

import user_interface.account.content.intelligence.card_elements.Card;

public class User {

    private String login;
    private String password;
    private SnakePlayer snakePlayer;
    private Card[][] cards; // 3 * 3

    private static User instance; // ToDo. Must be downloaded from server

    public static void setInstance(User instance) {
        User.instance = instance;
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
