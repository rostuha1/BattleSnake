package windows;

import events.KeyboardEvents;
import org.lwjgl.BufferUtils;
import rendering.GridRender;
import org.lwjgl.opengl.GL;

import java.awt.*;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;

public class WindowManager {

    private static long currentWindow;

    public static final int screenWidth;
    public static final int screenHeight;

    static {

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = d.width;
        screenHeight = d.height;
        glfwInit();

        currentWindow = WindowManager.getNewWindow("Window", true, true);
        GridRender.getInstance().add();

    }

    public static long getCurrentWindow() {
        return currentWindow;
    }

    public static void setCurrentWindow(long window) {
        currentWindow = window;
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glfwShowWindow(window);
        glfwSetKeyCallback(window, new KeyboardEvents());
    }

    public static long getNewWindow(String title, boolean fullscreen, boolean setCurrent) {
        return getNewWindow(WindowManager.screenWidth, WindowManager.screenHeight, title, fullscreen, setCurrent);
    }

    public static long getNewWindow(int screenWidth, int screenHeight, String title, boolean fullscreen, boolean setCurrent) {
        long newWindow = glfwCreateWindow(screenWidth, screenHeight, title, fullscreen ? glfwGetPrimaryMonitor() : 0, 0);

        if (setCurrent) {
            setCurrentWindow(newWindow);
        }

        return newWindow;
    }

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    public static Dimension getWindowSize() {

        IntBuffer w = BufferUtils.createIntBuffer(1);
        IntBuffer h = BufferUtils.createIntBuffer(1);
        glfwGetWindowSize(currentWindow, w, h);

        return new Dimension(w.get(0), h.get(0));
    }

    public static float sidesScreenRatio() {
        return (float) screenWidth / screenHeight;
    }

    public static double sidesWindowRatio() {
        Dimension winDimension = getWindowSize();
        return (double) winDimension.width / winDimension.height;
    }

    public static double sidesRatio(Dimension dimension) {
        return (double) dimension.width / dimension.height;
    }

}
