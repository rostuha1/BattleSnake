package user_interface.account.content.rules;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import main.WindowSettings;

import static user_interface.account.MainMenu.CONTENT_WIDTH;

public class RulesContent extends BorderPane {

    private final double HEIGHT = WindowSettings.height * 0.6;
    private final double WIDTH = CONTENT_WIDTH * 0.7;
    private final TextArea purport = new TextArea("" +
            "Суть гри Snake Battle полягає в тому, щоб підготувати свою змію для поєдинку з іншими зміями.\n" +
            "\"Підготувати\" - означає задати за допомогою карток напрям руху змії в тій чи іншій ситуації.\n" +
            "\"Навчена\" змія самостійно керуватиме собою під час гри, а її творцеві залишиться тільки \n" +
            "спостерігати.");
    private final TextArea battleRules = new TextArea("" +
            "У даному розділі гравець має можливість переглянути список змій та вибрати собі від одного\n" +
            "до трьох суперників для подальшого бою.\n" +
            "Колір слоту показує колір змії на ігровому полі. \n" +
            "Кнопка \"Почати бій\" запускає гру з вибраними гравцями.");
    private final TextArea mySnakeRules = new TextArea("" +
            "У даному розділі гравець має можливість переглянути основну інформацію про свою змію\n " +
            "(аватар, ім'я, рейтинг, паспорт змії, її колір), а також редагувати її.");
    private final TextArea intelligenceRules = new TextArea("" +
            "У даному розділі гравець задає \"інтелект\" змії за допомогою дев'яти карток. На кожну\n" +
            "картку додаються певні умовні позначення (частини тіла своєї змії, змії супротивників, \n" +
            "бар'єр), які позначатимуть певний елемент ігрового поля. Кожна карта по черзі порівнюється з\n" +
            "частиною ігрового поля і, у випадку повного співпадіння, виконується, тобто змія робить крок.\n" +
            "Приорітети карток зменшуються у порядку їх розташування (найперша карта має найвищий\n" +
            "приорітет). У випадку, коли елементи жодної з карт не співпали з елементами ігрового поля,\n" +
            "змія ходить випадковим чином.\n" +
            "Для більшої \"гнучкості\" інтелекту змії гравцю доступні такі логічні елементи, як \"OR\", \n" +
            "\"AND\", \"EXCEPT\".\n" +
            "- OR - дозволяє об'єднати декілька елементів в одну групу таким чином, що, якщо хоча б один\n" +
            " з цієї групи співпадає з елементом ігрового поля, то і вся група вважається такою, що\n " +
            "співпала;\n" +
            "- AND - дозволяє об'єднати декілька елементів в одну групу. Група вважається такою, що\n" +
            " співпала, якщо з ігровим полем співпадуть всі елементи цієї групи;\n" +
            "- EXCEPT - елемент з цією властивістю буде вважатися таким, що співпав, якщо на ігровому полі\n" +
            " буде будь-який елемент, крім нього самого.");

    private Tab purportOfGame = new Tab("Суть гри");
    private Tab battle = new Tab("Бій");
    private Tab mySnake = new Tab("Моя змія");
    private Tab intelligence = new Tab("Інтелект");
    private TabPane rules = new TabPane(purportOfGame, battle, mySnake, intelligence);

    {
        purportOfGame.setContent(purport);
        battle.setContent(battleRules);
        mySnake.setContent(mySnakeRules);
        intelligence.setContent(intelligenceRules);

        purportOfGame.setClosable(false);
        battle.setClosable(false);
        mySnake.setClosable(false);
        intelligence.setClosable(false);

        purport.setEditable(false);
        battleRules.setEditable(false);
        mySnakeRules.setEditable(false);
        intelligenceRules.setEditable(false);

        rules.setMaxSize(WIDTH, HEIGHT);

        setCenter(rules);
    }

    public RulesContent() {
    }
}
