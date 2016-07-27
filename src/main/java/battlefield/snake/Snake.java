package battlefield.snake;

public class Snake {

//    private int length = 2;
//    private boolean isIncrease;
//    private static Pane parent;
//
//    private Direction currentDirection = Direction.RIGHT;
//    private Direction nextDirection = currentDirection;
//
//    private LinkedList<Rect> cells = new LinkedList<>();
//
//    public final SnakeEngine engine = new KeyboardSnakeEngine();
//
//    static {
//        parent = Main.getSnakeField();
//    }
//
//    public Snake() {
//
////        for (int i = length; i > 0; i--) {
////            cells.add(getRect(new Position(i, 1)));
////        }
//
//        Position p1 = new Position(6, 1);
//        Position p2 = new Position(5, 1);
//        Position p3 = new Position(4, 1);
//        Position p4 = new Position(3, 1);
//        Position p5 = new Position(2, 1);
//        Position p6 = new Position(1, 1);
//
//        cells.add(getRect(p1));
//        cells.add(getRect(p2));
//        cells.add(getRect(p3));
//        cells.add(getRect(p4));
//        cells.add(getRect(p5));
//        cells.add(getRect(p6));
//
//        engine.setConduct(this, Main.getRoot().getScene());
//
//        init();
//    }
//
//    public static void setParent(Pane parent) {
//        Snake.parent = parent;
//        Rect.setParent(parent);
//    }
//
//    private void init() {
//        parent.getChildren().addAll(cells);
//    }
//
//    public void setDirection(Direction nextDirection) {
//        this.nextDirection = nextDirection;
//    }
//
//    private Position getNextPos(Position currentPos, Direction currentDirection) {
//        switch (currentDirection) {
//            case LEFT:
//                return new Position(currentPos.x - 1, currentPos.y);
//            case RIGHT:
//                return new Position(currentPos.x + 1, currentPos.y);
//            case UP:
//                return new Position(currentPos.x, currentPos.y - 1);
//            case DOWN:
//                return new Position(currentPos.x, currentPos.y + 1);
//        }
//        return null;
//    }
//
//    private Direction getInverse(Direction direction) {
//        if (direction == LEFT) return RIGHT;
//        if (direction == RIGHT) return LEFT;
//        if (direction == UP) return DOWN;
//        if (direction == DOWN) return UP;
//        return currentDirection;
//    }
//
//    public void render() {
//
//        if (nextDirection != getInverse(currentDirection)) currentDirection = nextDirection;
//
//        Position nextPosition = getNextPos(cells.getFirst().getPos(), currentDirection);
//
//        Rect rect = getRect(nextPosition);
//
//        cells.addFirst(rect);
//
//        removeTill();
//        rect.draw();
//    }
//
//    private Rect getRect(Position pos) {
//        return getRect(pos.x, pos.y);
//    }
//
//    public void increase() {
//        isIncrease = true;
//    }
//
//    private void removeTill() {
//
//        if (isIncrease) {
//            isIncrease = false;
//            return;
//        }
//
//        cells.getLast().remove();
//        cells.removeLast();
//    }

}