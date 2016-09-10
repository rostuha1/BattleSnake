package user_interface.account.battlefield;

import client_server_I_O.classes.Block;
import client_server_I_O.classes.Turn;
import javafx.application.Platform;
import user_interface.account.battlefield.menu.GameSpeedChanger;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.fight.slots.SlotsBox;
import user_interface.account.content.intelligence.Settings;

import java.util.ArrayList;
import java.util.Map;

public class Game extends Thread {
    private static ArrayList<Turn> turns;
    private static boolean lock;

    private Game() {
        super(() -> {
            lock = true;
            turns.forEach(Game::playTurn);
            lock = false;
        });
    }

    public static void play(ArrayList<Turn> turns) {
        if (lock) return;
        initSnakes();
        Game.turns = turns;
        new Game().start();
    }

    private static void playTurn(Turn turn) {
        turn.getBody().entrySet().forEach(Game::playStep);
    }

    private static void playStep(Map.Entry<Integer, ArrayList<Block>> step) {
        Platform.runLater(() -> Snake.setSnakeBody(step.getKey(), step.getValue()));
        GameSpeedChanger.sleepForNextStep();
    }

    private static void initSnakes() {
        Snake.getFirst().setColor(SlotsBox.mySlot.getCurrentPlayer().getSnakePlayer().getColor());
        Snake.getSecond().setColor(SlotsBox.getEnemySlots().get(0).getCurrentPlayer().getSnakePlayer().getColor());
        Snake.getThird().setColor(SlotsBox.getEnemySlots().get(1).getCurrentPlayer().getSnakePlayer().getColor());
        Snake.getFourth().setColor(SlotsBox.getEnemySlots().get(2).getCurrentPlayer().getSnakePlayer().getColor());
    }

}
