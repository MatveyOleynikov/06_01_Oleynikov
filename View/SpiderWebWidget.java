package View;

import Model.*;
import event.InsectActionEvent;
import event.InsectActionListener;
import event.SpiderActionEvent;
import event.SpiderActionListener;

import javax.swing.*;

/**
 * Виджет паутины {@link SpiderWeb}.
 */
public class SpiderWebWidget extends JPanel {
    /**
     * паутина
     */
    private final SpiderWeb spiderWeb;

    /**
     * фабрика виджетов
     */
    private final WidgetFactory widgetFactory;

    /**
     * Конструктор
     * @param nature природа
     * @param spiderWeb паутина
     * @param widgetFactory фабрика виджетов
     */
    public SpiderWebWidget(Nature nature, SpiderWeb spiderWeb, WidgetFactory widgetFactory) {
        nature.setInsectController(new InsectController());
        nature.setSpiderController(new SpiderController());
        this.spiderWeb = spiderWeb;
        this.widgetFactory = widgetFactory;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        fillField();
    }

    /**
     * Заполнить поле
     */
    private void fillField() {
        for (int i = 0; i < spiderWeb.height(); ++i) {
            JPanel row = createRow(i);
            add(row);
        }
    }

    /**
     * Создать строку
     * @param rowIndex номер строки
     * @return панель
     */
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

    /**
     * Контроллер насекомого
     */
    public class InsectController implements InsectActionListener {
        /**
         * Насекомое появилось
         * @param event событие насекомого
         */
        @Override
        public void insectAppearance(InsectActionEvent event) {
            InsectWidget insectWidget = (InsectWidget) widgetFactory.createArthropodWidget(event.getZone().getArthropod());
            ZoneWidget zoneWidget = widgetFactory.getZones().get(event.getZone());
            zoneWidget.setArthropodWidget(insectWidget);
        }

        /**
         * Насекомое исчезло
         * @param event событие насекомого
         */
        @Override
        public void insectDisappearance(InsectActionEvent event) {
            ZoneWidget zoneWidget = widgetFactory.getZones().get(event.getZone());
            zoneWidget.removeArthropodWidget();
        }
    }

    /**
     * Контроллер паука
     */
    public class SpiderController implements SpiderActionListener {
        /**
         * Паук перемещён
         * @param event событие паука
         */
        @Override
        public void SpiderMoved(SpiderActionEvent event) {
            ZoneWidget zone = widgetFactory.getZones().get(event.getZone());
            zone.removeArthropodWidget();
            ZoneWidget nextZone = widgetFactory.getZones().get(event.getNextZone());
            nextZone.setArthropodWidget(widgetFactory.getArthropods().get(event.getSpider()));
        }

        /**
         * Паук умер
         * @param event событие паука
         */
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
