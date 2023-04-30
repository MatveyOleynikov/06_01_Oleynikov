package tests.Zone;

import Model.Spider;
import Model.SpiderWeb;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testIsEmpty {
    @Test
    public void putExtract() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());

        zone.extractArthropod();
        Assert.assertTrue(zone.isEmpty());
    }

    @Test
    public void extractPut() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.extractArthropod();
        Assert.assertTrue(zone.isEmpty());

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());
    }

    @Test
    public void putPut() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());
    }

    @Test
    public void putExtractPut() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());

        zone.extractArthropod();
        Assert.assertTrue(zone.isEmpty());

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());
    }

    @Test
    public void putExtractPutExtract() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());

        zone.extractArthropod();
        Assert.assertTrue(zone.isEmpty());

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());

        zone.extractArthropod();
        Assert.assertTrue(zone.isEmpty());
    }

    @Test
    public void putExtractExtractPut() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1,1);

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());

        zone.extractArthropod();
        Assert.assertTrue(zone.isEmpty());

        zone.extractArthropod();
        Assert.assertTrue(zone.isEmpty());

        zone.putArthropod(spider);
        Assert.assertFalse(zone.isEmpty());
    }
}
