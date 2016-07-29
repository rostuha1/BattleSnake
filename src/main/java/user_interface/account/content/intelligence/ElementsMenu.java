package user_interface.account.content.intelligence;

import javafx.geometry.Orientation;
import javafx.scene.control.ToolBar;
import jfxtras.labs.util.event.MouseControlUtil;

public class ElementsMenu extends ToolBar {

    {
        setOrientation(Orientation.VERTICAL);
        setMinWidth(200);
        setStyle("-fx-background-color: #31af00");
        MouseControlUtil.makeDraggable(this);

    }

}
