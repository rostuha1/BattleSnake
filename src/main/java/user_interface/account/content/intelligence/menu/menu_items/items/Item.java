package user_interface.account.content.intelligence.menu.menu_items.items;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import user_interface.account.content.intelligence.Settings;

import java.util.List;

abstract class Item extends HBox {

    {
//        setStyle(Settings.defaultStyle);

        setBackground(Settings.defaultMenuItemBackground);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.LIGHTSEAGREEN);
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setRadius(5);

//        setEffect(dropShadow);
    }

    public Item(List<Node> nodes) {
        init(nodes);
    }
    public Item(Node... nodes) {
        init(nodes);
    }

    protected void init(List<Node> nodes) {
        nodes.forEach(node -> HBox.setMargin(node, Settings.hInsets));
        getChildren().addAll(nodes);
    }
    protected void init(Node... nodes) {
        for(Node node: nodes) HBox.setMargin(node, Settings.hInsets);
        getChildren().addAll(nodes);
    }

}
