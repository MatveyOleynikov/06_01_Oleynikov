package test.SmartSpider;

import Model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testDetermineOptimalDirection {
    @Test
    public void north() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);

        Insect insect = new Insect();
        spiderWeb.zone(1, 2).putArthropod(insect);

        Assert.assertEquals(Direction.north().direct(), smartSpider.determineOptimalDirection().direct());
    }

    @Test
    public void south() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);

        Insect insect = new Insect();
        spiderWeb.zone(3, 2).putArthropod(insect);

        Assert.assertEquals(Direction.south().direct(), smartSpider.determineOptimalDirection().direct());
    }

    @Test
    public void west() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);


        Insect insect = new Insect();
        spiderWeb.zone(2, 1).putArthropod(insect);

        Assert.assertEquals(Direction.west().direct(), smartSpider.determineOptimalDirection().direct());
    }

    @Test
    public void east() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);

        Insect insect = new Insect();
        spiderWeb.zone(2, 3).putArthropod(insect);

        Assert.assertEquals(Direction.east().direct(), smartSpider.determineOptimalDirection().direct());
    }

    @Test
    public void northWest() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);


        Insect insect = new Insect();
        spiderWeb.zone(1, 1).putArthropod(insect);

        Direction.Direct direct = smartSpider.determineOptimalDirection().direct();

        Assert.assertTrue(direct == Direction.north().direct() || direct == Direction.west().direct());
    }

    @Test
    public void northEast() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);

        Insect insect = new Insect();
        spiderWeb.zone(1, 3).putArthropod(insect);

        Direction.Direct direct = smartSpider.determineOptimalDirection().direct();

        Assert.assertTrue(direct == Direction.north().direct() || direct == Direction.east().direct());
    }

    @Test
    public void southWest() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);

        Insect insect = new Insect();
        spiderWeb.zone(3, 1).putArthropod(insect);

        Direction.Direct direct = smartSpider.determineOptimalDirection().direct();

        Assert.assertTrue(direct == Direction.south().direct() || direct == Direction.west().direct());
    }

    @Test
    public void southEast() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);


        Insect insect = new Insect();
        spiderWeb.zone(3, 3).putArthropod(insect);

        Direction.Direct direct = smartSpider.determineOptimalDirection().direct();

        Assert.assertTrue(direct == Direction.south().direct() || direct == Direction.east().direct());
    }

    @Test
    public void severalInsectcs() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);

        Insect insect = new Insect();
        spiderWeb.zone(1, 2).putArthropod(insect);
        Insect insect2 = new Insect();
        spiderWeb.zone(3, 3).putArthropod(insect2);

        Assert.assertEquals(Direction.north().direct(), smartSpider.determineOptimalDirection().direct());
    }

    @Test
    public void severalInsectcsWithEqualDistantion() {
        SpiderWeb spiderWeb = new SpiderWeb(4, 4);
        SmartSpider smartSpider = new SmartSpider(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(smartSpider);
        Insect insect = new Insect();

        spiderWeb.zone(1, 2).putArthropod(insect);
        Insect insect2 = new Insect();
        spiderWeb.zone(3, 2).putArthropod(insect2);

        Direction.Direct direct = smartSpider.determineOptimalDirection().direct();

        Assert.assertTrue(direct == Direction.south().direct() || direct == Direction.north().direct());
    }
}
