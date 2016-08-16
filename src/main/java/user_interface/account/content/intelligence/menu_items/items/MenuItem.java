package user_interface.account.content.intelligence.menu_items.items;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import user_interface.account.content.intelligence.Role;
import user_interface.account.content.intelligence.card_elements.CardElement;
import user_interface.account.content.intelligence.menu_items.ItemText;
import user_interface.account.content.intelligence.menu_items.Settings;
import user_interface.account.content.intelligence.menu_items.StyleType;

public class MenuItem extends HBox {

    public static final MenuItem own_head = new MenuItem("Своя голова", Role.ownHeads);
    public static final MenuItem own_body = new MenuItem("Своє тіло", Role.ownBodies);
    public static final MenuItem own_tail = new MenuItem("Свій хвіст", Role.ownTails);
    public static final MenuItem enemy_head = new MenuItem("Голова ворога", Role.enemyHeads);
    public static final MenuItem enemy_body = new MenuItem("Тіло ворога", Role.enemyBodies);
    public static final MenuItem enemy_tail = new MenuItem("Хвіст ворога", Role.enemyTails);
    public static final MenuItem barrier = new MenuItem("Бар'єр", Role.barriers);
    public static final MenuItem empty = new MenuItem("Порожнє місце", Role.empties);

    private static MenuItem selectedItem = null;
    private static int currentRoleIndex = 0;

    private final ImageView imageView = new ImageView();
    private Role[] roles;

    void defaultStyle(StyleType type) {
        switch (type) {
            case DEFAULT: setStyle(Settings.defaultStyle); break;
            case PRESSED: setStyle(Settings.pressedStyle); break;
        }
    }

    public MenuItem(String itemName, Role[] roles) {
        defaultStyle(StyleType.DEFAULT);
        this.roles = roles;

//        setMaxSize(0, 0);
        setAlignment(Pos.CENTER_LEFT);

        imageView.setImage(Role.getElementImage(roles[currentRoleIndex]));
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
        element.setRole(roles[currentRoleIndex]);
        element.setImage(Role.getElementImage(roles[currentRoleIndex]));
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

    public static void setRoleIndex(int currentRoleIndex) {
        if (currentRoleIndex < 0 || currentRoleIndex > 4)
            throw new IllegalArgumentException("Role Index Error");

        MenuItem.currentRoleIndex = currentRoleIndex;
        own_head.imageView.setImage(Role.getElementImage(own_head.roles[currentRoleIndex]));
        own_body.imageView.setImage(Role.getElementImage(own_body.roles[currentRoleIndex]));
        own_tail.imageView.setImage(Role.getElementImage(own_tail.roles[currentRoleIndex]));
        enemy_head.imageView.setImage(Role.getElementImage(enemy_head.roles[currentRoleIndex]));
        enemy_body.imageView.setImage(Role.getElementImage(enemy_body.roles[currentRoleIndex]));
        enemy_tail.imageView.setImage(Role.getElementImage(enemy_tail.roles[currentRoleIndex]));
        barrier.imageView.setImage(Role.getElementImage(barrier.roles[currentRoleIndex]));
        empty.imageView.setImage(Role.getElementImage(empty.roles[currentRoleIndex]));
    }
}
