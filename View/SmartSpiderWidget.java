package View;

import Model.Insect;
import Model.SmartSpider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Виджет паука соперника {@link SmartSpider}.
 */
public class SmartSpiderWidget extends SpiderWidget{
    /**
     * Конструктор
     * @param smartSpider паутина
     */
    public SmartSpiderWidget(SmartSpider smartSpider){
        super(smartSpider);
    }

    /**
     * Получить файл изображения
     * @return файл
     */
    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "smartSpider.png");
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
            image = ImageUtils.resizeImage(image, 110, 110);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Координата текста
     * @return точка
     */
    @Override
    protected Point textCoordinate(){
        return new Point(48, 88);
    }
}
