package View;

import Model.Insect;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InsectWidget extends ArthropodWidget{
    private Insect insect;

    public InsectWidget(Insect insect){
        this.insect = insect;
    }

    private File getImageFile() {
        File file = new File(ImageUtils.IMAGE_PATH + "insect.png");
        return file;
    }

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

    @Override
    protected Dimension getDimension() {
        return new Dimension(110, 110);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(getImage(), 10, 10, null);
        //g.dr
        g.drawImage(getImage(), 35, 35, 40, 40, null);
        //g.drawImage(getImage(), 30, 80, null);
    }
}
