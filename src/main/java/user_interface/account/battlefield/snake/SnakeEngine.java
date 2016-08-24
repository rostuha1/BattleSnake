package user_interface.account.battlefield.snake;

public interface SnakeEngine {

    enum Action { TURN_LEFT, TURN_RIGHT, GO_FORWARD }

    void turnLeft();
    void turnRight();
    void goForward();

}
