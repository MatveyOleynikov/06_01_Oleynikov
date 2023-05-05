package Model;

import event.SpiderActionEvent;

/**
 * Членистоногое
 */
abstract public class Arthropod {
    /**
     * зона
     */
    Zone _zone;

    /**
     * Получить зону {@link Arthropod#_zone}.
     * @return зона.
     */
    public Zone zone(){
        return _zone;
    }
}
