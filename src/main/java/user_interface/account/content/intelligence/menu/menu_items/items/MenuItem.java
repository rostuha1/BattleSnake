package user_interface.account.content.intelligence.menu.menu_items.items;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import user_interface.account.content.intelligence.Role;
import user_interface.account.content.intelligence.card_elements.CardElement;
import user_interface.account.content.intelligence.menu.menu_items.ItemText;
import user_interface.account.content.intelligence.Settings;
import user_interface.account.content.intelligence.menu.menu_items.StyleType;

public class MenuItem extends Item {

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
    private boolean isEmptyRole;
    private Role[] roles;

    public MenuItem(String itemName, Role[] roles) {
        this.roles = roles;
        isEmptyRole = roles == Role.empties;

        setAlignment(Pos.CENTER_LEFT);

        imageView.setImage(Role.getElementImage(roles[currentRoleIndex]));
        ItemText itemText = new ItemText(itemName);

        super.init(imageView, itemText);
        setOnMouseClicked(event -> click());

    }

    private void click() {
        if (CardElement.getSelectedElement() == null) return;
        if (selectedItem == this) {
            selectedItem = null;
            defaultStyle(StyleType.DEFAULT);
            CardElement.getSelectedElement().setEffect(null);
            CardElement.setSelectedElement(null);
            return;
        }
        selectedItem = this;
        changeSelectedCardElement();
        defaultStyle(StyleType.PRESSED);
    }

    private void changeSelectedCardElement() {
        CardElement element = CardElement.getSelectedElement();
        if (element == null) return;

        if (isEmptyRole) {
            element.setRole(Role.EMPTY);
            element.setImage(Role.getElementImage(Role.EMPTY));
        } else {
            element.setRole(roles[currentRoleIndex]);
            element.setImage(Role.getElementImage(roles[currentRoleIndex]));
        }
    }

    void defaultStyle(StyleType type) {
        switch (type) {
            case DEFAULT:
                setBackground(Settings.defaultMenuItemBackground);
                break;
            case PRESSED:
                setBackground(Settings.pressedMenuItemBackground);
                break;
        }
    }

    public static void selectItem(Role role, StyleType type) {
        if (selectedItem != null) selectedItem.defaultStyle(StyleType.DEFAULT);
        MenuItem item = null;

        if (Role.isOwnHead(role)) item = own_head;
        else if (Role.isOwnBody(role)) item = own_body;
        else if (Role.isOwnTail(role)) item = own_tail;
        else if (Role.isEnemyHead(role)) item = enemy_head;
        else if (Role.isEnemyBody(role)) item = enemy_body;
        else if (Role.isEnemyTail(role)) item = enemy_tail;
        else if (Role.isBarrier(role)) item = barrier;
        else if (Role.isEmpty(role)) item = empty;

        if (item != null) {
            item.defaultStyle(type);
            selectedItem = item;
        }

    }

    public static void setRoleIndex(int currentRoleIndex) {

        if (currentRoleIndex < 0 || currentRoleIndex > 4)
            throw new IllegalArgumentException("Role Index Error");

        switch (currentRoleIndex) {
            case 0: {
                AndItem.instance.switchOff();
                OrItem.instance.switchOff();
                ExceptItem.instance.switchOff();
                break;
            }
            case 1: {
                AndItem.instance.switchOn(AndItem.Mode.ORANGE);
                OrItem.instance.switchOff();
                ExceptItem.instance.switchOff();
                break;
            }
            case 2: {
                AndItem.instance.switchOn(AndItem.Mode.PINK);
                OrItem.instance.switchOff();
                ExceptItem.instance.switchOff();
                break;
            }
            case 3: {
                OrItem.instance.switchOn();
                AndItem.instance.switchOff();
                ExceptItem.instance.switchOff();
                break;
            }
            case 4: {
                ExceptItem.instance.switchOn();
                AndItem.instance.switchOff();
                OrItem.instance.switchOff();
                break;
            }
        }

        MenuItem.currentRoleIndex = currentRoleIndex;
        own_head.imageView.setImage(Role.getElementImage(own_head.roles[currentRoleIndex]));
        own_body.imageView.setImage(Role.getElementImage(own_body.roles[currentRoleIndex]));
        own_tail.imageView.setImage(Role.getElementImage(own_tail.roles[currentRoleIndex]));
        enemy_head.imageView.setImage(Role.getElementImage(enemy_head.roles[currentRoleIndex]));
        enemy_body.imageView.setImage(Role.getElementImage(enemy_body.roles[currentRoleIndex]));
        enemy_tail.imageView.setImage(Role.getElementImage(enemy_tail.roles[currentRoleIndex]));
        barrier.imageView.setImage(Role.getElementImage(barrier.roles[currentRoleIndex]));

        CardElement element = CardElement.getSelectedElement();
        if (element != null && selectedItem != null && selectedItem.roles != Role.empties) {
            element.setRole(selectedItem.roles[currentRoleIndex]);
            element.setImage(Role.getElementImage(selectedItem.roles[currentRoleIndex]));
        }

    }
}
