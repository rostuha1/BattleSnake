package client_server_I_O;

public enum I_O_KEYS {

    USER((byte) 1),
    CARDS((byte) 2),
    SNAKE_PLAYER((byte) 3),
    AVATAR((byte) 4),
    NAME((byte) 5),
    COLOR((byte) 6),
    ABOUT((byte) 7),
    SNAKE((byte) 8),
    SNAKES_LIST((byte) 9),
    REGISTRATION((byte) 10),
    AUTHORIZATION((byte) 11),
    POST_REGISTRATION((byte) 12),
    POST_AUTHORIZATION((byte) 13),
    SUCCESSFUL_OPERATION((byte) 14);

    public final byte key;

    I_O_KEYS(byte key) {
        this.key = key;
    }

}
