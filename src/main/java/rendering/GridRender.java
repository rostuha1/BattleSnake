package rendering;

import javafx.scene.Node;
import main.Line;
import main.Main;
import windows.ScreenSize;

import java.util.ArrayList;
import java.util.List;

import static rendering.RenderField.SQUARE_NUMBER;
import static rendering.RenderField.parts;
import static rendering.RenderField.startPoint;


public class GridRender implements Render {

    private final static GridRender instance = new GridRender();

    private GridRender() {}

    public static GridRender getInstance() {
        return instance;
    }

    @Override
    public void render() {

        List<Node> nodes = new ArrayList<>();

        for (int i = 0 ; i < SQUARE_NUMBER + 1; i++) {
            nodes.add(new Line(startPoint + parts[i], 0, startPoint + parts[i], ScreenSize.getHeight()));
            nodes.add(new Line(startPoint, parts[i], startPoint + ScreenSize.getHeight(), parts[i]));
        }

        Main.root.getChildren().addAll(nodes);

    }

}
