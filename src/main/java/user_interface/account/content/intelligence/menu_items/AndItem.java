package user_interface.account.content.intelligence.menu_items;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import user_interface.account.content.intelligence.Role;

import static user_interface.account.content.intelligence.Role.*;

public class AndItem extends HBox {

    private static final ImageView orange = new ImageView(getElementImage(A_O_EMPTY));
    private static final ImageView pink = new ImageView(getElementImage(A_P_EMPTY));

    private static final ItemText itemText = new ItemText("AND");

    private static Role selectedState = null;

    {
        HBox.setMargin(itemText, Settings.hInsets);
        HBox.setMargin(orange, Settings.hInsets);
        HBox.setMargin(pink, Settings.hInsets);

        setStyle(Settings.defaultStyle);

        getChildren().add(pink);
        getChildren().add(itemText);
    }

}
