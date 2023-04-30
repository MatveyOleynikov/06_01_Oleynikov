package Model;

// Насекомое
public class Insect extends Arthropod{
    // ------------------------------- Размер ---------------------------------
    static private int _size = 5;

    public int size(){
        return _size;
    }

    // ----------------------------- Вероятности ------------------------------

    private static final double probability_appearance_insect = 0.04;
    private static final double probability_disappearance_insect = 0.2;

    // -------------------------- Появление в зоне -----------------------------

    public static void probableAppearanceInZone(Zone zone){
        if (!zone.isEmpty()){
            throw new IllegalStateException("Зона уже занята");
        }
        if (Math.random() < probability_appearance_insect){
            Insect insect = new Insect();
            zone.putArthropod(insect);
        }
    }

    public static void probableDisappearance(Insect insect){
        if (insect.zone() == null){
            throw new IllegalStateException("Насекомое не имеет зоны");
        }
        if (Math.random() < probability_disappearance_insect){
            insect.zone().extractArthropod();
        }
    }

    public void die(){
        _zone.extractArthropod();
    }

    @Override
    public String toString() {

        String msg;
        msg = "I" + "(" + size() + ")";;

        return msg;
    }
}