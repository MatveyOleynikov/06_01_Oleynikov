package tests.Grasshopper;

import Model.Fly;
import Model.Grasshopper;
import Model.SpiderWeb;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testProbableAppearanceInZone {
    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        SpiderWeb spiderWeb = new SpiderWeb(5, 5);
        for (int i = 0; i < 1000000; ++i){
            ++denominator;
            Grasshopper.probableAppearanceInZone(zone, spiderWeb);
            if (!zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.02, probably, 0.001);
    }
}
