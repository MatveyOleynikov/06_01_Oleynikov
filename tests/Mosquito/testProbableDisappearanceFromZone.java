package tests.Mosquito;

import Model.Fly;
import Model.Mosquito;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testProbableDisappearanceFromZone {
    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        for (int i = 0; i < 1000000; ++i){
            Mosquito mosquito = new Mosquito();
            zone.putArthropod(mosquito);

            ++denominator;

            mosquito.probableDisappearance();
            if (zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.05, probably, 0.01);
    }
}
