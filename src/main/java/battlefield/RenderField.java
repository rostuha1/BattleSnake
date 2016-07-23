package battlefield;

import main.Window;

public class RenderField {

    public static final int SQUARE_NUMBER = 25; // n * n
    public static final int startPoint = Window.sidesRatio();
    public static final double PART = Window.height / SQUARE_NUMBER;
    public static final double[] parts = new double[SQUARE_NUMBER + 1];

    static {
        for (int i = 0; i < SQUARE_NUMBER + 1; i++) {
            parts[i] = PART * i;
        }
    }

}
