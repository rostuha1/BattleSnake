package client_server_I_O.classes;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class SnakePlayer implements Serializable{

    private Image avatar;
    private String name;
    private int rating;
    private Color color;
    private String about;
    private Snake snake;

    public SnakePlayer() {}

    public Image getAvatar() {
        return avatar;
    }
    public void setAvatar(Image avatar) {
        this.avatar = avatar;
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
}
