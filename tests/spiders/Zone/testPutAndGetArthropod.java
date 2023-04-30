package test.Zone;

import Model.Insect;
import Model.Spider;
import Model.SpiderWeb;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testPutAndGetArthropod {
    @Test
    public void putInsect() {
        Insect insect = new Insect();
        Zone zone = new Zone(1,1);

        zone.putArthropod(insect);
        Assert.assertEquals(insect, zone.getArthropod());
    }

    @Test
    public void putSpider() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());
    }

    @Test
    public void twoPutOneGet() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);

        Zone zone = new Zone(1,1);

        zone.putArthropod(spider1);
        zone.putArthropod(spider2);

        Assert.assertEquals(spider2, zone.getArthropod());
    }

    @Test
    public void twoPutTwoGet() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);

        Zone zone = new Zone(1,1);

        zone.putArthropod(spider1);
        Assert.assertEquals(spider1, zone.getArthropod());

        zone.putArthropod(spider2);
        Assert.assertEquals(spider2, zone.getArthropod());
    }

    @Test
    public void onePutTwoGet() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());
        Assert.assertEquals(spider, zone.getArthropod());
    }

    @Test
    public void complexTest1() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Insect insect = new Insect();

        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());

        zone.putArthropod(insect);
        Assert.assertEquals(insect, zone.getArthropod());
    }

    @Test
    public void complexTest2() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Spider insect = new Spider(spiderWeb);

        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        zone.putArthropod(insect);

        Assert.assertEquals(insect, zone.getArthropod());
    }
}
