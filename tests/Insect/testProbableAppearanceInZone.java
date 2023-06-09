package tests.Insect;

import Model.Insect;
import Model.Spider;
import Model.SpiderWeb;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class testProbableAppearanceInZone {
    @Test
    public void zoneEmpty(){
        Zone zone = new Zone(1, 1);
        Insect.probableAppearanceInZone(zone, null);
    }

    @Test
    public void zoneHaveSpider(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        Spider spider = new Spider(spiderWeb);
        Zone zone = new Zone(1, 1);
        zone.putArthropod(spider);

        Assert.assertEquals(spider, zone.getArthropod());
    }

    @Test
    public void zoneHaveInsect(){
        Insect insect = new Insect();
        Zone zone = new Zone(1, 1);
        zone.putArthropod(insect);

        Assert.assertEquals(insect, zone.getArthropod());
    }

    @Test
    public void waitInsect(){
        Zone zone = new Zone(1, 1);
        while (zone.isEmpty()){
            Insect.probableAppearanceInZone(zone, null);
        }
        Assert.assertTrue(zone.getArthropod() instanceof Insect);
    }

    @Test
    public void waitNull(){
        Zone zone = new Zone(1, 1);
        Insect.probableAppearanceInZone(zone, null);

        while (zone.getArthropod() != null){
            zone.extractArthropod();
            Insect.probableAppearanceInZone(zone, null);
        }
        Assert.assertNull(zone.getArthropod());
    }

    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        for (int i = 0; i < 1000000; ++i){
            ++denominator;
            Insect.probableAppearanceInZone(zone, null);
            if (!zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.04, probably, 0.001);
    }
}
