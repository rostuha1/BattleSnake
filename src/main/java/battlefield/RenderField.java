package battlefield;

import main.WindowSettings;

public class RenderField {

    public static final int SQUARE_NUMBER = 3; // n * n
    public static final double startPoint = WindowSettings.sidesRatio();
    public static final double PART = WindowSettings.height / SQUARE_NUMBER;
    public static final double[] parts = new double[SQUARE_NUMBER + 1];

    static {
        for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
            parts[i] = PART * i;
        }
    }

}
