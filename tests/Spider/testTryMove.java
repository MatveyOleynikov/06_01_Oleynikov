package tests.Spider;

import Model.Direction;
import Model.Insect;
import Model.Spider;
import Model.SpiderWeb;
import org.junit.Assert;
import org.junit.Test;

public class testTryMove {
    @Test
    public void zoneContainSpider(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        Spider spider = new Spider(spiderWeb);

        Spider otherSpider = new Spider(spiderWeb);

        spiderWeb.zone(1, 1).putArthropod(spider);
        spiderWeb.zone(1, 2).putArthropod(otherSpider);

        spider.tryMove(Direction.east());

        Assert.assertEquals(spiderWeb.zone(1, 1), spider.zone());
    }


    @Test
    public void zoneContainInsect(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        Spider spider = new Spider(spiderWeb);

        Insect insect = new Insect();

        spiderWeb.zone(1, 1).putArthropod(spider);
        spiderWeb.zone(1, 2).putArthropod(insect);

        int spiderHealth = spider.healthPoints();
        int sizeInsect = insect.size();
        int healthPointsForMove = 1;

        spider.tryMove(Direction.east());

        int newSpiderHealth = spider.healthPoints();

        //todo: healthPointsForMove из spider
        Assert.assertEquals(spiderHealth + sizeInsect - healthPointsForMove, newSpiderHealth);
        Assert.assertEquals(spiderWeb.zone(1, 2), spider.zone());

    }

    @Test
    public void zoneContainNothing(){

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        Spider spider = new Spider(spiderWeb);


        spiderWeb.zone(1, 1).putArthropod(spider);

        spider.tryMove(Direction.east());

        Assert.assertEquals(spiderWeb.zone(1, 2), spider.zone());
    }
}
