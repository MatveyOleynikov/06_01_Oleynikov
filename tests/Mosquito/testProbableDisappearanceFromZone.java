package tests.Mosquito;

import Model.*;
import View.SpiderWidget;
import org.junit.Assert;
import org.junit.Test;

public class testProbableDisappearanceFromZone {
    @Test
    public void aroundMosquitoThreeMosquito(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        spiderWeb.zone(2, 2).putArthropod(new Mosquito());
        spiderWeb.zone(1, 2).putArthropod(new Mosquito());
        spiderWeb.zone(2, 1).putArthropod(new Mosquito());

        Zone zone = spiderWeb.zone(1, 1);

        do {
            Mosquito mosquito = new Mosquito();
            zone.putArthropod(mosquito);
            mosquito.probableDisappearance(spiderWeb);
        }   while (zone.isEmpty());
    }
    @Test
    public void aroundMosquitoFourMosquito(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        spiderWeb.zone(2, 2).putArthropod(new Mosquito());
        spiderWeb.zone(1, 2).putArthropod(new Mosquito());
        spiderWeb.zone(2, 1).putArthropod(new Mosquito());
        spiderWeb.zone(1, 0).putArthropod(new Mosquito());

        Zone zone = spiderWeb.zone(1, 1);
        Mosquito mosquito = new Mosquito();
        zone.putArthropod(mosquito);

        mosquito.probableDisappearance(spiderWeb);

        Assert.assertTrue(zone.isEmpty());
    }
    @Test
    public void aroundMosquitoEightMosquito(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        spiderWeb.zone(2, 2).putArthropod(new Mosquito());
        spiderWeb.zone(2, 1).putArthropod(new Mosquito());
        spiderWeb.zone(2, 0).putArthropod(new Mosquito());
        spiderWeb.zone(1, 2).putArthropod(new Mosquito());
        spiderWeb.zone(1, 0).putArthropod(new Mosquito());
        spiderWeb.zone(0, 2).putArthropod(new Mosquito());
        spiderWeb.zone(0, 1).putArthropod(new Mosquito());
        spiderWeb.zone(0, 0).putArthropod(new Mosquito());

        Zone zone = spiderWeb.zone(1, 1);
        Mosquito mosquito = new Mosquito();
        zone.putArthropod(mosquito);

        mosquito.probableDisappearance(spiderWeb);

        Assert.assertTrue(zone.isEmpty());
    }

    @Test
    public void aroundMosquitoEightArthropod(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        spiderWeb.zone(2, 2).putArthropod(new Insect());
        spiderWeb.zone(2, 1).putArthropod(new Insect());
        spiderWeb.zone(2, 0).putArthropod(new Insect());
        spiderWeb.zone(1, 2).putArthropod(new Insect());
        spiderWeb.zone(1, 0).putArthropod(new Insect());
        spiderWeb.zone(0, 2).putArthropod(new Insect());
        spiderWeb.zone(0, 1).putArthropod(new Insect());
        spiderWeb.zone(0, 0).putArthropod(new Insect());

        Zone zone = spiderWeb.zone(1, 1);

        do {
            Mosquito mosquito = new Mosquito();
            zone.putArthropod(mosquito);
            mosquito.probableDisappearance(spiderWeb);
        }   while (zone.isEmpty());
    }
    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        for (int i = 0; i < 1000000; ++i){
            Mosquito mosquito = new Mosquito();
            zone.putArthropod(mosquito);

            ++denominator;

            mosquito.probableDisappearance(spiderWeb);
            if (zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.05, probably, 0.01);
    }
}
