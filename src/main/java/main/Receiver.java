package main;

import client_server_I_O.classes.Block;
import client_server_I_O.classes.GameEnd;
import client_server_I_O.classes.Turn;

import java.util.ArrayList;
import java.util.HashMap;

public class Receiver {

    public static ArrayList<Turn> getGameResult(String first, String second, String third, String fourth) {

        ArrayList<Turn> list = new ArrayList<>();

        Turn t1 = new Turn();
        t1.setBody(new HashMap<Integer, ArrayList<Block>>() {
            {
                put(0, getSnakeBody1());
                put(1, getSnakeBody2());
                put(2, getSnakeBody3());
                put(3, getSnakeBody4());
            }
        });

        Turn t2 = new Turn();
        t2.setBody(new HashMap<Integer, ArrayList<Block>>() {
            {
                put(0, getSnakeBody11());
                put(1, getSnakeBody22());
                put(2, getSnakeBody33());
                put(3, getSnakeBody44());
            }
        });

        Turn t3 = new Turn();
        t3.setBody(new HashMap<Integer, ArrayList<Block>>() {
            {
                put(0, getSnakeBody111());
                put(1, getSnakeBody222());
                put(2, getSnakeBody333());
                put(3, getSnakeBody444());
            }
        });

        t3.setGameEnd(getGameEnd());

        list.add(t1);
        list.add(t2);
        list.add(t3);

        return list;

    }

    private static ArrayList<Block> getSnakeBody1() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(0, 0));
        blocks.add(new Block(1, 0));
        blocks.add(new Block(2, 0));
        blocks.add(new Block(3, 0));
        blocks.add(new Block(4, 0));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody2() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(0, 2));
        blocks.add(new Block(1, 2));
        blocks.add(new Block(2, 2));
        blocks.add(new Block(3, 2));
        blocks.add(new Block(4, 2));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody3() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(0, 4));
        blocks.add(new Block(1, 4));
        blocks.add(new Block(2, 4));
        blocks.add(new Block(3, 4));
        blocks.add(new Block(4, 4));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody4() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(0, 6));
        blocks.add(new Block(1, 6));
        blocks.add(new Block(2, 6));
        blocks.add(new Block(3, 6));
        blocks.add(new Block(4, 6));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody11() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 0));
        blocks.add(new Block(2, 0));
        blocks.add(new Block(3, 0));
        blocks.add(new Block(4, 0));
        blocks.add(new Block(5, 0));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody22() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 2));
        blocks.add(new Block(2, 2));
        blocks.add(new Block(3, 2));
        blocks.add(new Block(4, 2));
        blocks.add(new Block(5, 2));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody33() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 4));
        blocks.add(new Block(2, 4));
        blocks.add(new Block(3, 4));
        blocks.add(new Block(4, 4));
        blocks.add(new Block(5, 4));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody44() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 6));
        blocks.add(new Block(2, 6));
        blocks.add(new Block(3, 6));
        blocks.add(new Block(4, 6));
        blocks.add(new Block(5, 6));

        return blocks;
    }

    private static ArrayList<Block> getSnakeBody111() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 0));
        blocks.add(new Block(3, 0));
        blocks.add(new Block(4, 0));
        blocks.add(new Block(5, 0));
        blocks.add(new Block(6, 0));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody222() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 2));
        blocks.add(new Block(3, 2));
        blocks.add(new Block(4, 2));
        blocks.add(new Block(5, 2));
        blocks.add(new Block(6, 2));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody333() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 4));
        blocks.add(new Block(3, 4));
        blocks.add(new Block(4, 4));
        blocks.add(new Block(5, 4));
        blocks.add(new Block(6, 4));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody444() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 6));
        blocks.add(new Block(3, 6));
        blocks.add(new Block(4, 6));
        blocks.add(new Block(5, 6));
        blocks.add(new Block(6, 6));

        return blocks;

    }

    private static GameEnd getGameEnd() {
        GameEnd gameEnd = new GameEnd();
        gameEnd.setNewRatings(new ArrayList<Integer>(4) {
            {
                add(1010);
                add(995);
                add(995);
                add(995);
            }
        });

        gameEnd.setSnakeWinner(0);

        return gameEnd;
    }

}