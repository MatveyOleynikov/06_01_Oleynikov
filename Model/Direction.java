package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Направление
 */
public class Direction {
    /**
     * направление
     */
    public enum Direct{
        North,
        West,
        South,
        East
    };


    /**
     * направление
     */
    private Direct _direct;

    /**
     * Получить направление {@link Direction#_direct}.
     * @return направление.
     */
    public Direct direct(){
        return _direct;
    }

    /**
     * Установить направление
     * @param direct направление
     */
    public Direction(Direct direct){
        _direct = direct;
    }

    /**
     * направление на север
     * @return направление
     */
    public static Direction north() {
        return new Direction(Direct.North);
    }

    /**
     * направление на юг
     * @return направление
     */
    public static Direction south() {
        return new Direction(Direct.South);
    }

    /**
     * направление на восток
     * @return направление
     */
    public static Direction east() {
        return new Direction(Direct.East);
    }

    /**
     * направление на запад
     * @return направление
     */
    public static Direction west() {
        return new Direction(Direct.West);
    }

    /**
     * Сгенерировать случайно направление
     * @return направление
     */
    public static Direction randomDirection(){
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(Direction.east());
        directions.add(Direction.west());
        directions.add(Direction.north());
        directions.add(Direction.south());

        return directions.get((new Random()).nextInt(directions.size()));
    }

    /**
     * Определить список оптимальных направлений для перемещения
     * @param from зона откуда перемещаемся
     * @param to зона куда перемещаемся
     * @return список направлений
     */
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

    /**
     * Получить все направления
     * @return список направлений
     */
    public static ArrayList<Direction> getAllDirections(){
        ArrayList<Direction> directions = new ArrayList<Direction>();

        directions.add(Direction.north());
        directions.add(Direction.east());
        directions.add(Direction.south());
        directions.add(Direction.west());

        return directions;
    }
}