package client_server_I_O;

import client_server_I_O.classes.Avatar;
import client_server_I_O.classes.Snake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;

public class Adapter {

    public static User getAccountUser(client_server_I_O.classes.User serverUser) {

        if (serverUser == null) return null;

        User accountUser = new User();
        accountUser.setLogin(serverUser.getLogin());
        accountUser.setPassword(serverUser.getPassword());

        Snake serverSnake = serverUser.getSnake();
        accountUser.setCards(getAccountCards(serverSnake.getCards()));
        accountUser.setSnakePlayer(getAccountSnakePlayer(serverSnake));

        return accountUser;
    }

    private static Image getImageFromBytes(byte[] bytes) {
        try {
            return SwingFXUtils.toFXImage(ImageIO.read(new ByteArrayInputStream(bytes)), null);
        } catch (IOException ignored) {
        }
        return null;
    }

    private static byte[] getBytesFromImage(Image image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "jpg", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    private static byte[] getBytesFromImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new URL(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }

    private static CardElement getAccountCardElement(client_server_I_O.classes.CardElement serverCardElement) {
        return new CardElement(Role.getRoleByKey(serverCardElement.getRole()));
    }

    private static CardElement[][] getAccountCardElements(client_server_I_O.classes.CardElement[][] serverCardElements) {
        CardElement[][] resCardElements = new CardElement[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                resCardElements[i][j] = getAccountCardElement(serverCardElements[i][j]);
            }
        }

        return resCardElements;
    }

    private static Card getAccountCard(client_server_I_O.classes.Card serverCard) {
        return new Card(getAccountCardElements(serverCard.getElements()));
    }

    private static Card[][] getAccountCards(client_server_I_O.classes.Card[][] serverCards) {
        Card[][] resCards = new Card[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resCards[i][j] = getAccountCard(serverCards[i][j]);
            }
        }

        return resCards;
    }

    private static SnakePlayer getAccountSnakePlayer(Snake serverSnake) {
        SnakePlayer resSnakePlayer = new SnakePlayer(false);
        resSnakePlayer.setName(serverSnake.getName());
        resSnakePlayer.setRating(serverSnake.getRating());
        resSnakePlayer.setAbout(serverSnake.getAbout());
        resSnakePlayer.setColor(Color.valueOf(serverSnake.getColor()));
        resSnakePlayer.setAvatar(getImageFromBytes(serverSnake.getAvatar().getImageBytes()));
        return resSnakePlayer;
    }

    public static client_server_I_O.classes.User getServerUser(User accountUser) {

        if (accountUser == null) return null;

        client_server_I_O.classes.User serverUser = new client_server_I_O.classes.User();
        serverUser.setLogin(accountUser.getLogin());
        serverUser.setPassword(accountUser.getPassword());

        Snake snake = getServerSnake(accountUser);
        serverUser.setSnake(snake);

        return serverUser;
    }

    private static Snake getServerSnake(User accountUser) {
        Snake snake = new Snake();
        snake.setAbout(accountUser.getSnakePlayer().getAbout());
        Avatar avatar = new Avatar();
        avatar.setImageBytes(getBytesFromImage(accountUser.getSnakePlayer().getAvatar()));
        snake.setAvatar(avatar);
        snake.setCards(getServerCards(accountUser.getCards()));
        snake.setColor(accountUser.getSnakePlayer().getColor().toString());
        snake.setName(accountUser.getSnakePlayer().getName());
        snake.setRating(accountUser.getSnakePlayer().getRating());

        return snake;
    }

    private static client_server_I_O.classes.Card[][] getServerCards(Card[][] accountCards) {
        client_server_I_O.classes.Card[][] serverCards = new client_server_I_O.classes.Card[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                serverCards[i][j] = getServerCard(accountCards[i][j]);
            }
        }

        return serverCards;
    }

    private static client_server_I_O.classes.Card getServerCard(Card accountCard) {
        client_server_I_O.classes.Card serverCard = new client_server_I_O.classes.Card();
        serverCard.setElements(getServerCardElements(accountCard.getElements()));
        return serverCard;
    }

    private static client_server_I_O.classes.CardElement[][] getServerCardElements(CardElement[][] elements) {
        client_server_I_O.classes.CardElement[][] serverCardElements = new client_server_I_O.classes.CardElement[7][7];

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                serverCardElements[i][j] = getServerCardElement(elements[i][j]);
            }
        }

        return serverCardElements;
    }

    private static client_server_I_O.classes.CardElement getServerCardElement(CardElement cardElement) {
        client_server_I_O.classes.CardElement serverCardElement = new client_server_I_O.classes.CardElement();
        serverCardElement.setRole(cardElement.getRole().key);
        return serverCardElement;
    }

    public static ObservableList<User> getUsersList(ArrayList<client_server_I_O.classes.User> list) {
        ArrayList<User> resultList = new ArrayList<>();
        list.forEach(el -> resultList.add(Adapter.getAccountUser(el)));
        return FXCollections.observableArrayList(resultList);
    }

}
