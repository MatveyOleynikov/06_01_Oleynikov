package View;

import Model.SmartSpider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SmartSpiderWidget extends SpiderWidget{

    public SmartSpiderWidget(SmartSpider smartSpider){
        super(smartSpider);
    }

    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "smartSpider.png");
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
    protected Point textCoordinate(){
        return new Point(48, 88);
    }
}
