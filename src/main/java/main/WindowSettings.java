package main;

import javafx.stage.Screen;

public class WindowSettings {

    private static final Screen screen = Screen.getPrimary();

    public static final double width = screen.getBounds().getWidth();
    public static final double height = screen.getBounds().getHeight();
    public static final boolean fullscreen = true;

    public static double sidesRatio() {
        return (width - height) / 2;
    }

}
