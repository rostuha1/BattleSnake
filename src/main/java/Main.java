import rendering.MainRenderer;

public class Main {

    static {
        System.setProperty("java.library.path", "native");
    }

    public static void main(String[] args) {

        MainRenderer.startLoop();

    }
}