package rendering;

import windows.ScreenSize;

public class RenderField {

    public static final int SQUARE_NUMBER = 25; // n * n
    public static final int startPoint = ScreenSize.sidesRatio();
    public static final double PART = (double) ScreenSize.getHeight() / SQUARE_NUMBER;
    public static final double[] parts = new double[SQUARE_NUMBER + 1];

    static {
        for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
            parts[i] = PART * i;
        }
    }

}
