package menu;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.Main;

public class SubMenu extends VBox {
    private static final int SPACING = 15;

    public SubMenu(Region... items) {
        int subMenuHeight = items.length * ComponentBuilder.ITEM_HEIGHT + (items.length + 1) * SPACING;

        setSpacing(SPACING);
        setTranslateX((Main.getRoot().getWidth() - ComponentBuilder.ITEM_WIDTH)/2);
        setTranslateY((Main.getRoot().getHeight() - subMenuHeight)/2);
        getChildren().addAll(items);
    }

}