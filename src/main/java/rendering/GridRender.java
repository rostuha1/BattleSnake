package rendering;

import windows.WindowManager;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;

public class GridRender implements Render {

    private int width;
    private int height;

    private final int SQUARE_NUMBER = 10; // n * n
    private final double RATIO = WindowManager.sidesRatio(WindowManager.getWindowSize());
    private final double V_PART = RATIO * 2 / SQUARE_NUMBER;
    private final double H_PART = (double) 2 / SQUARE_NUMBER;
    private double[] vParts = new double[SQUARE_NUMBER + 1];
    private double[] hParts = new double[SQUARE_NUMBER + 1];

    private final static GridRender instance = new GridRender();

    private GridRender() {

        hParts[0] = 0.00001;

        for (int i = 1; i < SQUARE_NUMBER + 1; i++) {
            vParts[i] = V_PART * i;
            hParts[i] = H_PART * i;
        }

    }

    public static GridRender getInstance() {
        return instance;
    }

    public void fillSquare(int posX, int posY) throws IllegalArgumentException {
        if (posX < 1 || posX > SQUARE_NUMBER || posY < 1 || posY > SQUARE_NUMBER)
            throw new IllegalArgumentException("Enter valid arguments");

        //ToDo

    }

    @Override
    public void render() {

        glColor4f(1, 0, 0, 0);


        if (RATIO < 1) {


            glBegin(GL_LINES);

            for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
                glVertex2d(-RATIO + vParts[i], -1);
                glVertex2d(-RATIO + vParts[i], 1);
            }

            for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
                glVertex2d(-RATIO, 1 - hParts[i]);
                glVertex2d(RATIO, 1 - hParts[i]);
            }

//            glVertex2d(-1f, 1f);
//            glVertex2d(1f, 1f);

            glEnd();
        }

    }

}
