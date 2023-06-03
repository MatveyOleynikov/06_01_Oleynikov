package View;

import Model.Insect;
import Model.SmartSpider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

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
            image = ImageUtils.resizeImage(image, 100, 100);
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
        return new Point(44, 80);
    }

    /**
     * Нарисовать компонент
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(getImage(), 0, 0, null);
        Point textCoordinate = textCoordinate();
        g.drawString(Integer.toString(spider.healthPoints()), textCoordinate.x, textCoordinate.y);
        try {
            sleep(50);
        } catch (InterruptedException e) {

        }
    }
}
