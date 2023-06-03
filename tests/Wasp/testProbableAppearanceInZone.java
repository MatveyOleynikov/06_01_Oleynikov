package tests.Wasp;

import Model.Fly;
import Model.Wasp;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testProbableAppearanceInZone {

    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        for (int i = 0; i < 1000000; ++i){
            ++denominator;
            Wasp.probableAppearanceInZone(zone, null);
            if (!zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.01, probably, 0.001);
    }
}
