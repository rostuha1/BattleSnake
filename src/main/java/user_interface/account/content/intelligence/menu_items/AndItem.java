package user_interface.account.content.intelligence.menu_items;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import static user_interface.account.content.intelligence.Role.*;

public class AndItem extends HBox {

    private static final ImageView orange = new ImageView(getElementImage(A_O_EMPTY));
    private static final ImageView pink = new ImageView(getElementImage(A_P_EMPTY));
    private static final ItemText itemText = new ItemText("AND");

    private static ImageView selectedItem = null;

    public static final AndItem instance = new AndItem();

    {
        HBox.setMargin(itemText, Settings.hInsets);
        HBox.setMargin(orange, Settings.hInsets);
        HBox.setMargin(pink, Settings.hInsets);

        setStyle(Settings.defaultStyle);

        orange.setOnMouseClicked(event -> click(orange));
        pink.setOnMouseClicked(event -> click(pink));

        getChildren().add(orange);
        getChildren().add(pink);
        getChildren().add(itemText);
    }

    private AndItem() {}

    private void click(ImageView view) {
        if (selectedItem == view) {
            switchOff();
            releaseEvent();
            return;
        }

        switchOn(view);

        clickEvent();
    }

    private void releaseEvent() {
        MenuItem.setRoleIndex(0);
    }

    private void clickEvent() {
        OrItem.instance.switchOff();
        if (selectedItem == orange) MenuItem.setRoleIndex(1);
        if (selectedItem == pink) MenuItem.setRoleIndex(2);
    }

    public void switchOff() {
        if (selectedItem == null) return;

        selectedItem.setEffect(null);
        selectedItem = null;
    }

    private void switchOn(ImageView newImageView) {
        if (selectedItem != null) selectedItem.setEffect(null);
        selectedItem = newImageView;
        newImageView.setEffect(Settings.itemEffect);
    }

}
