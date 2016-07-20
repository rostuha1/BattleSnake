package menu;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import main.Main;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class MenuBox extends Pane {
    private static SubMenu subMenu;

    public MenuBox() {}

    public MenuBox(SubMenu subMenu) {
        init(subMenu);
    }

    public void init(SubMenu subMenu)  {
        MenuBox.subMenu = subMenu;

        setVisible(false);
        Rectangle bg = new Rectangle(Main.getRoot().getWidth(), Main.getRoot().getHeight());
        Image image = new Image("file:\\" + Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\background.jpg");
        ImagePattern pattern = new ImagePattern(image);
        bg.setFill(pattern);
        bg.setOpacity(0.9);
        getChildren().addAll(bg, subMenu);
    }

    public void setSubMenu(SubMenu subMenu) {
        getChildren().remove(MenuBox.subMenu);
        MenuBox.subMenu = subMenu;
        getChildren().add(MenuBox.subMenu);
    }
}