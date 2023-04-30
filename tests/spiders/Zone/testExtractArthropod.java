package test.Zone;

import Model.Insect;
import Model.Spider;
import Model.SpiderWeb;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

import java.util.TreeMap;

public class testExtractArthropod {
    @Test
    public void putExtract() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());

        zone.extractArthropod();
        Assert.assertNull(zone.getArthropod());
    }

    @Test
    public void extractPut() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.extractArthropod();
        Assert.assertNull(zone.getArthropod());

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());
    }

    @Test
    public void putExtractPut() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());

        zone.extractArthropod();
        Assert.assertNull(zone.getArthropod());

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());
    }

    @Test
    public void putExtractPutExtract() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());

        zone.extractArthropod();
        Assert.assertNull(zone.getArthropod());

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());

        zone.extractArthropod();
        Assert.assertNull(zone.getArthropod());
    }

    @Test
    public void putExtractExtractPut() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());

        zone.extractArthropod();
        Assert.assertNull(zone.getArthropod());

        zone.extractArthropod();
        Assert.assertNull(zone.getArthropod());

        zone.putArthropod(spider);
        Assert.assertEquals(spider, zone.getArthropod());
    }
}
