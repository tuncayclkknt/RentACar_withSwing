package View;

import javax.swing.*;
import java.awt.*;

public interface IResizeImage {

    static ImageIcon resizeImage(String imagePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);

    }
}
