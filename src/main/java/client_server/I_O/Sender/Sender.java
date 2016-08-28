package client_server.I_O.Sender;

import client_server.I_O.User;

public class Sender implements UserSender {

    public static final Sender instance = new Sender();

    private Sender() {}

    @Override
    public void sendUser(User user) {

    }

}
