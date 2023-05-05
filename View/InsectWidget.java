package View;

import Model.Insect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Виджет насекомого {@link Insect}.
 */
public class InsectWidget extends ArthropodWidget{
    /**
     * насекомое
     */
    private final Insect insect;

    /**
     * Конструктор
     * @param insect насекомое
     */
    public InsectWidget(Insect insect){
        this.insect = insect;
    }

    /**
     * Получить файл изображения
     * @return файл
     */
    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "insect.png");
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
     * Получить размеры виджета
     * @return размеры виджета
     */
    @Override
    protected Dimension getDimension() {
        return new Dimension(110, 110);
    }

    /**
     * Нарисовать компонент
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getImage(), 35, 35, 40, 40, null);
    }
}
