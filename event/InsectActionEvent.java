package event;

import Model.Insect;
import Model.Zone;

import java.util.EventObject;

/**
 * Объект собтыия класса насекомого {@link Insect}.
 */
public class InsectActionEvent extends EventObject {

    /**
     * насекомое
     */
    private Insect insect;

    /**
     * зона
     */
    private Zone zone;

    /**
     * Получить зону {@link InsectActionEvent#zone}.
     * @return зона.
     */
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
