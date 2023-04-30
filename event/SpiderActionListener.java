package event;

import java.util.EventListener;

public interface SpiderActionListener extends EventListener{
    void SpiderMoved(SpiderActionEvent event);

    void SpiderDied(SpiderActionEvent event);
}
