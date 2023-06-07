package Model;

import event.InsectActionEvent;
import event.InsectActionListener;

import java.util.ArrayList;

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
     * Количество комаров соседей
     * @return количество комаров соседей
     */
    private static int countOfMosquitoInArrayList(ArrayList<Arthropod> arthropods){
        int result = 0;
        for (Arthropod arthropod: arthropods){
            if (arthropod instanceof Mosquito){
                result++;
            }
        }
        return result;
    }

    /**
     * Вероятное появление комара в зоне
     * @param zone зона
     */
    public static void probableAppearanceInZone(Zone zone, SpiderWeb spiderWeb, InsectActionListener insectController){
        if (!zone.isEmpty()){
            return;
        }

        ArrayList<Arthropod> arthropodsAroundZone = spiderWeb.getArthropodsAroundZone(zone);

        if (Math.random() < probability_appearance_insect
                || countOfMosquitoInArrayList(arthropodsAroundZone) == 3){
            Mosquito mosquito = new Mosquito(insectController, zone);
        }
    }

    /**
     * Вероятное исчезновение комара
     */
    public void probableDisappearance(SpiderWeb spiderWeb){
        if (this.zone() == null){
            throw new IllegalStateException("Насекомое не имеет зоны");
        }

        ArrayList<Arthropod> arthropodsAroundZone = spiderWeb.getArthropodsAroundZone(_zone);

        if (Math.random() < probability_disappearance_insect
        || countOfMosquitoInArrayList(arthropodsAroundZone) >= 4){
            this.zone().extractArthropod();
            disappear();
        }
    }
}
