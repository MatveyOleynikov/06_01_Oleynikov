package tests.Grasshopper;

import Model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class probableJumpNeighboringZoneWithoutArthropod {
    @Test
    public void northEmpty(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);
        Spider spider3 = new Spider(spiderWeb);
        Spider spider4 = new Spider(spiderWeb);

        spiderWeb.zone(2, 1).putArthropod(spider1);
        spiderWeb.zone(2, 3).putArthropod(spider2);
        spiderWeb.zone(3, 2).putArthropod(spider4);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(grasshopper);

        while (grasshopper.zone() == spiderWeb.zone(2, 2)) {
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertEquals(spiderWeb.zone(1, 2), grasshopper.zone());
    }

    @Test
    public void southEmpty(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);
        Spider spider3 = new Spider(spiderWeb);
        Spider spider4 = new Spider(spiderWeb);

        spiderWeb.zone(2, 1).putArthropod(spider1);
        spiderWeb.zone(2, 3).putArthropod(spider2);
        spiderWeb.zone(1, 2).putArthropod(spider3);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(grasshopper);

        while (grasshopper.zone() == spiderWeb.zone(2, 2)) {
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertEquals(spiderWeb.zone(3, 2), grasshopper.zone());
    }

    @Test
    public void westEmpty(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);
        Spider spider3 = new Spider(spiderWeb);
        Spider spider4 = new Spider(spiderWeb);

        spiderWeb.zone(2, 3).putArthropod(spider2);
        spiderWeb.zone(1, 2).putArthropod(spider3);
        spiderWeb.zone(3, 2).putArthropod(spider4);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(grasshopper);

        while (grasshopper.zone() == spiderWeb.zone(2, 2)) {
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertEquals(spiderWeb.zone(2, 1), grasshopper.zone());
    }

    @Test
    public void eastEmpty(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);
        Spider spider3 = new Spider(spiderWeb);
        Spider spider4 = new Spider(spiderWeb);

        spiderWeb.zone(2, 1).putArthropod(spider1);
        spiderWeb.zone(1, 2).putArthropod(spider3);
        spiderWeb.zone(3, 2).putArthropod(spider4);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(grasshopper);

        while (grasshopper.zone() == spiderWeb.zone(2, 2)) {
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertEquals(spiderWeb.zone(2, 3), grasshopper.zone());
    }

    @Test
    public void allEmpty(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(grasshopper);

        while (grasshopper.zone() == spiderWeb.zone(2, 2)) {
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertTrue(grasshopper.zone() == spiderWeb.zone(1, 2)
                            || grasshopper.zone() == spiderWeb.zone(3, 2)
                            || grasshopper.zone() == spiderWeb.zone(2, 1)
                            || grasshopper.zone() == spiderWeb.zone(2, 3));
    }

    @Test
    public void severalEmpty(){

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);
        Spider spider3 = new Spider(spiderWeb);
        Spider spider4 = new Spider(spiderWeb);

        spiderWeb.zone(2, 1).putArthropod(spider1);
        spiderWeb.zone(3, 2).putArthropod(spider4);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(grasshopper);

        while (grasshopper.zone() == spiderWeb.zone(2, 2)) {
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertTrue(spiderWeb.zone(2, 3) == grasshopper.zone()
                            || spiderWeb.zone(1, 2) == grasshopper.zone());
    }

    @Test
    public void noEmpty(){

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);
        Spider spider3 = new Spider(spiderWeb);
        Spider spider4 = new Spider(spiderWeb);

        spiderWeb.zone(2, 1).putArthropod(spider1);
        spiderWeb.zone(2, 3).putArthropod(spider2);
        spiderWeb.zone(1, 2).putArthropod(spider3);
        spiderWeb.zone(3, 2).putArthropod(spider4);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(2, 2).putArthropod(grasshopper);

        int cnt = 0;

        int attempts = 1000000;

        while (grasshopper.zone() == spiderWeb.zone(2, 2) && cnt < attempts) {
            ++cnt;
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertEquals(attempts, cnt);
    }

    @Test
    public void stuckOnBorder(){

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        Spider spider1 = new Spider(spiderWeb);
        Spider spider2 = new Spider(spiderWeb);
        Spider spider3 = new Spider(spiderWeb);
        Spider spider4 = new Spider(spiderWeb);

        spiderWeb.zone(3, 4).putArthropod(spider1);
        spiderWeb.zone(4, 3).putArthropod(spider2);

        Grasshopper grasshopper = new Grasshopper(spiderWeb);
        spiderWeb.zone(4, 4).putArthropod(grasshopper);

        int cnt = 0;

        int attempts = 1000000;

        while (grasshopper.zone() == spiderWeb.zone(4, 4) && cnt < attempts) {
            ++cnt;
            grasshopper.probableJumpNeighboringZoneWithoutArthropod();
        }

        Assert.assertEquals(attempts, cnt);
    }

    @Test
    public void checkProbably(){
        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        int numerator = 0, denominator = 0;

        Zone zone = spiderWeb.zone(2, 2);

        for (int i = 0; i < 1000000; ++i){
            ++denominator;
            Grasshopper grasshopper = new Grasshopper(spiderWeb);
            zone.putArthropod(grasshopper);

            grasshopper.probableJumpNeighboringZoneWithoutArthropod();

            if (zone.isEmpty()){
                ++numerator;
            }
            grasshopper.die();
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.8, probably, 0.01);
    }

    @Test
    public void checkProbablyDecreasing(){

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);

        ArrayList<Integer> numerators = new ArrayList<>();
        ArrayList<Integer> denominator = new ArrayList<>();

        for (int i = 0; i < 3; ++i){
            numerators.add(0);
            denominator.add(0);
        }

        Zone zone = spiderWeb.zone(2, 2);

        for (int i = 0; i < 1000000; ++i){
            Grasshopper grasshopper = new Grasshopper(spiderWeb);
            zone.putArthropod(grasshopper);

            grasshopper.probableJumpNeighboringZoneWithoutArthropod();

            for (int j = 0; j < 3; ++j) {
                denominator.set(j, denominator.get(j) + 1);

                if (zone.isEmpty()) {
                    numerators.set(j, numerators.get(j) + 1);
                    numerators.get(j);
                }   else{
                    break;
                }
                zone = grasshopper.zone();
                grasshopper.probableJumpNeighboringZoneWithoutArthropod();
            }

            grasshopper.die();
        }

        for (int i = 0; i < 3; ++i) {
            double probably = (double) numerators.get(i) / (double) denominator.get(i);
            Assert.assertEquals(0.8 / Math.pow(2, (double) i), probably, 0.01);
        }
    }
}
