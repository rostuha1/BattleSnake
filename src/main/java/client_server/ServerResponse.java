package client_server;

import client_server.I_O.User;
import messages.MessageType;

import java.util.ArrayList;
import java.util.List;

import static messages.MessageType.*;

public class ServerResponse implements Response {

    private List<User> users = new ArrayList<>();

    {
        users.add(new User("login", "1234"));
        users.add(new User("admin", "1234"));
        users.add(new User("user", "1234"));
        users.add(new User("bla", "1234"));
    }

    @Override
    public MessageType authorizationResponse(String login, String password) {
        for (User user: users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) return SUCCESSFUL_AUTHORIZATION;
        }

        return UNSUCCESSFUL_AUTHORIZATION;
    }

    @Override
    public MessageType registrationResponse(String login, String password) {
        for (User user: users) {
            if (login.equals(user.getLogin())) return UNSUCCESSFUL_REGISTRATION;
        }
        users.add(new User(login, password));
        return SUCCESSFUL_REGISTRATION;
    }
}
