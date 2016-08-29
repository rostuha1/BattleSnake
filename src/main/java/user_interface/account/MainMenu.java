package user_interface.account;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.WindowSettings;
import user_interface.account.content.ContentType;
import user_interface.account.content.developers.DevelopersContent;
import user_interface.account.content.fight.FightContent;
import user_interface.account.content.fight.slots.SlotsBox;
import user_interface.account.content.intelligence.IntelligenceContent;
import user_interface.account.content.my_snake.MySnakeContent;
import user_interface.account.content.rules.RulesContent;
import user_interface.animation.TransitionAnimation;

public class MainMenu extends BorderPane {

    public static final double SIDE_MENU_WIDTH = WindowSettings.width / 4.5;
    public static final double CONTENT_WIDTH = WindowSettings.width - SIDE_MENU_WIDTH;
    private static Pane currentContent = null;

    private final FightContent fightContent = new FightContent();
    private final IntelligenceContent intelligenceContent = new IntelligenceContent();
    private final MySnakeContent mySnakeContent = new MySnakeContent();
    private final RulesContent rulesContent = new RulesContent();
    private final DevelopersContent developersContent = new DevelopersContent();

    public static final MainMenu instance = new MainMenu();

    {
        setPrefSize(WindowSettings.width, WindowSettings.height);
    }

    private MainMenu() {
        setRight(new SideMenu());
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
                SlotsBox.instance.mySlot.updateSlot(User.getInstance().getSnakePlayer());
                break;
            case INTELLIGENCE_CONTENT:
                newContent = intelligenceContent;
                break;
            case MY_SNAKE_CONTENT:
                newContent = mySnakeContent;
                break;
            case RULES_CONTENT:
                newContent = rulesContent;
                break;
            case DEVELOPERS_CONTENT:
                newContent = developersContent;
                break;
        }

        if (TransitionAnimation.start(this, currentContent, newContent))
            currentContent = newContent;

    }

}
