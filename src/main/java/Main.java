import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Main {
    private static long windowID;

    private static void init() {
        if (!glfwInit()) throw new IllegalStateException("Init failed");
        if ((windowID = glfwCreateWindow(1600, 900, "Window", MemoryUtil.NULL, MemoryUtil.NULL)) == MemoryUtil.NULL)
            throw new IllegalStateException("Window failed");

        glfwMakeContextCurrent(windowID);
        GL.createCapabilities();
        glfwSwapInterval(1);
        glfwShowWindow(windowID);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 1600, 900, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);

    }

    private static void update() {

        glfwPollEvents();
    }

    private static void render() {
        glBegin(GL_LINES);
        glVertex2i(300, 300);
        glVertex2i(500, 500);
        glEnd();

        glfwSwapBuffers(windowID);
    }

    private static void loop() {
        glClear(GL_COLOR_BUFFER_BIT);

        update();
        render();
    }

    public static void main(String[] args) {

        init();

//        glClearColor(0, 1, 0, 1);

        while (!glfwWindowShouldClose(windowID)) loop();

        glfwDestroyWindow(windowID);
        glfwTerminate();

    }
}