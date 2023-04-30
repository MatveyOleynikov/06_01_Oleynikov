package test.SpiderWeb;

import Model.*;
import org.junit.Assert;
import org.junit.Test;

public class testNearestInsectZone {
    @Test
    public void noInsect() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Assert.assertNull(spiderWeb.nearestInsectZone(zone));
    }

    @Test
    public void oneInsect() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Insect insect = new Insect();

        spiderWeb.zone(3, 2).putArthropod(insect);

        Assert.assertEquals(spiderWeb.zone(3, 2), spiderWeb.nearestInsectZone(zone));
    }

    @Test
    public void severalInsects() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Insect insect = new Insect();

        spiderWeb.zone(3, 2).putArthropod(insect);
        spiderWeb.zone(3, 3).putArthropod(insect);

        Assert.assertEquals(spiderWeb.zone(3, 2), spiderWeb.nearestInsectZone(zone));

    }

    @Test
    public void distanceBiggerThanOne(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Insect insect = new Insect();

        spiderWeb.zone(3, 3).putArthropod(insect);

        Assert.assertEquals(spiderWeb.zone(3, 3), spiderWeb.nearestInsectZone(zone));
    }

    @Test
    public void north() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Insect insect = new Insect();

        spiderWeb.zone(1, 2).putArthropod(insect);

        Assert.assertEquals(spiderWeb.zone(1, 2), spiderWeb.nearestInsectZone(zone));
    }

    @Test
    public void south() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Insect insect = new Insect();

        spiderWeb.zone(3, 2).putArthropod(insect);

        Assert.assertEquals(spiderWeb.zone(3, 2), spiderWeb.nearestInsectZone(zone));
    }

    @Test
    public void west() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Insect insect = new Insect();

        spiderWeb.zone(2, 1).putArthropod(insect);

        Assert.assertEquals(spiderWeb.zone(2, 1), spiderWeb.nearestInsectZone(zone));
    }

    @Test
    public void east() {
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Zone zone = spiderWeb.zone(2, 2);

        Insect insect = new Insect();

        spiderWeb.zone(2, 3).putArthropod(insect);

        Assert.assertEquals(spiderWeb.zone(2, 3), spiderWeb.nearestInsectZone(zone));
    }
}
