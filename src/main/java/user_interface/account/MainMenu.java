package user_interface.account;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.WindowSettings;
import user_interface.account.content.ContentType;
import user_interface.account.content.fight.FightContent;
import user_interface.account.content.intelligence.IntelligenceContent;
import user_interface.animation.TransitionAnimation;

public class MainMenu extends BorderPane {

    public static final double SIDE_MENU_WIDTH = WindowSettings.width / 4.5;
    public static final double CONTENT_WIDTH = WindowSettings.width - SIDE_MENU_WIDTH;
    public static final MainMenu instance = new MainMenu();

    private final SideMenu sideMenu = new SideMenu();
    private final FightContent fightContent = new FightContent();
    private final IntelligenceContent intelligenceContent = new IntelligenceContent();

    private static Pane currentContent = null;

    {
        setPrefSize(WindowSettings.width, WindowSettings.height);
    }

    private MainMenu() {
        setRight(sideMenu);
    }

    public static Pane getCurrentContent() {
        return currentContent;
    }

    public void setContent(ContentType contentType) {

        if (contentType == null) {
            setCenter(null);
            currentContent = null;
            return;
        }

        Pane newContent = null;

        switch (contentType) {
            case FIGHT_CONTENT:
                newContent = fightContent;
                break;
            case INTELLIGENCE_CONTENT:
                newContent = intelligenceContent;
                break;
        }

        if (currentContent == newContent) return;

        TransitionAnimation.start(this, currentContent, newContent);

        currentContent = newContent;

    }

}
