package Model;

import event.InsectActionEvent;
import event.InsectActionListener;

/**
 * Кузнечик
 */
public class Grasshopper extends Insect{
    final SpiderWeb spiderWeb;

    /**
     * конструктор с контроллером
     */
    public Grasshopper(SpiderWeb spiderWeb, InsectActionListener insectController, Zone zone){
        this.insectController = insectController;
        zone.putArthropod(this);
        appear();
        this.spiderWeb = spiderWeb;
        _size = 10;
    }

    /**
     * конструктор без контроллера
     */
    public Grasshopper(SpiderWeb spiderWeb){
        this.spiderWeb = spiderWeb;
        _size = 10;
    }
    /**
     * вероятность появления кузнечика
     */
    private static final double probability_appearance_insect = 0.02;

    /**
     * вероятность исчезновение насекомого
     */
    private static final double probability_disappearance_insect = 0.2;

    /**
     * вероятность прыжка кузнечика в соседнюю зону без паука
     */
    private double probability_jump = 0.8;

    /**
     * Вероятное появление кузнечика в зоне
     * @param zone зона
     */
    public static void probableAppearanceInZone(Zone zone, SpiderWeb spiderWeb, InsectActionListener insectController){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Grasshopper grasshopper = new Grasshopper(spiderWeb, insectController, zone);
        }
    }

    /**
     * Вероятное исчезновение кузнечика
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
     * Вероятный прыжок в соседнюю зону без паука
     */
    public void probableJumpNeighboringZoneWithoutArthropod(){
        if (Math.random() < probability_jump) {
            probability_jump /= 2;
            Zone neighbouringZoneWithoutInsect = spiderWeb.neighbouringZoneWithoutInsect(zone());
            if (neighbouringZoneWithoutInsect != null) {
                zone().extractArthropod();
                disappear();
                neighbouringZoneWithoutInsect.putArthropod(this);
                appear();
            }
        }
    }
}
