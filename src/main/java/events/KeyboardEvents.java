package events;

import org.lwjgl.glfw.GLFWKeyCallback;
import windows.WindowManager;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_SPACE;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;

public class KeyboardEvents extends GLFWKeyCallback {

    public static boolean[] keys = new boolean[65536];

    @Override
        public void invoke(long window, int key, int scanCode, int action, int mods) {
        keys[key] = action == GLFW_PRESS;

        checkPressedKeys();
    }

    public static boolean isKeyDown(int keycode) {
        return keys[keycode];
    }

    public static void checkPressedKeys() {
        if (isKeyDown(GLFW_KEY_SPACE)) {
            System.out.println("Space pressed");
        }

        if (isKeyDown(GLFW_KEY_ESCAPE)) {
            glfwDestroyWindow(WindowManager.getCurrentWindow());
            System.exit(0);
        }
    }

}
