package event;

import Model.Insect;
import Model.Spider;
import Model.Zone;

import java.util.EventObject;

/**
 * Объект собтыия класса паука {@link Spider}.
 */
public class SpiderActionEvent extends EventObject {
    /**
     * паук
     */
    private Spider spider;

    /**
     * зона
     */
    private Zone zone;

    /**
     * следующая зона
     */
    private Zone nextZone;

    /**
     * Конструктор события смерти паука
     * @param source слушатель
     * @param spider паук
     * @param zone зона
     */
    public SpiderActionEvent(Object source, Spider spider, Zone zone) {
        super(source);
        this.spider = spider;
        this.zone = zone;
    }

    /**
     * Конструктор события перемещения паука
     * @param source слушатель
     * @param spider паук
     * @param zone зона
     * @param nextZone новая зона
     */
    public SpiderActionEvent(Object source, Spider spider, Zone zone, Zone nextZone) {
        super(source);
        this.spider = spider;
        this.zone = zone;
        this.nextZone = nextZone;
    }

    /**
     * Получить зону {@link SpiderActionEvent#zone}.
     * @return зона.
     */
    public Zone getZone() {
        return zone;
    }

    /**
     * Получить следующую зону {@link SpiderActionEvent#nextZone}.
     * @return следующая зона.
     */
    public Zone getNextZone() {
        return nextZone;
    }

    /**
     * Получить паука {@link SpiderActionEvent#spider}.
     * @return паук.
     */
    public Spider getSpider() {
        return spider;
    }
}
