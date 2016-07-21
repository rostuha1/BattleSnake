package menu;

import javafx.scene.layout.Pane;

public class Centering {

    public static SubMenu centeringAndGet(SubMenu entity, Pane centeringPane) {
        centering(entity, centeringPane);
        return entity;
    }

    public static void centering(SubMenu entity, Pane centeringPane) {
        entity.setTranslateX((centeringPane.getWidth() - ComponentBuilder.ITEM_WIDTH) / 2);
        entity.setTranslateY((centeringPane.getHeight() - entity.subMenuHeight) / 2);
    }

    public static void centering(Pane entity, Pane centeringPane) {
        entity.setTranslateX((centeringPane.getWidth() - entity.getBoundsInLocal().getWidth()) / 2);
        entity.setTranslateY((centeringPane.getHeight() - entity.getBoundsInLocal().getHeight()) / 2);
    }

}
