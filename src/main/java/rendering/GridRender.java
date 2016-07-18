package rendering;

import windows.WindowManager;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
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

        glColor4f(1, 1, 1, 0);

        glBegin(GL_LINES);

        for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
            glVertex2d(startPoint + parts[i], 0);
            glVertex2d(startPoint + parts[i], WindowManager.getHeight());
        }

        for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
            glVertex2d(startPoint, parts[i]);
            glVertex2d(startPoint + WindowManager.getHeight(), parts[i]);
        }

        glEnd();

    }

}
