package user_interface.account.content.intelligence.menu;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import user_interface.account.content.intelligence.Settings;
import user_interface.account.content.intelligence.menu.menu_items.items.AndItem;
import user_interface.account.content.intelligence.menu.menu_items.items.ExceptItem;
import user_interface.account.content.intelligence.menu.menu_items.items.OrItem;

import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.barrier;
import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.empty;
import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.enemy_body;
import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.enemy_head;
import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.enemy_tail;
import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.own_body;
import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.own_head;
import static user_interface.account.content.intelligence.menu.menu_items.items.MenuItem.own_tail;

public class ElementsMenu extends VBox {

    {
        setAlignment(Pos.TOP_LEFT);
        setSpacing(Settings.menuSpacing);

        getChildren().add(own_head);
        getChildren().add(own_body);
        getChildren().add(own_tail);
        getChildren().add(enemy_head);
        getChildren().add(enemy_body);
        getChildren().add(enemy_tail);
        getChildren().add(barrier);
        getChildren().add(AndItem.instance);
        getChildren().add(OrItem.instance);
        getChildren().add(ExceptItem.instance);
        getChildren().add(empty);
    }

}
