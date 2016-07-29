package user_interface.account.content.intelligence;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.WindowSettings;
import user_interface.account.MainMenu;
import user_interface.account.content.intelligence.CardElements.CardsPane;
import user_interface.account.content.intelligence.Menu.ElementsMenu;

import java.nio.file.Paths;

public class IntelligenceContent extends BorderPane {

    public static final String cardElementImagesPath = Paths.get("").toAbsolutePath().toUri().normalize().toString() +
            "src/main/resources/card_elements/";

    {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        Content content = new Content();
        setCenter(content);
    }

    private class Content extends HBox {
        {
//            setStyle("-fx-background-color: white");
            setFillHeight(false);
            setMaxSize(0, 0);
            setAlignment(Pos.CENTER);
            getChildren().addAll(new CardsPane(), new ElementsMenu());
            setScaleX(1.2);
            setScaleY(1.2);
        }
    }

}