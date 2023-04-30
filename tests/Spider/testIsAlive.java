package tests.Spider;

import Model.Direction;
import Model.Spider;
import Model.SpiderWeb;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testIsAlive {
    @Test
    public void zeroHealth() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);

        Zone zone = spiderWeb.zone(2, 2);
        zone.putArthropod(spider);

        while (spider.healthPoints() != 0){
            if (spider.zone().row() == 2){
                spider.tryMove(Direction.north());
            }   else{
                spider.tryMove(Direction.south());
            }
        }

        Assert.assertFalse(spider.isAlive());
    }

    @Test
    public void noZeroHealth() {
        SpiderWeb spiderWeb = new SpiderWeb(3, 3);
        Spider spider = new Spider(spiderWeb);

        Assert.assertTrue(spider.isAlive());
    }
}
