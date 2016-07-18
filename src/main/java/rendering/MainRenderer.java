package rendering;

import rendering.snake.Snake;
import windows.WindowManager;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_LINE_WIDTH;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glGetInteger;
import static org.lwjgl.opengl.GL11.glLineWidth;

public class MainRenderer {

    private static int lineWidth = 2;
    private static boolean isRun;

    private static List<Render> renderList = new ArrayList<>();

    private MainRenderer() {
    }

    public static void addRender(Render render) {
        renderList.add(render);
    }

    public static void remove(Render render) {
        renderList.remove(render);
    }

    private static void render() {
        for (int i = 1; i < RenderField.SQUARE_NUMBER + 1; i++) {
            for (int j = 1; j < RenderField.SQUARE_NUMBER + 1; j++) {
                Snake.fillSquare(i, j);
            }
        }
        renderList.forEach(Render::render);
    }

    private static void loop() {
        glfwPollEvents();
        glClear(GL_COLOR_BUFFER_BIT);

        render();

        glfwSwapBuffers(WindowManager.getCurrentWindow());
    }

    public static void startLoop() {

        long startWindow = WindowManager.getCurrentWindow();

        isRun = true;
        setLineWidth(lineWidth);

        while (!glfwWindowShouldClose(startWindow))
            loop();

        glfwDestroyWindow(WindowManager.getCurrentWindow());
        glfwTerminate();
    }

    public static int getLineWidth() {
        return lineWidth;
    }

    public static void setLineWidth(int lineWidth) {
        if (lineWidth > 7) throw new IllegalArgumentException("Enter line width 7 or less");
        if (!isRun) MainRenderer.lineWidth = lineWidth;
        else {
            glLineWidth(lineWidth);
            MainRenderer.lineWidth = glGetInteger(GL_LINE_WIDTH);
        }

    }


}
