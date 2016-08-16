package user_interface.account.content.intelligence.menu_items.items;

import javafx.scene.image.ImageView;
import user_interface.account.content.intelligence.menu_items.ItemText;
import user_interface.account.content.intelligence.menu_items.Settings;

import static user_interface.account.content.intelligence.Role.OR_OWN_BODY;
import static user_interface.account.content.intelligence.Role.getElementImage;

public class OrItem extends Item {

    private static ImageView imageView = new ImageView(getElementImage(OR_OWN_BODY));
    private static ItemText itemText = new ItemText("OR");
    boolean isPressed;

    public static final OrItem instance = new OrItem();

    private OrItem() {
        super(imageView, itemText);
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
        AndItem.instance.switchOff();
        ExceptItem.instance.switchOff();
        MenuItem.setRoleIndex(3);
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
