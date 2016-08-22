package user_interface.menus;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import user_interface.ComponentBuilder;

public class SubMenu extends VBox {
    private static final int SPACING = 15;
    public double subMenuHeight;

    public SubMenu(Region... items) {
        subMenuHeight = items.length * ComponentBuilder.ITEM_HEIGHT + (items.length - 1) * SPACING;

        setFillWidth(false);
        setAlignment(Pos.CENTER);
        setSpacing(SPACING);
        getChildren().addAll(items);
    }

    public double getMenuWidth() {
        return ComponentBuilder.ITEM_WIDTH;
    }

    public double getMenuHeight() {
        return subMenuHeight;
    }

    public void centering(Pane centeringPane) {
        setTranslateX((centeringPane.getWidth() - ComponentBuilder.ITEM_WIDTH) / 2);
        setTranslateY((centeringPane.getHeight() - subMenuHeight) / 2);
    }

}