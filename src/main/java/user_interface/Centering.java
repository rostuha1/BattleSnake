package user_interface;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import user_interface.menus.SubMenu;

public class Centering {

    public static SubMenu centeringAndGet(SubMenu entity, Region centeringPane) {
        centering(entity, centeringPane);
        return entity;
    }
    public static void centering(SubMenu entity, Region centeringPane) {
        entity.setTranslateX((centeringPane.getPrefWidth() - entity.getMenuWidth()) / 2);
        entity.setTranslateY((centeringPane.getPrefHeight() - entity.getMenuHeight()) / 2);
    }
    public static void centering(Pane entity, Region centeringPane) {
        entity.setTranslateX((centeringPane.getPrefWidth() - entity.getPrefWidth()) / 2);
        entity.setTranslateY((centeringPane.getPrefHeight() - entity.getPrefHeight()) / 2);
    }

}
