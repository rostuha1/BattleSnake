package user_interface.account.battlefield.snake;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.Main;
import main.SnakePane;
import nodes.Rect;
import user_interface.account.battlefield.Cells;
import user_interface.account.content.intelligence.Settings;

import java.util.LinkedList;

public class Snake implements SnakeEngine {

    private static Pane parent = SnakePane.instance;
    private static Snake selectedSnake = null;

    private int length = 0;
    private boolean isIncrease;
    private Color snakeColor;

    private Direction currentDirection;
    private Direction nextDirection = null;

    private LinkedList<Rect> cells;
    private boolean isHighlight = false;

    public Snake(Color snakeColor, Direction initDirection) {

//        ToDo -> to remove

        this.snakeColor = snakeColor;

        Position p1 = new Position(6, 1);
        Position p2 = new Position(5, 1);
        Position p3 = new Position(4, 1);
        Position p4 = new Position(3, 1);
        Position p5 = new Position(2, 1);
        Position p6 = new Position(1, 1);

        LinkedList<Rect> linkedList = new LinkedList<>();
        linkedList.add(getRect(p1, snakeColor));
        linkedList.add(getRect(p2, snakeColor));
        linkedList.add(getRect(p3, snakeColor));
        linkedList.add(getRect(p4, snakeColor));
        linkedList.add(getRect(p5, snakeColor));
        linkedList.add(getRect(p6, snakeColor));

        currentDirection = initDirection;
        length = linkedList.size();
        cells = linkedList;
    }

    public Snake(Position[] positions, Color color, Direction initDirection) {
        setColor(color);

        LinkedList<Rect> linkedList = new LinkedList<>();

        for (Position pos : positions)
            linkedList.add(getRect(pos, snakeColor));

        currentDirection = initDirection;
        length = linkedList.size();
        cells = linkedList;

    }

    public void show() {
        parent.getChildren().addAll(cells);
    }

    public void hide() {
        parent.getChildren().removeAll(cells);
    }

    public void setDirection(Direction nextDirection) {
        this.nextDirection = nextDirection;
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

    private Direction getInverse(Direction direction) {
        switch (direction) {
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            default:
                return currentDirection;
        }
    }

    private Rect getRect(Position pos) {
        return Cells.getRect(pos.x, pos.y);
    }

    private Rect getRect(Position pos, Color color) {
        Rect rect = getRect(pos);
        rect.setFill(color);
        return rect;
    }

    public void increase() {
        length++;
        isIncrease = true;
    }

    private void removeTill() {
        if (isIncrease) {
            isIncrease = false;
            return;
        }

        cells.getLast().setEffect(null);
        cells.getLast().remove();
        cells.removeLast();
    }

    private void go(Action action) {
        Position nextPosition = getNextPos(cells.getFirst().getPos(), currentDirection = getDirectionByAction(action));

        Rect rect = getRect(nextPosition, snakeColor);

        if (isHighlight) rect.setEffect(Settings.itemEffect);
        cells.addFirst(rect);
        Cells.draw(rect, snakeColor);
        removeTill();
    }

    @Override
    public void turnLeft() {
        go(Action.TURN_LEFT);
    }

    @Override
    public void turnRight() {
        go(Action.TURN_RIGHT);
    }

    @Override
    public void goForward() {
        go(Action.GO_FORWARD);
    }

    private Direction getDirectionByAction(Action action) {
        switch (action) {
            case TURN_LEFT:
                switch (currentDirection) {
                    case LEFT:
                        return Direction.DOWN;
                    case RIGHT:
                        return Direction.UP;
                    case UP:
                        return Direction.LEFT;
                    case DOWN:
                        return Direction.RIGHT;
                }
            case TURN_RIGHT:
                switch (currentDirection) {
                    case LEFT:
                        return Direction.UP;
                    case RIGHT:
                        return Direction.DOWN;
                    case UP:
                        return Direction.RIGHT;
                    case DOWN:
                        return Direction.LEFT;
                }
            case GO_FORWARD:
                return currentDirection;
            default:
                return null;
        }
    }

    public Snake getSelectedSnake() {
        return selectedSnake;
    }

    public boolean isHighlight() {
        return isHighlight;
    }

    public Color getColor() {
        return snakeColor;
    }

    public void setColor(Color color) {
        this.snakeColor = color;
    }

    public void highlightSnake(boolean flag) {
        if (flag) {
            selectedSnake = this;
            isHighlight = true;
            cells.forEach(rect -> rect.setEffect(Settings.itemEffect));
            return;
        }

        isHighlight = false;
        cells.forEach(rect -> rect.setEffect(null));
        selectedSnake = null;
    }

}