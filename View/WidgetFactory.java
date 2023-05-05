package View;

import Model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика виджетов
 */
public class WidgetFactory {
    /**
     * зоны
     */
    private final Map<Zone, ZoneWidget> zones = new HashMap<>();

    /**
     * Получить зоны {@link WidgetFactory#zones}.
     * @return зоны.
     */
    public Map<Zone, ZoneWidget> getZones(){
        return zones;
    }

    /**
     * членистоногие
     */
    private final Map<Arthropod, ArthropodWidget> arthropods = new HashMap<>();

    /**
     * Получить членистоногих {@link WidgetFactory#arthropods}.
     * @return членистоногие.
     */
    public Map<Arthropod, ArthropodWidget> getArthropods(){
        return arthropods;
    }

    /**
     * Создать виджет зоны
     * @param zone зона
     * @return виджет зоны
     */
    public ZoneWidget createZoneWidget(Zone zone) {
        if(zones.containsKey(zone)) return zones.get(zone);

        ZoneWidget zoneWidget = new ZoneWidget();

        Arthropod arthropod = zone.getArthropod();
        if(arthropod != null) {
            ArthropodWidget arthropodWidget = createArthropodWidget(arthropod);
            zoneWidget.setArthropodWidget(arthropodWidget);
        }

        zones.put(zone, zoneWidget);
        return zoneWidget;
    }

    /**
     * создать виджет членистоногого
     * @param arthropod членистоногое
     * @return виджет членистоногого
     */
    public ArthropodWidget createArthropodWidget(Arthropod arthropod) {
        ArthropodWidget createdWidget = null;

        if(arthropod instanceof SmartSpider) {
            createdWidget = new SmartSpiderWidget((SmartSpider) arthropod);
        } else if(arthropod instanceof Spider) {
            createdWidget = new SpiderWidget((Spider) arthropod);
        } else if(arthropod instanceof Insect) {
            createdWidget = new InsectWidget((Insect) arthropod);
        } else {
            throw new IllegalArgumentException();
        }

        arthropods.put(arthropod, createdWidget);
        return createdWidget;
    }
}
