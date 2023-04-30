package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Model.Spider;

import javax.imageio.ImageIO;

public class SpiderWidget extends ArthropodWidget{
    protected Spider spider;

    public SpiderWidget(Spider spider) {
        super();
        this.spider = spider;
    }

    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "spider.png");
        return file;
    }

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

    @Override
    protected Dimension getDimension() {
        return new Dimension(110, 110);
    }

    protected Point textCoordinate(){
        return new Point(48, 38);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getImage(), 0, 0, null);
        g.setColor(Color.white);
        Point textCoordinate = textCoordinate();
        g.drawString(Integer.toString(spider.healthPoints()), textCoordinate.x, textCoordinate.y);
    }
}
