package user_interface.account.content.intelligence.menu.menu_items;

import javafx.scene.text.Text;
import user_interface.account.content.intelligence.Settings;

public class ItemText extends Text {

    public ItemText(String text) {
        super(text);
        setFont(Settings.textFont);
    }

}
