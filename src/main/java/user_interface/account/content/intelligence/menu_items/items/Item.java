package user_interface.account.content.intelligence.menu_items.items;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import user_interface.account.content.intelligence.menu_items.ItemText;
import user_interface.account.content.intelligence.menu_items.Settings;

import java.util.Arrays;
import java.util.List;

abstract class Item extends HBox {

    {
        setStyle(Settings.defaultStyle);
    }

    public Item(List<Node> nodes) {
        init(nodes);
    }

    public Item(Node... nodes) {
        init(Arrays.asList(nodes));
    }

    private void init(List<Node> nodes) {
        nodes.forEach(node -> HBox.setMargin(node, Settings.hInsets));
        getChildren().addAll(nodes);
    }

}
