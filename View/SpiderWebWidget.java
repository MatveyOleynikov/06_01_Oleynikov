package View;

import Model.*;
import event.InsectActionEvent;
import event.InsectActionListener;
import event.SpiderActionEvent;
import event.SpiderActionListener;

import javax.swing.*;

public class SpiderWebWidget extends JPanel {
    private final SpiderWeb spiderWeb;
    private final WidgetFactory widgetFactory;

    public SpiderWebWidget(Nature nature, SpiderWeb spiderWeb, WidgetFactory widgetFactory) {
        nature.setInsectController(new InsectController());
        nature.setSpiderController(new SpiderController());
        this.spiderWeb = spiderWeb;
        this.widgetFactory = widgetFactory;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        fillField();
    }

    private void fillField() {
        for (int i = 0; i < spiderWeb.height(); ++i) {
            JPanel row = createRow(i);
            add(row);
        }
    }

    private JPanel createRow(int rowIndex) {
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));

        for(int i = 0; i < spiderWeb.width(); ++i) {
            Zone zone = spiderWeb.zone(rowIndex, i);
            ZoneWidget zoneWidget = widgetFactory.createZoneWidget(zone);

            row.add(zoneWidget);
        }
        return row;
    }

    public class InsectController implements InsectActionListener {
        @Override
        public void insectAppearance(InsectActionEvent event) {
            InsectWidget insectWidget = (InsectWidget) widgetFactory.createArthropodWidget(event.getZone().getArthropod());
            ZoneWidget zoneWidget = widgetFactory.getZones().get(event.getZone());
            zoneWidget.setArthropodWidget(insectWidget);
        }

        @Override
        public void insectDisappearance(InsectActionEvent event) {
            //todo: удалить инсекта из мапы
            ZoneWidget zoneWidget = widgetFactory.getZones().get(event.getZone());
            zoneWidget.removeArthropodWidget();
        }
    }

    public class SpiderController implements SpiderActionListener {
        @Override
        public void SpiderMoved(SpiderActionEvent event) {
            ZoneWidget zone = widgetFactory.getZones().get(event.getZone());
            zone.removeArthropodWidget();
            ZoneWidget nextZone = widgetFactory.getZones().get(event.getNextZone());
            nextZone.setArthropodWidget(widgetFactory.getArthropods().get(event.getSpider()));
        }

        @Override
        public void SpiderDied(SpiderActionEvent event) {
            if (!(event.getSpider() instanceof SmartSpider)){
                System. exit(0);
            }
            Zone zn = event.getZone();
            ZoneWidget zone = widgetFactory.getZones().get(event.getZone());
            zone.removeArthropodWidget();
        }
    }
}
