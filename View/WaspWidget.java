package View;

import Model.Insect;
import Model.Wasp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WaspWidget extends InsectWidget {
    /**
     * Конструктор
     * @param wasp оса
     */
    public WaspWidget(Wasp wasp) {
        super(wasp);
    }

    /**
     * Получить файл изображения
     * @return файл
     */
    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "wasp.png");
        return file;
    }

    /**
     * Получить изображение
     * @return изображение
     */
    @Override
    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getImageFile());
            image = ImageUtils.resizeImage(image, 70, 70);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Нарисовать компонент
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(getImage(), 35, 35, 70, 70, null);
    }
}
