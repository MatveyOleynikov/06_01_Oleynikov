package tests.Mosquito;

import Model.*;
import View.SpiderWidget;
import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

public class testProbableAppearanceInZone {
    @Test
    public void aroundMosquitoThreeArthropod(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        spiderWeb.zone(2, 2).putArthropod(new Insect());
        spiderWeb.zone(1, 2).putArthropod(new Insect());
        spiderWeb.zone(2, 1).putArthropod(new Insect());

        Zone zone = spiderWeb.zone(1, 1);

        do {
            zone.extractArthropod();
            Mosquito.probableAppearanceInZone(zone, spiderWeb, null);
        }   while (!zone.isEmpty());
    }

    @Test
    public void aroundMosquitoThreeMosquito(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        spiderWeb.zone(2, 2).putArthropod(new Mosquito());
        spiderWeb.zone(1, 2).putArthropod(new Mosquito());
        spiderWeb.zone(2, 1).putArthropod(new Mosquito());

        Zone zone = spiderWeb.zone(1, 1);
        Mosquito.probableAppearanceInZone(zone, spiderWeb, null);

        Assert.assertTrue(zone.getArthropod() instanceof Mosquito);
    }

    @Test
    public void aroundMosquitoNotThreeMosquito(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        spiderWeb.zone(2, 2).putArthropod(new Mosquito());
        spiderWeb.zone(1, 2).putArthropod(new Mosquito());
        spiderWeb.zone(2, 1).putArthropod(new Mosquito());
        spiderWeb.zone(0, 1).putArthropod(new Mosquito());

        Zone zone = spiderWeb.zone(1, 1);

        do {
            zone.extractArthropod();
            Mosquito.probableAppearanceInZone(zone, spiderWeb, null);
        }   while (!zone.isEmpty());
    }
    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        for (int i = 0; i < 1000000; ++i){
            ++denominator;
            Mosquito.probableAppearanceInZone(zone, spiderWeb, null);
            if (!zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.08, probably, 0.001);
    }
}
