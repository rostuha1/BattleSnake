package client_server;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.nio.file.Paths;

public class SnakePlayer {

    private Image avatar;
    private String name;
    private int rating;
    private Color color;
    private String about;

    public SnakePlayer(String defaultImage) {
        this.avatar = new Image("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\" + defaultImage);
        this.name = "Гравця не вибрано";
        this.color = Color.rgb(140, 145, 95);
    }

    public SnakePlayer(Image avatar, String name, int rating, Color color, String about) {
        this.avatar = avatar;
        this.name = name;
        this.rating = rating;
        this.color = color;
        this.about = about;
    }

    public SnakePlayer(String avatarName, String name, int rating, Color color, String about) {
        this.avatar = new Image("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\" + avatarName);
        this.name = name;
        this.rating = rating;
        this.color = color;
        this.about = about;
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

    @Override
    public String toString() {
        return "Name: " + getName() + "\nRating: " + getRating() + "\nAbout: " + getAbout();
    }
}
