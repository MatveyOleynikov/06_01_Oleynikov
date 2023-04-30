package Model;

import java.util.ArrayList;
import java.util.Random;

public class SmartSpider extends Spider{
    public SmartSpider(SpiderWeb spiderWeb) {
        super(spiderWeb);
    }

    // ----------------- Определение оптимального направления ----------------------
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
