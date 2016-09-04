package client_server_I_O;

import client_server_I_O.classes.Avatar;
import client_server_I_O.classes.Snake;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import user_interface.account.SnakePlayer;
import user_interface.account.User;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Adapter {

    public static user_interface.account.User getUser(client_server_I_O.classes.User user) {
        User accUser = new User();
        accUser.setLogin(user.getLogin());
        accUser.setPassword(user.getPassword());

        Snake servSnake = user.getSnake();

        if (servSnake != null) {
            Avatar avatar = servSnake.getAvatar();
            Snake snake = new Snake(); // ToDo
            SnakePlayer snakePlayer = new SnakePlayer();
//            accUser.setCards(servSnake.getCards());
        }




        return null;

    }

    public static Image getImageFromBytes(byte[] bytes) {
        try {
            return SwingFXUtils.toFXImage(ImageIO.read(new ByteArrayInputStream(bytes)), null);
        } catch (IOException ignored) {
        }
        return null;
    }

    public static byte[] getBytesFromImage(Image image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "jpg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

}
