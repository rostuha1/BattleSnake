package client_server_I_O;

import client_server_I_O.classes.Snake;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import user_interface.account.SnakePlayer;
import user_interface.account.User;
import user_interface.account.content.intelligence.Role;
import user_interface.account.content.intelligence.card_elements.Card;
import user_interface.account.content.intelligence.card_elements.CardElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class Adapter {

    public static User getUser(client_server_I_O.classes.User serverUser) {

        if (serverUser == null) return null;

        User accUser = new User();
        accUser.setLogin(serverUser.getLogin());
        accUser.setPassword(serverUser.getPassword());

        System.out.println(serverUser.getSnake().getName());
        System.out.println(serverUser.getSnake().getAbout());

        Snake servSnake = serverUser.getSnake();
        accUser.setCards(getCards(servSnake.getCards()));
        accUser.setSnakePlayer(getSnakePlayer(servSnake));

        return accUser;
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

    public static byte[] getBytesFromImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new URL(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    public static CardElement getCardElement(client_server_I_O.classes.CardElement serverCardElement) {
        return new CardElement(Role.getRoleByKey(serverCardElement.getRole()));
    }

    public static CardElement[][] getCardElements(client_server_I_O.classes.CardElement[][] serverCardElements) {
        CardElement[][] resCardElements = new CardElement[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                resCardElements[i][j] = getCardElement(serverCardElements[i][j]);
            }
        }

        return resCardElements;
    }

    public static Card getCard(client_server_I_O.classes.Card serverCard) {
        return new Card(getCardElements(serverCard.getElements()));
    }

    public static Card[][] getCards(client_server_I_O.classes.Card[][] serverCards) {
        Card[][] resCards = new Card[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resCards[i][j] = getCard(serverCards[i][j]);
            }
        }

        return resCards;
    }

    public static SnakePlayer getSnakePlayer(Snake serverSnake) {
        SnakePlayer resSnakePlayer = new SnakePlayer(false);
        resSnakePlayer.setName(serverSnake.getName());
        resSnakePlayer.setRating(serverSnake.getRating());
        resSnakePlayer.setAbout(serverSnake.getAbout());
        resSnakePlayer.setColor(Color.valueOf(serverSnake.getColor()));
        resSnakePlayer.setAvatar(getImageFromBytes(serverSnake.getAvatar().getImageBytes()));
        return resSnakePlayer;
    }

}
