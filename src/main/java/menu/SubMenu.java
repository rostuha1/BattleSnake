package menu;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class SubMenu extends VBox {
    private static final int SPACING = 15;
    public int subMenuHeight;

    public SubMenu(Region... items) {
        subMenuHeight = items.length * ComponentBuilder.ITEM_HEIGHT + (items.length + 1) * SPACING;

        setSpacing(SPACING);
        getChildren().addAll(items);
    }

    public void centering(Pane centeringPane) {
        setTranslateX((centeringPane.getWidth() - ComponentBuilder.ITEM_WIDTH) / 2);
        setTranslateY((centeringPane.getHeight() - subMenuHeight) / 2);
    }

}