package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Model.Insect;
import Model.Spider;

import javax.imageio.ImageIO;

/**
 * Виджет паука {@link Spider}.
 */
public class SpiderWidget extends ArthropodWidget{
    /**
     * паук
     */
    protected final Spider spider;

    /**
     * Конструктор
     * @param spider
     */
    public SpiderWidget(Spider spider) {
        super();
        this.spider = spider;
    }

    /**
     * Получить файл изображения
     * @return файл
     */
    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "spider.png");
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
     * Получить размеры виджета
     * @return размеры виджета
     */
    @Override
    protected Dimension getDimension() {
        return new Dimension(110, 110);
    }

    /**
     * Координата текста
     * @return точка
     */
    protected Point textCoordinate(){
        return new Point(48, 38);
    }

    /**
     * Нарисовать компонент
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getImage(), 0, 0, null);
        g.setColor(Color.white);
        Point textCoordinate = textCoordinate();
        g.drawString(Integer.toString(spider.healthPoints()), textCoordinate.x, textCoordinate.y);
    }
}
