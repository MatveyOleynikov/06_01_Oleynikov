package event;

import Model.Spider;
import Model.Zone;

import java.util.EventObject;

public class SpiderActionEvent extends EventObject {
    private Spider spider;

    private Zone zone;

    private Zone nextZone;

    public SpiderActionEvent(Object source, Spider spider, Zone zone) {
        super(source);
        this.spider = spider;
        this.zone = zone;
    }

    public SpiderActionEvent(Object source, Spider spider, Zone zone, Zone nextZone) {
        super(source);
        this.spider = spider;
        this.zone = zone;
        this.nextZone = nextZone;
    }

    public Zone getZone() {
        return zone;
    }

    public Zone getNextZone() {
        return nextZone;
    }

    public Spider getSpider() {
        return spider;
    }
}
