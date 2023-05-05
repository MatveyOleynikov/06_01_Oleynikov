package event;

import Model.Insect;

import java.util.EventListener;

/**
 * Интерфейс слушателя собтыия класса насекомого {@link Insect}.
 */
public interface InsectActionListener extends EventListener {
    /**
     * Исчезновение насекомого
     * @param event событие насекомого
     */
    void insectAppearance(InsectActionEvent event);

    /**
     * Появление насекомого
     * @param event событие насекомого
     */
    void insectDisappearance(InsectActionEvent event);
}
