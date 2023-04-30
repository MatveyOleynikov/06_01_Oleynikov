package tests.Insect;

import Model.Insect;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testDie {
    @Test
    public void die(){
        Insect insect = new Insect();
        Zone zone = new Zone(1, 1);
        zone.putArthropod(insect);

        Assert.assertEquals(zone, insect.zone());

        insect.die();

        Assert.assertNull(insect.zone());
    }
}
