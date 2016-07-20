package main;

import events.KeyboardEvents;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import rendering.snake.Snake;

public class Timer {
    private static Timeline timeline;

    private static Snake snake = new Snake();

    static {
        int interval = 500;
        timeline = new Timeline(new KeyFrame(Duration.millis(interval), action -> step()));
        timeline.setCycleCount(Animation.INDEFINITE);
        KeyboardEvents.snake = snake;
    }

    private static void step() {
        snake.render();
    }

    public static void start() {

//        new Thread(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//            }
//            snake.increase();
//        }).start();

        timeline.play();
    }
    public static void pause() {
        timeline.pause();
    }
    public static void stop() {
        timeline.stop();
    }

}
