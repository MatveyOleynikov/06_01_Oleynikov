package test.Direction;

import Model.Direction;
import Model.Insect;
import Model.Zone;
import org.junit.Assert;
import org.junit.Test;

public class testRandomDirection {
    @Test
    public void direction(){
        Direction direction = Direction.randomDirection();

        Assert.assertTrue(direction.direct() == direction.north().direct() || direction.direct() == direction.east().direct()
                || direction.direct() == direction.west().direct() || direction.direct() == direction.south().direct()
        );
    }

    @Test
    public void waitNorth(){
        Direction direction = Direction.randomDirection();

        while (direction.direct() != direction.north().direct()){
            direction = Direction.randomDirection();
        }

        Assert.assertEquals(direction.north().direct(), direction.direct());
    }

    @Test
    public void waitEast(){
        Direction direction = Direction.randomDirection();

        while (direction.direct() != direction.east().direct()){
            direction = Direction.randomDirection();
        }

        Assert.assertEquals(direction.east().direct(), direction.direct());
    }

    @Test
    public void waitWest(){
        Direction direction = Direction.randomDirection();

        while (direction.direct() != direction.west().direct()){
            direction = Direction.randomDirection();
        }

        Assert.assertEquals(direction.west().direct(), direction.direct());
    }

    @Test
    public void waitSouth(){
        Direction direction = Direction.randomDirection();

        while (direction.direct() != direction.south().direct()){
            direction = Direction.randomDirection();
        }

        Assert.assertEquals(direction.south().direct(), direction.direct());
    }

    @Test
    public void checkProbably(){
        double north = 0;
        double south = 0;
        double west = 0;
        double east = 0;

        double count = 1000000;

        for (int i = 0; i < 1000000; ++i){
            Direction direction = Direction.randomDirection();

            switch (direction.direct()){
                case North -> {
                    ++north;
                }
                case South -> {
                    ++south;
                }
                case West -> {
                    ++west;
                }
                case East -> {
                    ++east;
                }
            }
        }

        Assert.assertEquals(0.25, north / count, 0.01);
        Assert.assertEquals(0.25, south / count, 0.01);
        Assert.assertEquals(0.25, west / count, 0.01);
        Assert.assertEquals(0.25, east / count, 0.01);
    }
}
