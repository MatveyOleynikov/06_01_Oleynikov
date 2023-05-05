package View;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Утилита для изображений
 */
public class ImageUtils {
    /**
     * Привести изображение к размеру
     * @param img начальное изображение
     * @param width ширина
     * @param height высота
     * @return изображение
     */
    public static BufferedImage resizeImage(BufferedImage img, Integer width, Integer height) {
        Image tmpImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(tmpImg, 0, 0, null);
        g.dispose();

        return bufferedImage;
    }

    /**
     * Путь до папки с изображениями
     */
    public static final String IMAGE_PATH = "resources//";

    /**
     * Цвет фона
     */
    public static final Color BACKGROUND_COLOR = new Color(85, 85, 85);
}
