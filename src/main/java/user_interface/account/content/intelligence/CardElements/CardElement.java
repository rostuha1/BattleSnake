package user_interface.account.content.intelligence.CardElements;

import javafx.geometry.Insets;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.nio.file.Paths;

public class CardElement extends ImageView {

    private static Insets insets = new Insets(2);
    private static CardElement selectedElement = null;

    private CardElementType cardElementType;

    {
        GridPane.setMargin(this, insets);
        setOnMouseClicked(event -> {
            if (selectedElement == this) {
                selectedElement = null;
                setEffect(null);
                return;
            }
            if (selectedElement != null) selectedElement.setEffect(null);
            selectedElement = this;
            setEffect(new ColorAdjust(0, 0, -0.4, 0));
        });
    }

    public CardElement() {
        setCardElementType(CardElementType.EMPTY);
    }

    public CardElement(CardElementType cardElementType) {
        setCardElementType(cardElementType);
    }

    public CardElementType getCardElementType() {
        return cardElementType;
    }

    public void setCardElementType(CardElementType cardElementType) {
        setImage(getElementImage(this.cardElementType = cardElementType));
    }

    private Image getElementImage(CardElementType cardElementType) {
        String imagePath = Paths.get("").toAbsolutePath().toUri().normalize().toString() + "src/main/java/user_interface/account/content/intelligence/CardElements/images/";
        switch (cardElementType) {
            case EMPTY:
                return new Image(imagePath + "empty.png");
            case OWN_HEAD:
                return new Image(imagePath + "own_head.png");
            case ENEMY_HEAD:
                return new Image(imagePath + "enemy_head.png");
            default:
                return null;
        }
    }

}
