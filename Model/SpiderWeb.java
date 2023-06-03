package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Паутина
 */
public class SpiderWeb{
    /**
     * высота
     */
    private final int _height;

    /**
     * ширина
     */
    private final int _width;

    /**
     * Получить высоту {@link SpiderWeb#_height}.
     * @return высота.
     */
    public int height() {
        return _height;
    }

    /**
     * Получить ширину {@link SpiderWeb#_width}.
     * @return ширина.
     */
    public int width() {
        return _width;
    }


    /**
     * зоны
     */
    private final ArrayList<ArrayList<Zone>> _zones = new ArrayList<>();

    /**
     * Получение зоны по расположению
     * @param row строка
     * @param col столбец
     * @return зона
     */
    public Zone zone(int row, int col) {
        if (row < 0 || col < 0 || row >= height() || col >= width()){
            return null;
        }
        return _zones.get(row).get(col);
    }

    /**
     * Конструктор
     * @param height высота
     * @param width ширина
     */
    public SpiderWeb(int height, int width) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }

        _width = width;
        _height = height;

        buildSpiderWeb();
    }

    /**
     * Построение паутины
     */
    private void buildSpiderWeb() {
        // Создаем ячейки
        for (int row = 0; row < height(); row++) {
            _zones.add(new ArrayList<>());
            for (int col = 0; col < width(); col++) {
                _zones.get(row).add(new Zone(row, col));
            }
        }
    }

    /**
     * Добавление не добавленной ранее зоны в очередь
     * @param queue очередь
     * @param visited список добавленных ранее зон
     * @param row строка
     * @param col столбец
     */
    private void addZone(ArrayDeque<Zone> queue, ArrayList<Zone> visited, int row, int col){
        if (zone(row, col) != null && !visited.contains(zone(row, col))){
            queue.addLast(zone(row, col));
            visited.add(zone(row, col));
        }
    }

    /**
     * Ближайшая зона с насекомым
     * @param zone начальная зона
     * @return зона
     */
    public Zone nearestInsectZone(Zone zone){

        ArrayDeque<Zone> queue = new ArrayDeque<Zone>();
        queue.addLast(zone);

        ArrayList<Zone> visited = new ArrayList<>();
        visited.add(zone);

        while (!queue.isEmpty()){
            Zone cur = queue.pollFirst();

            if (cur.getArthropod() instanceof Insect){
                return cur;
            }

            addZone(queue, visited, cur.row() - 1, cur.col());
            addZone(queue, visited,cur.row() + 1, cur.col());
            addZone(queue, visited, cur.row(), cur.col() - 1);
            addZone(queue, visited, cur.row(), cur.col() + 1);
        }

        return null;
    }

    /**
     * Зона по направлению
     * @param zone начальная зона
     * @param direct направление
     * @return зона
     */
    public Zone zone(Zone zone, Direction direct) {
        int row = zone.row();
        int col = zone.col();

        switch (direct.direct()){
            case North -> {
                --row;
            }
            case South -> {
                ++row;
            }
            case West -> {
                --col;
            }
            case East -> {
                ++col;
            }
        }

        return zone(row, col);
    }


    /**
     * Получение соседней зоны без насекомого
     * @param zone зона
     * @return соседняя зона
     */
    public Zone neighbouringZoneWithoutInsect(Zone zone){
        ArrayList<Direction> directions = Direction.getAllDirections();

        for (Direction direction: directions){
            Zone zoneDirection = zone(zone, direction);
            if (zoneDirection != null && zoneDirection.getArthropod() == null) {
                return zoneDirection;
            }
        }

        return null;
    }
}