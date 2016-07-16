package rendering;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class GridRender implements Render {

    private int width;
    private int height;

    private int squareNumber = 25; // n * n

    private final static GridRender instance = new GridRender();
    private GridRender() {}

    public static GridRender getInstance() {
        return instance;
    }

    public void fillSquare(int posX, int posY) throws IllegalArgumentException {
        if (posX < 1 || posX > squareNumber || posY < 1 || posY > squareNumber)
            throw new IllegalArgumentException("Enter valid arguments");

        //ToDo

    }

    @Override
    public void render() {
        glBegin(GL_QUADS);

        glColor4f(1, 0, 0, 0);
        glVertex2f(-0.5f, 0.5f);

        glColor4f(0, 1, 0, 0);
        glVertex2f(0.5f, 0.5f);

        glColor4f(0, 0, 1, 0);
        glVertex2f(0.5f, -0.5f);

        glColor4f(1, 0, 0, 0);
        glVertex2f(-0.5f, -0.5f);

        glEnd();
    }

    private class DrawingArea {
        int width;
        int height;
        int x;
        int y;
    }

}
