package windows;

import events.KeyboardEvents;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL;
import rendering.GridRender;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

public class WindowManager {

    private static long currentWindow;
    private static FormatType type;

    private static final int width;
    private static final int height;
    private static Dimension windowSize;

    static {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        glfwInit();

        final boolean fullscreen = true;
        final boolean setCurrent = true;

        currentWindow = getNewWindow("Window", fullscreen, setCurrent);
        GridRender.getInstance().add();

    }

    public static long getCurrentWindow() {
        return currentWindow;
    }
    public static void setCurrentWindow(long window) {

        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        windowSize = getWindowSize(window);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, getWidth(), getHeight(), 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);

//        glfwHideWindow(currentWindow);
        glfwShowWindow(window);
        glfwSetKeyCallback(window, new KeyboardEvents());
        currentWindow = window;
    }

    public static long getNewWindow(String title, boolean fullscreen, boolean setCurrent) {
        type = fullscreen ? FormatType.SCREEN : FormatType.WINDOW;
        return getNewWindow(WindowManager.width, WindowManager.height, title, fullscreen, setCurrent);
    }
    public static long getNewWindow(int width, int height, String title, boolean fullscreen, boolean setCurrent) {
        long newWindow = glfwCreateWindow(width, height, title, fullscreen ? glfwGetPrimaryMonitor() : 0, 0);

        if (setCurrent) {
            setCurrentWindow(newWindow);
        }

        return newWindow;
    }

    public static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
    public static Dimension getWindowSize(long window) {

        IntBuffer w = BufferUtils.createIntBuffer(1);
        IntBuffer h = BufferUtils.createIntBuffer(1);
        glfwGetWindowSize(window, w, h);

        return new Dimension(w.get(0), h.get(0));
    }

    public static int sidesRatio(FormatType type) {
        Dimension d = type == FormatType.SCREEN ? getScreenSize() : getWindowSize(currentWindow);
        int res = (d.width - d.height) / 2;
        return res > 0 ? res : 0;
    }

    public static int getWidth() {
        return type == FormatType.SCREEN ? width : windowSize.width;
    }
    public static int getHeight() {
        return type == FormatType.SCREEN ? height : windowSize.height;
    }
}
