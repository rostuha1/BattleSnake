package rendering.snake;

import rendering.MainRenderer;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2d;
import static rendering.RenderField.SQUARE_NUMBER;
import static rendering.RenderField.parts;
import static rendering.RenderField.startPoint;

public class Snake {

    public static void fillSquare(int posX, int posY) {
        if (posX < 1 || posX > SQUARE_NUMBER || posY < 1 || posY > SQUARE_NUMBER)
            throw new IllegalArgumentException("Enter valid arguments");

        glColor3f(0, 1, 1);

        int lineWidth = MainRenderer.getLineWidth();
        int additionWidth = lineWidth % 2 - (lineWidth > 3 ? 1 : 0) + (lineWidth/=2)/2;

        glBegin(GL_QUADS);

        glVertex2d(startPoint + parts[posX - 1] + lineWidth, parts[posY - 1] + lineWidth);   // top left
        glVertex2d(startPoint + parts[posX] - lineWidth - additionWidth, parts[posY - 1] + lineWidth);  // top right
        glVertex2d(startPoint + parts[posX] - lineWidth - additionWidth, parts[posY] - lineWidth - additionWidth);  // bottom right
        glVertex2d(startPoint + parts[posX - 1] + lineWidth, parts[posY] - lineWidth - additionWidth);  // bottom left

        glEnd();

    }

}