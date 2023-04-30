package event;

import Model.Insect;

import java.util.EventListener;

public interface InsectActionListener extends EventListener {
    void insectAppearance(InsectActionEvent event);

    void insectDisappearance(InsectActionEvent event);
}
