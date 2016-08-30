package client_server_I_O.client;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Converter {

    public static BufferedImage getImageFromString(String stringImage) {
        try {
            return ImageIO.read(new ByteArrayInputStream(stringImage.getBytes()));
        } catch (IOException ignored) {}
        return null;
    }

    public static BufferedImage getImageFromBytes(byte[] bytes) {
        try {
            return ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (IOException ignored) {}
        return null;
    }

    public static Image getFXImageFromBytes(byte[] bytes) {
        try {
            return SwingFXUtils.toFXImage(ImageIO.read(new ByteArrayInputStream(bytes)), null);
        } catch (IOException ignored) {}
        return null;
    }

    public static String getStringFromImage(BufferedImage image) {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", bout);
            bout.flush();
            return new String(bout.toByteArray());
        } catch (IOException ignored) {}
        return null;
    }

    public static BufferedImage getBufferedImageFromFile(){

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            try {
                return ImageIO.read(selectedFile);
            } catch (IOException ex) {
                return null;
            }
        }
        return null;
    }

    public static byte[] getBytesFromFile(String path){
        try {
            return Files.readAllBytes(Paths.get(URI.create(path)));
        } catch (IOException ignored) {}
        return null;
    }

}