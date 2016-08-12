package user_interface.account.content.intelligence.menu;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import user_interface.account.content.intelligence.menu_items.AndItem;

import static user_interface.account.content.intelligence.menu_items.MenuItem.barrier;
import static user_interface.account.content.intelligence.menu_items.MenuItem.empty;
import static user_interface.account.content.intelligence.menu_items.MenuItem.enemy_body;
import static user_interface.account.content.intelligence.menu_items.MenuItem.enemy_head;
import static user_interface.account.content.intelligence.menu_items.MenuItem.enemy_tail;
import static user_interface.account.content.intelligence.menu_items.MenuItem.own_body;
import static user_interface.account.content.intelligence.menu_items.MenuItem.own_head;
import static user_interface.account.content.intelligence.menu_items.MenuItem.own_tail;

public class ElementsMenu extends VBox {

    {
        setAlignment(Pos.TOP_LEFT);
//        setStyle("-fx-background-color: #31af00");
        setSpacing(30);
        getChildren().add(own_head);
        getChildren().add(own_body);
        getChildren().add(own_tail);
        getChildren().add(enemy_head);
        getChildren().add(enemy_body);
        getChildren().add(enemy_tail);
        getChildren().add(barrier);
        getChildren().add(new AndItem());
        getChildren().add(empty);
    }

}
