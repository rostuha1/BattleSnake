package user_interface.account.content.fight.list;

import javafx.scene.image.Image;

import java.nio.file.Paths;

public class SnakePlayer {

    private Image avatar;
    private String name;
    private int rating;
    private String about;

    public SnakePlayer(String defaultImage) {
        this.avatar = new Image("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\" + defaultImage);
        this.name = "Гравця не вибрано";
    }

    public SnakePlayer(String avatarName, String name, int rating, String about) {
        this.avatar = new Image("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\" + avatarName);
        this.name = name;
        this.rating = rating;
        this.about = about;
    }

    public Image getAvatar() {
        return avatar;
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
