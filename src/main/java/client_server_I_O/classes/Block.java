package client_server_I_O.classes;

import java.io.Serializable;

public class Block implements Serializable {
    static final long serialVersionUID = 4566843898265039363L;

    private int x,y;

    public Block() {}

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}
