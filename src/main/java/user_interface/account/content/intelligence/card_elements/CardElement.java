package user_interface.account.content.intelligence.card_elements;

import javafx.geometry.Insets;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import user_interface.account.content.intelligence.menu_items.MenuItem;
import user_interface.account.content.intelligence.Role;
import user_interface.account.content.intelligence.menu_items.StyleType;

public class CardElement extends ImageView {

    private static Insets insets = new Insets(2);
    private static CardElement selectedElement = null;

    private Role role;

    {
        GridPane.setMargin(this, insets);
        setOnMouseClicked(event -> {
            if (selectedElement == this) {
                selectedElement = null;
                setEffect(null);
                MenuItem.selectItem(role, StyleType.DEFAULT);
                return;
            }
            if (selectedElement != null) selectedElement.setEffect(null);
            selectedElement = this;
            setEffect(new ColorAdjust(0, 0, -0.4, 0));
            MenuItem.selectItem(role, StyleType.PRESSED);
        });
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

}