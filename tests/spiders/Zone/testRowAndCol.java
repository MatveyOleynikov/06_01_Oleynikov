package test.Zone;

import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testRowAndCol {
    public void checkZone(int row, int col){
        Zone zone = new Zone(row, col);

        Assert.assertEquals(row, zone.row());
        Assert.assertEquals(col, zone.col());
    }

    @Test
    public void equalСoordinates() {
        checkZone(3, 3);
    }

    @Test
    public void positiveСoordinates() {
        checkZone(3, 5);
    }

    @Test
    public void zeroСoordinate() {
        checkZone(3, 0);
    }

    @Test
    public void negativeСoordinate() {
        checkZone(3, -5);
    }

    @Test
    public void complexText1() {
        checkZone(-5, -5);
    }

    @Test
    public void complexText2() {
        checkZone(-5, 7);
    }

    @Test
    public void complexText3() {
        checkZone(0, 0);
    }
}
