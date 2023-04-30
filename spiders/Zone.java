package Model;

// Зона паутины
public class Zone{
    // ----------------------- Позиция --------------------------

    private final int _row;
    private final int _col;

    public int row() {
        return _row;
    }
    public int col() {
        return _col;
    }

    // ----------------------- Конструтор --------------------------

    public Zone(int row, int col) {
        _row = row;
        _col = col;
    }

    // ------------------------------- Юнит ---------------------------------

    private Arthropod _arthropod;

    public Arthropod getArthropod() {
        return _arthropod;
    }

    public boolean isEmpty() {
        return (_arthropod == null);
    }

    public void putArthropod(Arthropod arthropod) {
        _arthropod = arthropod;
        arthropod._zone = this;
    }

    public void extractArthropod(){
        if (_arthropod != null) {
            _arthropod._zone = null;
        }
        _arthropod = null;
    }
}