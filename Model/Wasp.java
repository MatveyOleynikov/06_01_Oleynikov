package Model;

import event.InsectActionEvent;
import event.InsectActionListener;

/**
 * Оса
 */
public class Wasp extends Insect{
    /**
     * конструктор с контроллером
     * @param insectController контроллер
     */
    public Wasp(InsectActionListener insectController, Zone zone){
        this.insectController = insectController;
        zone.putArthropod(this);
        appear();
        _size = 20;
    }

    /**
     * конструктор без контроллера
     */
    public Wasp(){
        _size = 20;
    }

    /**
     * вероятность появления осы
     */
    private static final double probability_appearance_insect = 0.01;

    /**
     * вероятность исчезновения осы
     */
    private static final double probability_disappearance_insect = 0.4;

    /**
     * вероятность укуса осой паука
     */
    private static final double probably_bite = 0.3;

    /**
     * сила укуса осой паука
     */
    private static final int power_bite = 3;

    /**
     * Вероятное появление осы в зоне
     * @param zone зона
     */
    public static void probableAppearanceInZone(Zone zone, InsectActionListener insectController){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Wasp wasp = new Wasp(insectController, zone);
        }
    }

    /**
     * Вероятное исчезновение осы
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
     * Вероятный укус осой пока
     * @param spider паук
     */
    public void probableBite(Spider spider){
        if (Math.random() < probably_bite) {
            spider.increaseHealthPoints(-power_bite);
        }
    }
}
