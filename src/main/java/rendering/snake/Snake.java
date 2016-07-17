package rendering.snake;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static rendering.RenderField.RATIO;
import static rendering.RenderField.SQUARE_NUMBER;
import static rendering.RenderField.hParts;
import static rendering.RenderField.vParts;

public class Snake {

    public static void fillSquare(int posX, int posY) throws IllegalArgumentException {
        if (posX < 1 || posX > SQUARE_NUMBER || posY < 1 || posY > SQUARE_NUMBER)
            throw new IllegalArgumentException("Enter valid arguments");

        glColor4f(0, 1, 1, 0);

        glBegin(GL_QUADS);

        glVertex2d(-RATIO + vParts[posX - 1], 1 - hParts[posY - 1]);
        glVertex2d(-RATIO + vParts[posX], 1 - hParts[posY - 1]);
        glVertex2d(-RATIO + vParts[posX], 1 - hParts[posY]);
        glVertex2d(-RATIO + vParts[posX - 1], 1 - hParts[posY]);

        glEnd();

    }


}