package main;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Window {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int width = screenSize.width;
    public static final int height = screenSize.height;

    public static int sidesRatio() {
        return (width - height) / 2;
    }

}
