package user_interface.account.content.intelligence;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import user_interface.account.content.intelligence.cardElements.CardElement;

public class MenuItem extends HBox {

    private static final String defaultStyle = "-fx-border-color: #93af0f; -fx-border-width: 2px;";
    private static final String pressedStyle = defaultStyle + "-fx-background-color: #23af11";

    public static final MenuItem own_head = new MenuItem("own_head.png", "Своя голова", Role.OWN_HEAD);
    public static final MenuItem own_body = new MenuItem("own_body.png", "Своє тіло", Role.OWN_BODY);
    public static final MenuItem own_tail = new MenuItem("own_tail.png", "Свій хвіст", Role.OWN_TAIL);
    public static final MenuItem enemy_head = new MenuItem("enemy_head.png", "Голова ворога", Role.ENEMY_HEAD);
    public static final MenuItem enemy_body = new MenuItem("enemy_body.png", "Тіло ворога", Role.ENEMY_BODY);
    public static final MenuItem enemy_tail = new MenuItem("enemy_tail.png", "Хвіст ворога", Role.ENEMY_TAIL);
    public static final MenuItem barrier = new MenuItem("barrier.png", "Бар'єр", Role.BARRIER);
    public static final MenuItem empty = new MenuItem("empty.png", "Порожнє місце", Role.EMPTY);

    private static MenuItem selectedItem = null;

    private Role role;

    public MenuItem(String imageFile, String itemName, Role role) {
        defaultStyle(true);
        this.role = role;

//        setMaxSize(0, 0);
        setAlignment(Pos.CENTER_LEFT);

        ImageView imageView = new ImageView(new Image(IntelligenceContent.cardElementImagesPath + imageFile));
        Text text = new Text(itemName);
        text.setFont(Font.font(16));

        HBox.setMargin(text, new Insets(10));
        HBox.setMargin(imageView, new Insets(10));

        getChildren().addAll(imageView, text);

        setOnMouseClicked(event -> {
            if (CardElement.getSelectedElement() == null) return;
            if (selectedItem == this) {
                selectedItem = null;
                defaultStyle(true);
                CardElement.getSelectedElement().setEffect(null);
                CardElement.setSelectedElement(null);
                return;
            }
            if (selectedItem != null) selectedItem.setStyle(defaultStyle);
            selectedItem = this;
            changeSelectedCardElement();
            defaultStyle(false);
        });

    }

    private void defaultStyle(boolean flag) {
        setStyle(flag ? defaultStyle : pressedStyle);
    }

    private void changeSelectedCardElement() {
        CardElement element = CardElement.getSelectedElement();
        if (element == null) return;
        element.setRole(role);
        element.setImage(Role.getElementImage(role));
    }

    public static void selectItem(Role role, boolean flag) {
        if (selectedItem != null) selectedItem.defaultStyle(true);
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
            item.defaultStyle(!flag);
            selectedItem = item;
        }

    }

}
