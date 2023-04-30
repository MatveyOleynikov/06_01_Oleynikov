package View;

import javax.swing.*;
import java.awt.*;

// Виджет для отрисовки зоны и всего, что на ней располагается
public class ZoneWidget extends JPanel {
    private ArthropodWidget arthropodWidget;

    private static final int ZONE_SIZE = 120;

    public ZoneWidget() {
        setPreferredSize(new Dimension(ZONE_SIZE, ZONE_SIZE));

        setBackground(ImageUtils.BACKGROUND_COLOR);
    }

    public void setArthropodWidget(ArthropodWidget arthropodWidget) {
        if (this.arthropodWidget != null){
            remove(this.arthropodWidget);
        }
        this.arthropodWidget = arthropodWidget;
        add(arthropodWidget);
        revalidate();
        repaint();
    }

    public void removeArthropodWidget() {
        if (arthropodWidget != null){
            remove(arthropodWidget);
        }
        arthropodWidget = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawLine(0, ZONE_SIZE / 2, ZONE_SIZE, ZONE_SIZE / 2);
        g.drawLine(ZONE_SIZE / 2, 0, ZONE_SIZE / 2, ZONE_SIZE);
    }
}
