package battlefield;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import main.Main;
import nodes.Line;

import java.util.ArrayList;
import java.util.List;

import static battlefield.RenderField.SQUARE_NUMBER;
import static battlefield.RenderField.parts;
import static battlefield.RenderField.startPoint;


public class Grid {

    private static Pane parent;

    private Grid() {}

    static {
        parent = Main.getSnakeField();
    }

    public static void setParent(Pane parent) {
        Grid.parent = parent;
    }

    public static void draw() {

        List<Node> nodes = new ArrayList<>();

        for (int i = 0 ; i < SQUARE_NUMBER + 1; i++) {
            nodes.add(new Line(startPoint + parts[i], 0, startPoint + parts[i], Main.getRoot().getPrefHeight()));
            nodes.add(new Line(startPoint, parts[i], startPoint + Main.getRoot().getPrefHeight(), parts[i]));
        }

        parent.getChildren().addAll(nodes);

    }

}
