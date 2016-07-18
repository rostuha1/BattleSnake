package rendering;

import windows.WindowManager;

import static windows.FormatType.WINDOW;

public class RenderField {

    public static final int SQUARE_NUMBER = 10; // n * n
    public static final int startPoint = WindowManager.sidesRatio(WINDOW);
    public static final int PART = WindowManager.getHeight() / SQUARE_NUMBER;
    public static final int[] parts = new int[SQUARE_NUMBER + 1];

    static {
        parts[0] = 1;
        for (int i = 1; i < SQUARE_NUMBER + 1; i++) {
            parts[i] = PART * i;
        }

    }

}
