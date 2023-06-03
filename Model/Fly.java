package Model;

import event.InsectActionEvent;
import event.InsectActionListener;

/**
 * Муха
 */
public class Fly extends Insect{
    /**
     * конструктор с контроллером
     */
    public Fly(InsectActionListener insectController, Zone zone){
        this.insectController = insectController;
        zone.putArthropod(this);
        appear();
        _size = 5;
    }

    /**
     * конструктор без контроллера
     */
    public Fly(){
        _size = 5;
    }

    /**
     * вероятность появления мухи
     */
    private static final double probability_appearance_insect = 0.04;

    /**
     * вероятность исчезновение насекомого
     */
    private static final double probability_disappearance_insect = 0.1;

    /**
     * Вероятное появление мухи в зоне
     * @param zone зона
     */
    public static void probableAppearanceInZone(Zone zone, InsectActionListener insectController){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Fly fly = new Fly(insectController, zone);
        }
    }

    /**
     * Вероятное исчезновение мухи
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
