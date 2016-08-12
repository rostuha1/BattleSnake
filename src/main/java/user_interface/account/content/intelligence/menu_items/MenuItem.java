package user_interface.account.content.intelligence.menu_items;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import user_interface.account.content.intelligence.IntelligenceContent;
import user_interface.account.content.intelligence.Role;
import user_interface.account.content.intelligence.card_elements.CardElement;

public class MenuItem extends HBox {

    public static final MenuItem own_head = new MenuItem("Своя голова", Role.OWN_HEAD);
    public static final MenuItem own_body = new MenuItem("Своє тіло", Role.OWN_BODY);
    public static final MenuItem own_tail = new MenuItem("Свій хвіст", Role.OWN_TAIL);
    public static final MenuItem enemy_head = new MenuItem("Голова ворога", Role.ENEMY_HEAD);
    public static final MenuItem enemy_body = new MenuItem("Тіло ворога", Role.ENEMY_BODY);
    public static final MenuItem enemy_tail = new MenuItem("Хвіст ворога", Role.ENEMY_TAIL);
    public static final MenuItem barrier = new MenuItem("Бар'єр", Role.BARRIER);
    public static final MenuItem empty = new MenuItem("Порожнє місце", Role.EMPTY);

    private static MenuItem selectedItem = null;

    private static Image defImage;
    private static Image aoImage;
    private static Image apImage;
    private static Image orImage;

    private final ImageView imageView = new ImageView();
    private Role role;

    void defaultStyle(StyleType type) {
        switch (type) {
            case DEFAULT: setStyle(Settings.defaultStyle); break;
            case PRESSED: setStyle(Settings.pressedStyle); break;
        }
    }

    public MenuItem(String itemName, Role role) {
        defaultStyle(StyleType.DEFAULT);
        this.role = role;

//        setMaxSize(0, 0);
        setAlignment(Pos.CENTER_LEFT);

        imageView.setImage(Role.getElementImage(role));
        ItemText itemText = new ItemText(itemName);

        HBox.setMargin(itemText, Settings.hInsets);
        HBox.setMargin(imageView, Settings.hInsets);

        getChildren().addAll(imageView, itemText);

        setOnMouseClicked(event -> {
            if (CardElement.getSelectedElement() == null) return;
            if (selectedItem == this) {
                selectedItem = null;
                defaultStyle(StyleType.DEFAULT);
                CardElement.getSelectedElement().setEffect(null);
                CardElement.setSelectedElement(null);
                return;
            }
            if (selectedItem != null) selectedItem.setStyle(Settings.defaultStyle);
            selectedItem = this;
            changeSelectedCardElement();
            defaultStyle(StyleType.PRESSED);
        });

    }

    private void changeSelectedCardElement() {
        CardElement element = CardElement.getSelectedElement();
        if (element == null) return;
        element.setRole(role);
        element.setImage(Role.getElementImage(role));
    }

    public static void selectItem(Role role, StyleType type) {
        if (selectedItem != null) selectedItem.defaultStyle(StyleType.DEFAULT);
        MenuItem item = null;
        switch (role) {
            case OWN_HEAD: item = own_head;
                break;
            case OWN_BODY: item = own_body;
                break;
            case OWN_TAIL: item = own_tail;
                break;
            case ENEMY_HEAD: item = enemy_head;
                break;
            case ENEMY_BODY: item = enemy_body;
                break;
            case ENEMY_TAIL: item = enemy_tail;
                break;
            case BARRIER: item = barrier;
                break;
            case EMPTY: item = empty;
                break;
        }

        if (item != null) {
            item.defaultStyle(type);
            selectedItem = item;
        }

    }

}
