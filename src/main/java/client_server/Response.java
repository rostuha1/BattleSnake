package client_server;

import messages.MessageType;

public interface Response {

    MessageType authorizationResponse(String login, String password);
    MessageType registrationResponse(String login, String password);

}
