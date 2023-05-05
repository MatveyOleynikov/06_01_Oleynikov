package event;

import Model.Insect;
import Model.Spider;

import java.util.EventListener;

/**
 * Интерфейс слушателя собтыия класса паука {@link Spider}.
 */
public interface SpiderActionListener extends EventListener{
    /**
     * Паук переместился
     * @param event событие паука
     */
    void SpiderMoved(SpiderActionEvent event);

    /**
     * Паук умер
     * @param event событие паука
     */
    void SpiderDied(SpiderActionEvent event);
}
