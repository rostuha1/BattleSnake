package user_interface.account.content.developers;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import main.WindowSettings;

import java.nio.file.Paths;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class DevelopersContent extends HBox {

    private final double HEIGHT = WindowSettings.height / 3;
    private final double WIDTH = CONTENT_WIDTH / 2;
    private ImageView logo = new ImageView("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\logo.png");
    private Label about = new Label("Snake Battle. Version 1.0\n\nCreated by:\nРостислав Балдовський\nДенис Куц\nАнна Чернівчан\n\n2016 © All rights reserved\n");

    {
        logo.setFitHeight(160);
        logo.setFitWidth(160);
        about.setStyle("-fx-text-fill: rgb(159, 188, 94); -fx-font-size: 18; -fx-font-weight: bold");
        setAlignment(Pos.CENTER);
        setSpacing(20);
        setMaxSize(WIDTH, HEIGHT);
        setStyle("-fx-border-color: rgb(62, 82, 37); -fx-border-width: 5px");
        getChildren().addAll(logo, about);
    }

    public DevelopersContent() {
    }

}
