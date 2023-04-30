package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// Паутина
public class SpiderWeb{
    // ---------------------- Размеры -----------------------------
    private final int _height;
    private final int _width;

    public int height() {
        return _height;
    }

    public int width() {
        return _width;
    }

    // --------------------------- Ячейки ----------------------

    private final ArrayList<ArrayList<Zone>> _zones = new ArrayList<>();

    public ArrayList<ArrayList<Zone>> zones(){
        return _zones;
    }

    public Zone zone(int row, int col) {
        if (row < 0 || col < 0 || row >= height() || col >= width()){
            return null;
        }
        return _zones.get(row).get(col);
    }

    // ---------------------------- Порождение ---------------------

    public SpiderWeb(int height, int width) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }

        _width = width;
        _height = height;

        buildSpiderWeb();
    }

    private void buildSpiderWeb() {
        // Создаем ячейки
        for (int row = 0; row < height(); row++) {
            _zones.add(new ArrayList<>());
            for (int col = 0; col < width(); col++) {
                _zones.get(row).add(new Zone(row, col));
            }
        }
    }

    private void addZone(ArrayDeque<Zone> queue, ArrayList<Zone> visited, int row, int col){
        if (zone(row, col) != null && !visited.contains(zone(row, col))){
            queue.addLast(zone(row, col));
            visited.add(zone(row, col));
        }
    }

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
}