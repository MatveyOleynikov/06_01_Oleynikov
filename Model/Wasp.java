package Model;

/**
 * Оса
 */
public class Wasp extends Insect{
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
    public static void probableAppearanceInZone(Zone zone){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Insect insect = new Wasp();
            zone.putArthropod(insect);
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
