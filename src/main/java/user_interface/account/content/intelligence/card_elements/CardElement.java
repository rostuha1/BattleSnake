package user_interface.account.content.intelligence.card_elements;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import user_interface.account.content.intelligence.Settings;
import user_interface.account.content.intelligence.menu.menu_items.items.MenuItem;
import user_interface.account.content.intelligence.Role;
import user_interface.account.content.intelligence.menu.menu_items.StyleType;

public class CardElement extends ImageView {

    private static Insets insets = new Insets(2);
    private static CardElement selectedElement = null;

    private Role role;

    {
        GridPane.setMargin(this, insets);
        setOnMouseClicked(event -> click());
    }

    public CardElement() {
        setRole(Role.EMPTY);
    }

    public CardElement(Role role) {
        setRole(role);
    }

    public Role getRole() {
        return role;
    }

    public static CardElement getSelectedElement() {
        return selectedElement;
    }
    public static void setSelectedElement(CardElement selectedElement) {
        CardElement.selectedElement = selectedElement;
    }

    public void setRole(Role role) {
        setImage(Role.getElementImage(this.role = role));
    }

    private void click() {
        if (selectedElement == this) switchOff(); else switchOn();
    }

    private void switchOff() {
        selectedElement = null;
        setEffect(null);
        MenuItem.selectItem(role, StyleType.DEFAULT);
    }

    private void switchOn() {
        if (selectedElement != null) selectedElement.setEffect(null);
        selectedElement = this;
        setEffect(Settings.cardElementSwitchEffect);
        MenuItem.selectItem(role, StyleType.PRESSED);

        if (Role.isSimpleElement(role)) MenuItem.setRoleIndex(0);
        if (Role.isAOElement(role)) MenuItem.setRoleIndex(1);
        if (Role.isAPElement(role)) MenuItem.setRoleIndex(2);
        if (Role.isOrElement(role)) MenuItem.setRoleIndex(3);
        if (Role.isExceptElement(role)) MenuItem.setRoleIndex(4);

    }

}
