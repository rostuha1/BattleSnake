package main;

import client_server_I_O.classes.Block;
import client_server_I_O.classes.Turn;

import java.util.ArrayList;
import java.util.HashMap;

public class Receiver {

    public static ArrayList<Turn> getGameResult(String... usersLogins) {

        for (String login : usersLogins) {

        }

        ArrayList<Turn> list = new ArrayList<>();

        Turn t1 = new Turn();
        t1.setBody(new HashMap<Integer, ArrayList<Block>>() {
            {
                put(1, getSnakeBody1());
                put(2, getSnakeBody2());
                put(3, getSnakeBody3());
                put(4, getSnakeBody4());
            }
        });

        Turn t2 = new Turn();
        t2.setBody(new HashMap<Integer, ArrayList<Block>>() {
            {
                put(1, getSnakeBody11());
                put(2, getSnakeBody22());
                put(3, getSnakeBody33());
                put(4, getSnakeBody44());
            }
        });

        Turn t3 = new Turn();
        t3.setBody(new HashMap<Integer, ArrayList<Block>>() {
            {
                put(1, getSnakeBody111());
                put(2, getSnakeBody222());
                put(3, getSnakeBody333());
                put(4, getSnakeBody444());
            }
        });

        list.add(t1);
        list.add(t2);
        list.add(t3);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        list.add(t1);
        list.add(t2);
        list.add(t3);

        return list;

    }

    private static ArrayList<Block> getSnakeBody1() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 1));
        blocks.add(new Block(2, 1));
        blocks.add(new Block(3, 1));
        blocks.add(new Block(4, 1));
        blocks.add(new Block(5, 1));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody2() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 3));
        blocks.add(new Block(2, 3));
        blocks.add(new Block(3, 3));
        blocks.add(new Block(4, 3));
        blocks.add(new Block(5, 3));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody3() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 5));
        blocks.add(new Block(2, 5));
        blocks.add(new Block(3, 5));
        blocks.add(new Block(4, 5));
        blocks.add(new Block(5, 5));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody4() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(1, 7));
        blocks.add(new Block(2, 7));
        blocks.add(new Block(3, 7));
        blocks.add(new Block(4, 7));
        blocks.add(new Block(5, 7));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody11() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 1));
        blocks.add(new Block(3, 1));
        blocks.add(new Block(4, 1));
        blocks.add(new Block(5, 1));
        blocks.add(new Block(6, 1));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody22() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 3));
        blocks.add(new Block(3, 3));
        blocks.add(new Block(4, 3));
        blocks.add(new Block(5, 3));
        blocks.add(new Block(6, 3));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody33() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 5));
        blocks.add(new Block(3, 5));
        blocks.add(new Block(4, 5));
        blocks.add(new Block(5, 5));
        blocks.add(new Block(6, 5));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody44() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(2, 7));
        blocks.add(new Block(3, 7));
        blocks.add(new Block(4, 7));
        blocks.add(new Block(5, 7));
        blocks.add(new Block(6, 7));

        return blocks;

    }

    private static ArrayList<Block> getSnakeBody111() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(3, 1));
        blocks.add(new Block(4, 1));
        blocks.add(new Block(5, 1));
        blocks.add(new Block(6, 1));
        blocks.add(new Block(7, 1));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody222() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(3, 3));
        blocks.add(new Block(4, 3));
        blocks.add(new Block(5, 3));
        blocks.add(new Block(6, 3));
        blocks.add(new Block(7, 3));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody333() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(3, 5));
        blocks.add(new Block(4, 5));
        blocks.add(new Block(5, 5));
        blocks.add(new Block(6, 5));
        blocks.add(new Block(7, 5));

        return blocks;

    }
    private static ArrayList<Block> getSnakeBody444() {
        ArrayList<Block> blocks = new ArrayList<>();

        blocks.add(new Block(3, 7));
        blocks.add(new Block(4, 7));
        blocks.add(new Block(5, 7));
        blocks.add(new Block(6, 7));
        blocks.add(new Block(7, 7));

        return blocks;

    }

}