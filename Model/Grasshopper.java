package Model;

/**
 * Кузнечик
 */
public class Grasshopper extends Insect{
    final SpiderWeb spiderWeb;
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
    public static void probableAppearanceInZone(Zone zone, SpiderWeb spiderWeb){
        if (!zone.isEmpty()){
            return;
        }
        if (Math.random() < probability_appearance_insect){
            Insect insect = new Grasshopper(spiderWeb);
            zone.putArthropod(insect);
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
        }
    }

    /**
     * Вероятный прыжок в соседнюю зону без паука
     */
    public void probableJumpNeighboringZoneWithoutArthropod(){
        if (Math.random() < probability_jump) {
            probability_jump /= 2;
            Zone zoneNorth = spiderWeb.zone(zone(), Direction.north());
            if (zoneNorth != null && zoneNorth.getArthropod() == null) {
                zone().extractArthropod();
                zoneNorth.putArthropod(this);
                return;
            }

            Zone zoneSouth = spiderWeb.zone(zone(), Direction.south());
            if (zoneSouth != null && zoneSouth.getArthropod() == null) {
                zone().extractArthropod();
                zoneSouth.putArthropod(this);
                return;
            }

            Zone zoneEast = spiderWeb.zone(zone(), Direction.east());
            if (zoneEast != null && zoneEast.getArthropod() == null) {
                zone().extractArthropod();
                zoneEast.putArthropod(this);
                return;
            }


            Zone zoneWest = spiderWeb.zone(zone(), Direction.west());
            if (zoneWest != null && zoneWest.getArthropod() == null) {
                zone().extractArthropod();
                zoneWest.putArthropod(this);
                return;
            }
        }
    }
}
