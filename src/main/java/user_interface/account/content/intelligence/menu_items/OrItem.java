package user_interface.account.content.intelligence.menu_items;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import static user_interface.account.content.intelligence.Role.OR_OWN_BODY;
import static user_interface.account.content.intelligence.Role.getElementImage;

public class OrItem extends HBox {

    private static final ImageView imageView = new ImageView(getElementImage(OR_OWN_BODY));
    private static final ItemText itemText = new ItemText("OR");

    private static boolean isPressed;

    public static final OrItem instance = new OrItem();

    {
        setStyle(Settings.defaultStyle);

        HBox.setMargin(imageView, Settings.hInsets);
        HBox.setMargin(itemText, Settings.hInsets);

        imageView.setOnMouseClicked(event -> click());

        getChildren().add(imageView);
        getChildren().add(itemText);
    }

    private OrItem() {}

    private void click() {
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
        MenuItem.setRoleIndex(3);
    }

    public void switchOff() {
        isPressed = false;
        imageView.setEffect(null);
    }

    private void switchOn() {
        isPressed = true;
        imageView.setEffect(Settings.itemEffect);
    }

}
