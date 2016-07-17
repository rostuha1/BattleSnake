package rendering;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static rendering.RenderField.RATIO;
import static rendering.RenderField.SQUARE_NUMBER;
import static rendering.RenderField.hParts;
import static rendering.RenderField.vParts;

public class GridRender implements Render {

    private final static GridRender instance = new GridRender();

    private GridRender() {}

    public static GridRender getInstance() {
        return instance;
    }

    @Override
    public void render() {

        glColor4f(1, 0, 0, 0);

        glBegin(GL_LINES);

        for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
            glVertex2d(-RATIO + vParts[i], -1);
            glVertex2d(-RATIO + vParts[i], 1);
        }

        for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
            glVertex2d(-RATIO, 1 - hParts[i]);
            glVertex2d(RATIO, 1 - hParts[i]);
        }

        glEnd();

    }

}
