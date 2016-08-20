package user_interface.account.content.intelligence.menu.menu_items.items;

import javafx.scene.image.ImageView;
import user_interface.account.content.intelligence.menu.menu_items.ItemText;
import user_interface.account.content.intelligence.Settings;

import static user_interface.account.content.intelligence.Role.*;

public class AndItem extends Item {

    enum Mode { ORANGE, PINK, NULL }

    private static final ImageView orange = new ImageView(getElementImage(A_O_EMPTY));
    private static final ImageView pink = new ImageView(getElementImage(A_P_EMPTY));
    private static final ItemText itemText = new ItemText("AND");

    private static Mode selectedMode = Mode.NULL;

    public static final AndItem instance = new AndItem();

    private AndItem() {
        super(orange, pink, itemText);
        orange.setOnMouseClicked(event -> click(Mode.ORANGE));
        pink.setOnMouseClicked(event -> click(Mode.PINK));
    }

    public void click(Mode newMode) {
        if (selectedMode == newMode) {
            switchOff();
            releaseEvent();
            return;
        }

        switchOn(newMode);
        clickEvent();
    }

    private void releaseEvent() {
        MenuItem.setRoleIndex(0);
    }
    private void clickEvent() {
        OrItem.instance.switchOff();
        ExceptItem.instance.switchOff();
        switch (selectedMode) {
            case ORANGE: MenuItem.setRoleIndex(1); break;
            case PINK: MenuItem.setRoleIndex(2); break;
        }
    }

    public void switchOff() {
        if (selectedMode == Mode.NULL) return;
        getSelectedItem(selectedMode).setEffect(null);
        selectedMode = Mode.NULL;
    }
    public void switchOn(Mode newMode) {
        if (selectedMode != Mode.NULL) getSelectedItem(selectedMode).setEffect(null);
        selectedMode = newMode;
        getSelectedItem(newMode).setEffect(Settings.itemEffect);
    }

    private ImageView getSelectedItem(Mode mode) {
        switch(mode) {
            case ORANGE: return orange;
            case PINK: return pink;
            default: return null;
        }
    }
}
