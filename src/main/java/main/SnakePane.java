package main;

import javafx.scene.layout.Pane;
import user_interface.account.battlefield.Grid;
import user_interface.account.battlefield.menu.ControlMenu;

public class SnakePane extends Pane {

    public static SnakePane instance = new SnakePane();

    private SnakePane() {
        setOpacity(0);
        getChildren().addAll(Grid.instance.getNodes());
        getChildren().add(ControlMenu.instance);
    }

}
