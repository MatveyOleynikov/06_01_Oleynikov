package View;

import javax.swing.*;
import java.awt.*;

public class StepsWidget extends JPanel {
    private int steps = 0;

    public void setSteps(int steps){
        this.steps = steps;

        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 20);
    }

    /**
     * Нарисовать компонент
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawString("Прошло шагов с начала игры: " + steps, 10, 12);
    }
}
