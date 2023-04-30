package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class ArthropodWidget extends JPanel {
    /**
     * Конструтор.
     */
    public ArthropodWidget() {
        setOpaque(false);
        setPreferredSize(getDimension());
    }

    /**
     * Получить изображение виджета.
     * @return изображение виджета.
     */
    protected abstract BufferedImage getImage();

    /**
     * Получить размеры виджета.
     * @return размеры виджета.
     */
    protected abstract Dimension getDimension();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(getImage(), 0, 0, null);
    }
}
