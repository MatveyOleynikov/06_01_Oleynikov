package Model;

/**
 * Муха
 */
public class Fly extends Insect{
    /**
     * конструктор
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
    public static void probableAppearanceInZone(Zone zone){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Insect insect = new Fly();
            zone.putArthropod(insect);
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
        }
    }
}
