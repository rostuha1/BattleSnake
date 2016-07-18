package windows;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSize {

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static int getWidth() {
        return screenSize.width;
    }

    public static int getHeight() {
        return screenSize.height;
    }

    public static int sidesRatio() {
        return (screenSize.width - screenSize.height) / 2;
    }
}
