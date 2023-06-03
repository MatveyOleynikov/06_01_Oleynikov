package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import Model.Insect;
import Model.Spider;

import javax.imageio.ImageIO;

import static java.lang.Thread.sleep;

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
     * Получить информацию
     * @return информация
     */
    private BufferedImage getInformation() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(ImageUtils.IMAGE_PATH + "information.png"));
            image = ImageUtils.resizeImage(image, 45, 60);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


    /**
     * Получить информацию
     * @return информация
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
        g.drawImage(getInformation(), 65, 10, null);
        g.setColor(Color.green);
        g.drawString(Integer.toString(spider.getPositiveChange()), 80, 25);
        g.setColor(Color.red);
        g.drawString(Integer.toString(spider.getNegativeChange()), 80, 45);
        g.setColor(Color.white);
        Point textCoordinate = textCoordinate();
        g.drawString(Integer.toString(spider.healthPoints()), textCoordinate.x, textCoordinate.y);
    }
}
