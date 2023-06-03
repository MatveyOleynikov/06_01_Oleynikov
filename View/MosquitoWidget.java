package View;

import Model.Insect;
import Model.Mosquito;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MosquitoWidget extends InsectWidget{
    /**
     * Конструктор
     * @param mosquito комар
     */
    public MosquitoWidget(Mosquito mosquito) {
        super(mosquito);
    }

    /**
     * Получить файл изображения
     * @return файл
     */
    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "mosquito.png");
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
            image = ImageUtils.resizeImage(image, 40, 40);
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
        g.drawImage(getImage(), 35, 35, 40, 40, null);
    }
}
