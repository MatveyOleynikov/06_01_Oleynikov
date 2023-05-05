package View;

import Model.Zone;

import javax.swing.*;
import java.awt.*;

/**
 * Виджет зоны {@link Zone}.
 */
public class ZoneWidget extends JPanel {
    /**
     * Виджет членистоногого
     */
    private ArthropodWidget arthropodWidget;


    /**
     * Размер зоны
     */
    private static final int ZONE_SIZE = 120;

    /**
     * Конструктор
     */
    public ZoneWidget() {
        setPreferredSize(new Dimension(ZONE_SIZE, ZONE_SIZE));

        setBackground(ImageUtils.BACKGROUND_COLOR);
    }

    /**
     * Установить виджет членистоногого {@link ZoneWidget#arthropodWidget}
     * @param arthropodWidget виджет членистоногого
     */
    public void setArthropodWidget(ArthropodWidget arthropodWidget) {
        if (this.arthropodWidget != null){
            remove(this.arthropodWidget);
        }
        this.arthropodWidget = arthropodWidget;
        add(arthropodWidget);
        revalidate();
        repaint();
    }

    /**
     * Снять виджет насекомого {@link ZoneWidget#arthropodWidget}
     */
    public void removeArthropodWidget() {
        if (arthropodWidget != null){
            remove(arthropodWidget);
        }
        arthropodWidget = null;
        repaint();
    }

    /**
     * Нарисовать компонент
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawLine(0, ZONE_SIZE / 2, ZONE_SIZE, ZONE_SIZE / 2);
        g.drawLine(ZONE_SIZE / 2, 0, ZONE_SIZE / 2, ZONE_SIZE);
    }
}
