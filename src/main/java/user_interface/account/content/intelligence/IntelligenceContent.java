package user_interface.account.content.intelligence;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import main.WindowSettings;
import user_interface.account.MainMenu;

public class IntelligenceContent extends BorderPane {

    {
        setPrefSize(MainMenu.CONTENT_WIDTH, WindowSettings.height);
        Content content = new Content();
        setCenter(content);

    }

    private class Content extends HBox {
        {
//            setStyle("-fx-background-color: white");
            setMaxSize(0, 0);
            setAlignment(Pos.CENTER);
            getChildren().addAll(new CardsPane(), new ElementsMenu());
            setScaleX(1.2);
            setScaleY(1.2);
        }
    }

}