package user_interface.account.battlefield;

import client_server_I_O.classes.Block;
import client_server_I_O.classes.GameEnd;
import client_server_I_O.classes.Turn;
import javafx.application.Platform;
import messages.MessageType;
import messages.Messenger;
import user_interface.account.User;
import user_interface.account.battlefield.menu.GameSpeedChanger;
import user_interface.account.battlefield.menu.ResultPane;
import user_interface.account.battlefield.snake.Snake;
import user_interface.account.content.fight.slots.Slot;
import user_interface.account.content.fight.slots.SlotsBox;
import user_interface.account.content.intelligence.Settings;

import java.util.*;

public class Game extends Thread {
    private static ArrayList<Turn> turns;
    private static boolean lock;
    private static boolean isPlayed;
    private static boolean alreadyFinished;

    private Game() {
        super(() -> {
            lock = true;
            if (!isPlayed) {
                lock = false;
                return;
            }
            turns.forEach(Game::playTurn);
            lock = false;
        });
    }

    public static void play(ArrayList<Turn> turns) {
        if (lock) return;
        isPlayed = true;
        alreadyFinished = false;
        initSnakes();
        Game.turns = turns;
        new Game().start();
    }

    private static void playTurn(Turn turn) {
        if (!isPlayed && !alreadyFinished) {
            earlyEndGame();
            return;
        }
        turn.getBody().entrySet().forEach(Game::playStep);
        if (turn.getGameEnd() != null) endGame(turn.getGameEnd());
    }

    private static void playStep(Map.Entry<Integer, ArrayList<Block>> step) {
        if (!isPlayed && !alreadyFinished) {
            earlyEndGame();
            return;
        }
        Platform.runLater(() -> Snake.setSnakeBody(step.getKey(), step.getValue()));
        GameSpeedChanger.sleepForNextStep();
    }

    private static void initSnakes() {
        Snake.getFirst().setColor(SlotsBox.mySlot.getCurrentPlayer().getSnakePlayer().getColor());
        Snake.getSecond().setColor(SlotsBox.getEnemySlots().get(0).getCurrentPlayer().getSnakePlayer().getColor());
        Snake.getThird().setColor(SlotsBox.getEnemySlots().get(1).getCurrentPlayer().getSnakePlayer().getColor());
        Snake.getFourth().setColor(SlotsBox.getEnemySlots().get(2).getCurrentPlayer().getSnakePlayer().getColor());
    }

    private static void endGame(GameEnd gameEnd) {
        Cells.clear();

        Map<User, Integer> playersRatings = new LinkedHashMap<>();
        ArrayList<Integer> newRatings = gameEnd.getNewRatings();

        playersRatings.put(SlotsBox.mySlot.getCurrentPlayer(), newRatings.get(0));

        for (int i = 0; i < 3; i++) {
            User player = SlotsBox.getPlayer(i);
            if (player == null) break;
            playersRatings.put(SlotsBox.getPlayer(i), newRatings.get(i + 1));
        }

        ResultPane.setNewPlayersRatings(playersRatings);
        ResultPane.setWinner(gameEnd.getSnakeWinner());
        ResultPane.show();

        ResultPane.updateRatings();
        isPlayed = false;
    }

    private static void earlyEndGame() {
        isPlayed = false;
        alreadyFinished = true;
        ResultPane.updateRatings();
        Platform.runLater(() -> Messenger.showMessage(MessageType.GAME_EARLY_FINISHED));
    }

    public static void finishGame() {
        isPlayed = false;
    }

}
