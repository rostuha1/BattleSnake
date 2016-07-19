package nodes;

public class Line extends javafx.scene.shape.Line {

    private static double lineWidth = 2;

    {
        setStrokeWidth(lineWidth);
    }

    public Line(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
    }

    public static double getLineWidth() {
        return lineWidth;
    }

}
