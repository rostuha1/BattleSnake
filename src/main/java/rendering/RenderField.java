package rendering;

import windows.WindowManager;

import static windows.FormatType.WINDOW;

public class RenderField {

    public static final int SQUARE_NUMBER = 25; // n * n
    public static final int startPoint = WindowManager.sidesRatio(WINDOW);
    public static final double PART = (double) WindowManager.getHeight() / SQUARE_NUMBER;
    public static final double[] parts = new double[SQUARE_NUMBER + 1];

    static {
        parts[0] = 1;
        for (int i = 1; i < SQUARE_NUMBER + 1; i++) {
            parts[i] = PART * i;
        }

    }

}
