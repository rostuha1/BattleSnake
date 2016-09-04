package user_interface.account;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.intelligence.Settings;

public class SnakePlayer {

    private Image avatar;
    private String name;
    private int rating;
    private Color color;
    private String about;
    private Snake snake;

    private static final String imagesPath = Settings.projectPath + "/src/main/resources/";
    public static final Image DEFAULT_AVATAR = new Image(imagesPath + "default-snake.png");

    public static final SnakePlayer DEFAULT_SNAKE_PLAYER = new SnakePlayer(true);

    public SnakePlayer(boolean initByDefault) {
        if (initByDefault) {
            this.avatar = DEFAULT_AVATAR;
            this.name = "Гравця не вибрано";
            this.color = Color.rgb(140, 145, 95);
        }
    }

    public SnakePlayer(Image avatar, String name, int rating, Color color, String about) {
        this.avatar = avatar;
        this.name = name;
        this.rating = rating;
        this.color = color;
        this.about = about;
    }

    public SnakePlayer(String avatarName, String name, int rating, String about, Snake snake, Color color) {
        this.avatar = new Image(imagesPath + avatarName);
        this.name = name;
        this.rating = rating;
        this.about = about;
        this.color = color;
        this.snake = snake;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public void setAvatar(String avatarName) {
        this.avatar = new Image(getClass().getResource(avatarName).toExternalForm());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\nRating: " + getRating() + "\nAbout: " + getAbout();
    }
}
