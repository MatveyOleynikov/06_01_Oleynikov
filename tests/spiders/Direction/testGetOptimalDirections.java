package test.Direction;

import Model.Direction;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testGetOptimalDirections {
    @Test
    public void equalZones() {
        Zone from = new Zone(1, 1);
        Zone to = new Zone(1, 1);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(0, actualDirections.size());
    }

    @Test
    public void north() {
        Zone from = new Zone(2, 1);
        Zone to = new Zone(1, 1);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(1, actualDirections.size());

        Assert.assertEquals(Direction.north().direct(), actualDirections.get(0).direct());
    }

    @Test
    public void south() {
        Zone from = new Zone(1, 1);
        Zone to = new Zone(2, 1);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(1, actualDirections.size());

        Assert.assertEquals(Direction.south().direct(), actualDirections.get(0).direct());
    }

    @Test
    public void west() {
        Zone from = new Zone(1, 2);
        Zone to = new Zone(1, 1);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(1, actualDirections.size());

        Assert.assertEquals(Direction.west().direct(), actualDirections.get(0).direct());
    }

    @Test
    public void east() {
        Zone from = new Zone(1, 1);
        Zone to = new Zone(1, 2);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(1, actualDirections.size());

        Assert.assertEquals(Direction.east().direct(), actualDirections.get(0).direct());
    }

    @Test
    public void northWest() {
        Zone from = new Zone(2, 2);
        Zone to = new Zone(1, 1);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(2, actualDirections.size());

        Assert.assertTrue(actualDirections.get(0).direct() == Direction.north().direct() || actualDirections.get(0).direct() == Direction.west().direct());
        Assert.assertTrue(actualDirections.get(1).direct() == Direction.north().direct() || actualDirections.get(1).direct() == Direction.west().direct());
    }

    @Test
    public void northEast() {
        Zone from = new Zone(2, 1);
        Zone to = new Zone(1, 2);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(2, actualDirections.size());

        Assert.assertTrue(actualDirections.get(0).direct() == Direction.north().direct() || actualDirections.get(0).direct() == Direction.east().direct());
        Assert.assertTrue(actualDirections.get(1).direct() == Direction.north().direct() || actualDirections.get(1).direct() == Direction.east().direct());
    }

    @Test
    public void southWest() {
        Zone from = new Zone(1, 2);
        Zone to = new Zone(2, 1);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(2, actualDirections.size());

        Assert.assertTrue(actualDirections.get(0).direct() == Direction.south().direct() || actualDirections.get(0).direct() == Direction.west().direct());
        Assert.assertTrue(actualDirections.get(1).direct() == Direction.south().direct() || actualDirections.get(1).direct() == Direction.west().direct());
    }

    @Test
    public void southEast() {
        Zone from = new Zone(1, 1);
        Zone to = new Zone(2, 2);

        ArrayList<Direction> actualDirections = Direction.getOptimalDirections(from, to);

        Assert.assertEquals(2, actualDirections.size());

        Assert.assertTrue(actualDirections.get(0).direct() == Direction.south().direct() || actualDirections.get(0).direct() == Direction.east().direct());
        Assert.assertTrue(actualDirections.get(1).direct() == Direction.south().direct() || actualDirections.get(1).direct() == Direction.east().direct());
    }
}
