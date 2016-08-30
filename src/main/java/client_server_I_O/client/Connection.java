package client_server_I_O.client;

import java.io.IOException;
import java.net.Socket;

public class Connection {

    private static int PORT = 12345;
    private static String SERVER_IP = "127.0.0.1";

    public static Socket create() {
        try {
            return new Socket(SERVER_IP, PORT);
        } catch (Exception e) {
            return null;
        }
    }

    public static void setPORT(int PORT) {
        Connection.PORT = PORT;
    }
    public static void setServerIp(String serverIp) {
        SERVER_IP = serverIp;
    }

}
