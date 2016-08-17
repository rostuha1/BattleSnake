package user_interface.account.content.intelligence.menu.menu_items.items;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import user_interface.account.content.intelligence.menu.menu_items.Settings;

import java.util.List;

abstract class Item extends HBox {

    {
        setStyle(Settings.defaultStyle);
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
