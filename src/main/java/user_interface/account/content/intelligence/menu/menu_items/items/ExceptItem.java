package user_interface.account.content.intelligence.menu.menu_items.items;

import javafx.scene.image.ImageView;
import user_interface.account.content.intelligence.menu.menu_items.ItemText;
import user_interface.account.content.intelligence.Settings;

import static user_interface.account.content.intelligence.Role.EXCEPT;
import static user_interface.account.content.intelligence.Role.getElementImage;

public class ExceptItem extends Item {

    private static ImageView imageView = new ImageView(getElementImage(EXCEPT));
    private static ItemText itemText = new ItemText("EXCEPT");
    boolean isPressed;

    public static final ExceptItem instance = new ExceptItem();

    private ExceptItem() {
        super(imageView, itemText);
        imageView.setStyle("-fx-background-color: aqua");
        imageView.setPickOnBounds(true);
        imageView.setOnMouseClicked(event -> click());
    }


    public void click() {
        if (isPressed) {
            switchOff();
            releaseEvent();
            return;
        }

        switchOn();
        clickEvent();
    }

    private void releaseEvent() {
        MenuItem.setRoleIndex(0);
    }
    private void clickEvent() {
        OrItem.instance.switchOff();
        AndItem.instance.switchOff();
        MenuItem.setRoleIndex(4);
    }

    public void switchOff() {
        isPressed = false;
        imageView.setEffect(null);
    }
    public void switchOn() {
        isPressed = true;
        imageView.setEffect(Settings.itemEffect);
    }

}
