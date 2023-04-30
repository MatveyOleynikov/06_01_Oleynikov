package event;

import Model.Insect;
import Model.Zone;

import java.util.EventObject;

public class InsectActionEvent extends EventObject {
    private Insect insect;
    private Zone zone;

    public Zone getZone() {
        return zone;
    }

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public InsectActionEvent(Object source, Insect insect, Zone zone) {
        super(source);
        this.zone = zone;
        this.insect = insect;
    }
}
