package Model;

import event.InsectActionEvent;
import event.InsectActionListener;

/**
 * Комар
 */
public class Mosquito extends Insect{
    /**
     * Конструктор с контроллером
     * @param insectController контроллер
     */
    public Mosquito(InsectActionListener insectController, Zone zone){
        this.insectController = insectController;
        zone.putArthropod(this);
        appear();
        _size = 2;
    }

    /**
     * Конструктор без контроллера
     */
    public Mosquito(){
        _size = 2;
    }

    /**
     * вероятность появления комара
     */
    private static final double probability_appearance_insect = 0.08;

    /**
     * вероятность исчезновение насекомого
     */
    private static final double probability_disappearance_insect = 0.05;

    /**
     * Вероятное появление комара в зоне
     * @param zone зона
     */
    public static void probableAppearanceInZone(Zone zone, InsectActionListener insectController){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Mosquito mosquito = new Mosquito(insectController, zone);
        }
    }

    /**
     * Вероятное исчезновение комара
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
}
