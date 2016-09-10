package user_interface.account.battlefield;

import client_server_I_O.classes.Block;
import client_server_I_O.classes.Turn;
import user_interface.account.battlefield.menu.GameSpeedChanger;
import user_interface.account.battlefield.snake.Snake;

import java.util.ArrayList;
import java.util.Map;

public class Game {

    public static void play(ArrayList<Turn> turns) {
        turns.forEach(Game::playTurn);
    }

    private static void playTurn(Turn turn) {
        turn.getBody().entrySet().forEach(Game::playStep);
    }

    private static void playStep(Map.Entry<Integer, ArrayList<Block>> step) {
        GameSpeedChanger.sleepForNextStep();
        Snake.setSnakeBody(step.getKey(), step.getValue());
    }

}
