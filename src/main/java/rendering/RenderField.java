package rendering;

import windows.WindowManager;

import static windows.FormatType.WINDOW;

public class RenderField {

    public static final int SQUARE_NUMBER = 3; // n * n
    public static final double RATIO = WindowManager.sidesRatio(WINDOW);
    public static final double V_PART = RATIO * 2 / SQUARE_NUMBER;
    public static final double H_PART = (double) 2 / SQUARE_NUMBER;
    public static final double[] vParts = new double[SQUARE_NUMBER + 1];
    public static final double[] hParts = new double[SQUARE_NUMBER + 1];

    static {
        hParts[0] = 0.00001;

        for (int i = 1; i < SQUARE_NUMBER + 1; i++) {
            vParts[i] = V_PART * i;
            hParts[i] = H_PART * i;
        }

        hParts[SQUARE_NUMBER] = H_PART * SQUARE_NUMBER - 0.00001;
    }

}
