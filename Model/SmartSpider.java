package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Паук соперника (умный паук, так как умеет определять оптимальное направление)
 */
public class SmartSpider extends Spider{
    /**
     * Конструктор
     * @param spiderWeb паутина
     */
    public SmartSpider(SpiderWeb spiderWeb) {
        super(spiderWeb);
    }

    /**
     * Определение оптимального направления
     * @return направление
     */
    public Direction determineOptimalDirection() {
        Zone nearestInsectZone = _spiderWeb.nearestInsectZone(zone());

        if (nearestInsectZone == null) {
            return Direction.randomDirection();
        }

        ArrayList<Direction> directions = Direction.getOptimalDirections(zone(), nearestInsectZone);

        Random random = new Random();
        return directions.get(random.nextInt(directions.size()));
    }
}
