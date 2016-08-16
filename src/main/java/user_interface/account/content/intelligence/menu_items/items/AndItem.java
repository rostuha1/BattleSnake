package user_interface.account.content.intelligence.menu_items.items;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import user_interface.account.content.intelligence.menu_items.ItemText;
import user_interface.account.content.intelligence.menu_items.Settings;

import static user_interface.account.content.intelligence.Role.*;

public class AndItem extends Item {

    private static final ImageView orange = new ImageView(getElementImage(A_O_EMPTY));
    private static final ImageView pink = new ImageView(getElementImage(A_P_EMPTY));
    private static final ItemText itemText = new ItemText("AND");

    private static ImageView selectedItem = null;

    public static final AndItem instance = new AndItem();

    private AndItem() {
        super(orange, pink, itemText);
        orange.setOnMouseClicked(event -> click(orange));
        pink.setOnMouseClicked(event -> click(pink));
    }

    public void click(ImageView newImageView) {
        if (selectedItem == newImageView) {
            switchOff();
            releaseEvent();
            return;
        }

        switchOn(newImageView);

        clickEvent();
    }

    private void releaseEvent() {
        MenuItem.setRoleIndex(0);
    }
    private void clickEvent() {
        OrItem.instance.switchOff();
        ExceptItem.instance.switchOff();
        if (selectedItem == orange) MenuItem.setRoleIndex(1);
        if (selectedItem == pink) MenuItem.setRoleIndex(2);
    }

    public void switchOff() {
        if (selectedItem == null) return;

        selectedItem.setEffect(null);
        selectedItem = null;
    }
    public void switchOn(ImageView newImageView) {
        if (selectedItem != null) selectedItem.setEffect(null);
        selectedItem = newImageView;
        newImageView.setEffect(Settings.itemEffect);
    }

}
