package test.Insect;

import Model.Insect;
import Model.Spider;
import Model.SpiderWeb;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class testProbableDisappearanceFromZone {
    @Test
    public void insectWithoutZone(){
        Zone zone = new Zone(1, 1);
        Insect insect = new Insect();

        String expMessage = "Насекомое не имеет зоны";
        Throwable thrown = assertThrows(IllegalStateException.class, () -> Insect.probableDisappearance(insect));

        Assert.assertEquals(expMessage, thrown.getMessage());
    }

    @Test
    public void zoneHaveInsect(){
        Insect insect = new Insect();
        Zone zone = new Zone(1, 1);
        zone.putArthropod(insect);
        Insect.probableDisappearance(insect);
    }

    @Test
    public void waitInsect(){
        Zone zone = new Zone(1, 1);
        Insect insect = new Insect();

        do{
            zone.putArthropod(insect);
            Insect.probableDisappearance(insect);
        }   while (zone.isEmpty());

        Assert.assertTrue(zone.getArthropod() instanceof Insect);
    }

    @Test
    public void waitNull(){
        Zone zone = new Zone(1, 1);
        Insect insect = new Insect();

        do{
            zone.putArthropod(insect);
            Insect.probableDisappearance(insect);
        }   while (!zone.isEmpty());

        Assert.assertNull(zone.getArthropod());
    }

    @Test
    public void checkProbably(){
        int numerator = 0, denominator = 0;

        Zone zone = new Zone(1, 1);

        for (int i = 0; i < 1000000; ++i){
            Insect insect = new Insect();
            zone.putArthropod(insect);

            ++denominator;

            Insect.probableDisappearance(insect);
            if (zone.isEmpty()){
                ++numerator;
                zone.extractArthropod();
            }
        }

        double probably = (double) numerator / (double) denominator;

        Assert.assertEquals(0.2, probably, 0.01);
    }
}
