package rendering;

import windows.WindowManager;

import java.awt.Dimension;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class GridRender implements Render {

    private int width;
    private int height;

    private int squareNumber = 25; // n * n

    private final static GridRender instance = new GridRender();

    private GridRender() {
    }

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

        glColor4f(1, 0, 0, 0);

        Dimension winDimension = WindowManager.getWindowSize();
        double ratio = WindowManager.sidesRatio(winDimension);

        if (ratio > 1) {
            double res = (double) winDimension.height / winDimension.width;
            double verticalPart = res * 2 / (squareNumber - 1);
            double horizontalPart = (double) 2 / squareNumber;

            glBegin(GL_LINES);

            for (int i = 0; i < squareNumber; i++) {
                glVertex2d(-res + verticalPart * i, -1);
                glVertex2d(-res + verticalPart * i, 1);
            }

            for (int i = 0; i < squareNumber; i++) {
                glVertex2d(-res, -1 + horizontalPart * i);
                glVertex2d(res, -1 + horizontalPart * i);
            }

            glEnd();
        }

    }

}
