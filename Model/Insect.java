package Model;

import View.SpiderWebWidget;
import event.InsectActionEvent;
import event.InsectActionListener;

/**
 * Насекомое
 */
public class Insect extends Arthropod{
    /**
     * размер
     */
    protected int _size = 5;

    /**
     * контроллер насекомого
     */
    protected InsectActionListener insectController;

    /**
     * Конструктор с контроллером
     */
    public Insect(InsectActionListener insectController, Zone zone){
        this.insectController = insectController;
        zone.putArthropod(this);
        appear();
    }

    /**
     * Исчезновение
     */
    protected void disappear(){
        if (insectController != null) {
            InsectActionEvent event = new InsectActionEvent(insectController, this, this.zone());
            insectController.insectDisappearance(event);
        }
    }

    /**
     * Появление
     */

    protected void appear(){
        if (insectController != null) {
            InsectActionEvent event = new InsectActionEvent(insectController, this, this.zone());
            insectController.insectAppearance(event);
        }
    }

    /**
     * Конструктор без контроллера
     */
    public Insect(){
    }

    /**
     * Получить размер {@link Insect#_size}.
     * @return размер.
     */
    public int size(){
        return _size;
    }


    /**
     * вероятность появления насекомого
     */
    private static final double probability_appearance_insect = 0.04;

    /**
     * вероятность исчезновение насекомого
     */
    private static final double probability_disappearance_insect = 0.2;

    /**
     * Вероятное появление насекомого в зоне
     * @param zone зона
     */
    public static void probableAppearanceInZone(Zone zone, InsectActionListener insectController){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Insect insect = new Insect(insectController, zone);
        }
    }

    /**
     * Вероятное исчезновение насекомого
     */
    public void probableDisappearance(){
        if (this.zone() == null){
            throw new IllegalStateException("Насекомое не имеет зоны");
        }
        if (Math.random() < probability_disappearance_insect){
            this.zone().extractArthropod();
            disappear();
        }
    }

    /**
     * насекомое умерло
     */
    public void die(){
        _zone.extractArthropod();
    }

    /**
     * Преобразование к строке
     * @return строка
     */
    @Override
    public String toString() {

        String msg;
        msg = "I" + "(" + size() + ")";;

        return msg;
    }
}