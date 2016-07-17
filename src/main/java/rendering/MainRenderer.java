package rendering;

import windows.WindowManager;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLineWidth;

public class MainRenderer {

    private static double lineWidth = 1.0;

    private static List<Render> renderList = new ArrayList<>();

    private MainRenderer() {}

    public static void addRender(Render render) {
        renderList.add(render);
    }

    public static void remove(Render render) {
        renderList.remove(render);
    }

    private static void render() {
        renderList.forEach(Render::render);
    }

    private static void loop() {
        glfwPollEvents();
        glClear(GL_COLOR_BUFFER_BIT);

        render();

        glfwSwapBuffers(WindowManager.getCurrentWindow());
    }

    public static void startLoop() {
        while (!glfwWindowShouldClose(WindowManager.getCurrentWindow()))
            loop();

        glfwDestroyWindow(WindowManager.getCurrentWindow());
        glfwTerminate();
    }

    public static double getLineWidth() {
        return lineWidth;
    }
    public static void setLineWidth(float lineWidth) {
        MainRenderer.lineWidth = lineWidth;
        glLineWidth(lineWidth);
    }

    public static double getVertexLineWidthX() {
        return lineWidth * 2 / WindowManager.getScreenWidth();
    }
    public static double getVertexLineWidthY() {
        return lineWidth * 2 / WindowManager.getScreenHeight();
    }

}
