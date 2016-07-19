package rendering.snake;

import main.Main;
import nodes.Line;
import nodes.Rect;

import java.util.LinkedList;

import static rendering.RenderField.PART;
import static rendering.RenderField.SQUARE_NUMBER;
import static rendering.RenderField.parts;
import static rendering.RenderField.startPoint;
import static rendering.snake.Direction.DOWN;
import static rendering.snake.Direction.LEFT;
import static rendering.snake.Direction.RIGHT;
import static rendering.snake.Direction.UP;

public class Snake {

    private int length = 2;
    private boolean isIncrease;

    private Direction currentDirection = Direction.RIGHT;

    private LinkedList<Rect> rects = new LinkedList<>();

    public final SnakeEngine engine = new KeyboardSnakeEngine();

    public Snake() {
        Position p1 = new Position(2, 1);
        Position p2 = new Position(1, 1);

        rects.add(getRect(p1));
        rects.add(getRect(p2));

        engine.setConduct(this, Main.getRoot().getScene());

        init();
    }

    private void init() {
        Main.getRoot().getChildren().addAll(rects);
    }

    public void setDirection(Direction newDirection) {
        if (currentDirection == LEFT && newDirection == RIGHT) return;
        if (currentDirection == RIGHT && newDirection == LEFT) return;
        if (currentDirection == UP && newDirection == DOWN) return;
        if (currentDirection == DOWN && newDirection == UP) return;

        this.currentDirection = newDirection;
    }

    private Position getNextPos(Position currentPos, Direction currentDirection) {
        switch (currentDirection) {
            case LEFT:
                return new Position(currentPos.x - 1, currentPos.y);
            case RIGHT:
                return new Position(currentPos.x + 1, currentPos.y);
            case UP:
                return new Position(currentPos.x, currentPos.y - 1);
            case DOWN:
                return new Position(currentPos.x, currentPos.y + 1);
        }
        return null;
    }

    public void render() {

        Position nextPosition = getNextPos(rects.getFirst().getPos(), currentDirection);

        Rect rect = getRect(nextPosition);

        rects.addFirst(rect);

        removeTill();
        drawRect(rect);
    }

    private void drawRect(Rect rect) {
        Main.getRoot().getChildren().add(rect);
    }

    private Rect getRect(Position pos) {
        return getRect(pos.x, pos.y);
    }

    private Rect getRect(int posX, int posY) {
        if (posX < 0 || posX > SQUARE_NUMBER + 1 || posY < 0 || posY > SQUARE_NUMBER + 1)
            throw new IllegalArgumentException("Enter valid arguments");

        if (posX == 0) posX = SQUARE_NUMBER;
        if (posY == 0) posY = SQUARE_NUMBER;
        if (posX == SQUARE_NUMBER + 1) posX = 1;
        if (posY == SQUARE_NUMBER + 1) posY = 1;

        double x = startPoint + parts[posX - 1] + Line.getLineWidth();
        double y = parts[posY - 1] + Line.getLineWidth();

        double width = PART - Line.getLineWidth() * 2;
        double height = PART - Line.getLineWidth() * 2;

        Rect resRec = new Rect(x, y, width, height);
        resRec.setPos(posX, posY);

        return resRec;
    }

    public void increase() {
        isIncrease = true;
    }

    private void removeTill() {

        if (isIncrease) {
            isIncrease = false;
            return;
        }

        Main.getRoot().getChildren().remove(rects.getLast());
        rects.removeLast();
    }

}