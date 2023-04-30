package Model;

import java.util.ArrayList;
import java.util.Random;

// Направление  - "север/юг/запад/восток"
public class Direction {
    public enum Direct{
        North,
        West,
        South,
        East
    };

    private Direct _direct;

    public Direct direct(){
        return _direct;
    }

    public Direction(Direct direct){
        _direct = direct;
    }

    public static Direction north() {
        return new Direction(Direct.North);
    }

    public static Direction south() {
        return new Direction(Direct.South);
    }

    public static Direction east() {
        return new Direction(Direct.East);
    }

    public static Direction west() {
        return new Direction(Direct.West);
    }

    public static Direction randomDirection(){
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(Direction.east());
        directions.add(Direction.west());
        directions.add(Direction.north());
        directions.add(Direction.south());

        return directions.get((new Random()).nextInt(directions.size()));
    }

    public static ArrayList<Direction> getOptimalDirections(Zone from, Zone to){
        ArrayList<Direction> directions = new ArrayList<>();

        if (to.row() < from.row()){
            directions.add(Direction.north());
        }
        if (to.row() > from.row()){
            directions.add(Direction.south());
        }
        if (to.col() < from.col()){
            directions.add(Direction.west());
        }
        if (to.col() > from.col()){
            directions.add(Direction.east());
        }

        return directions;
    }
}