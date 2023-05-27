package tests.Wasp;

import Model.Spider;
import Model.SpiderWeb;
import Model.Wasp;
import org.junit.Assert;
import org.junit.Test;

public class probableBite {
    @Test
    public void spiderWillDie(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        Spider spider = new Spider(spiderWeb);
        Wasp wasp = new Wasp();

        while (spider.isAlive()){
            wasp.probableBite(spider);
        }

        Assert.assertFalse(spider.isAlive());
        Assert.assertEquals(0, spider.healthPoints());
    }

    @Test
    public void noSpiderWillDie(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        Spider spider = new Spider(spiderWeb);
        Wasp wasp = new Wasp();

        int beginHealtPoints = spider.healthPoints();

        wasp.probableBite(spider);

        Assert.assertTrue(spider.isAlive());
        Assert.assertTrue(spider.healthPoints() == beginHealtPoints - 3 || spider.healthPoints() == beginHealtPoints);
    }

    @Test
    public void waitBite(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        Spider spider = new Spider(spiderWeb);
        Wasp wasp = new Wasp();

        int beginHealtPoints = spider.healthPoints();

        while (spider.healthPoints() == beginHealtPoints){
            wasp.probableBite(spider);
        }

        Assert.assertTrue(spider.healthPoints() == beginHealtPoints - 3);
    }

    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        for (int i = 0; i < 1000000; ++i){
            SpiderWeb spiderWeb = new SpiderWeb(5, 5);
            Spider spider = new Spider(spiderWeb);

            int beginHealthPoints = spider.healthPoints();

            Wasp wasp = new Wasp();
            wasp.probableBite(spider);

            ++denominator;

            if (spider.healthPoints() != beginHealthPoints){
                ++numerator;
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.3, probably, 0.001);
    }
}
