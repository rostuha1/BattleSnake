import client_server_I_O.classes.Avatar;
import client_server_I_O.classes.Snake;
import client_server_I_O.classes.SnakePlayer;
import client_server_I_O.classes.User;
import client_server_I_O.client.Converter;
import client_server_I_O.client.Sender;
import client_server_I_O.server.Receiver;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import user_interface.account.content.intelligence.Settings;
import user_interface.account.content.intelligence.card_elements.Card;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Client_Server_tests {

    private final int PORT;
    private String SERVER_IP;

    private ServerSocket serverSocket;
    private boolean isRun;
    private int userId = 10;

    private Logger log = Logger.getLogger(Client_Server_tests.class.getName());

    {
        PORT = 12345;
        SERVER_IP = "127.0.0.1";
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void startServer() {
        isRun = true;
        log.info("_SERVER_started");
        System.out.println();
        new Thread(() -> {
            while (isRun) {
                try {
                    Receiver.receive(serverSocket.accept());
                } catch (Exception e) {
                    log.info("_SERVER_stopped");
                }
            }
        }).start();
    }

    @After
    public void close() {
        try {
            isRun = false;
            if (serverSocket != null && !serverSocket.isClosed()) serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void startClientRequests() {

        try {
            log.info("_CLIENT_starting registration");
            Sender.registration("login", "password");

            log.info("_CLIENT_starting authorization");
            Sender.authorization("login", "password");

            log.info("_CLIENT_sending avatar");
            Avatar avatar = new Avatar();
            avatar.setImageBytes(Converter.getBytesFromFile(Settings.projectPath + "src/main/resources/snake1.png"));
            Sender.sendAvatar(10, avatar);

            log.info("_CLIENT_sending color");
            Sender.sendColor(userId, Color.ALICEBLUE.toString());

            log.info("_CLIENT_sending snake name");
            Sender.sendName(userId, "Big Snake");

            log.info("_CLIENT_sending snake about");
            Sender.sendAbout(userId, "I'm stupid big snake");

            log.info("_CLIENT_sending snake snake");
            Sender.sendSnake(userId, new Snake());

            log.info("_CLIENT_sending snake about");
            Sender.sendCards(userId, new Card[0][]);

            log.info("_CLIENT_sending snakePlayer");
            Sender.sendSnakePlayer(userId, new SnakePlayer());

            log.info("_CLIENT_sending snakePlayer");
            Sender.sendUser(userId, new User());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
