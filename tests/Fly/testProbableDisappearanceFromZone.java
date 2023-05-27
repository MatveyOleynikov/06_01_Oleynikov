package tests.Fly;

import Model.Fly;
import Model.Insect;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testProbableDisappearanceFromZone {
    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        for (int i = 0; i < 1000000; ++i){
            Fly fly = new Fly();
            zone.putArthropod(fly);

            ++denominator;

            fly.probableDisappearance();
            if (zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.1, probably, 0.01);
    }
}
