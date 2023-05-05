package Model;

/**
 * Зона
 */
public class Zone{
    /**
     * строка
     */
    private final int _row;

    /**
     * столбец
     */
    private final int _col;

    /**
     * Получить строку {@link Zone#_row}.
     * @return строка.
     */
    public int row() {
        return _row;
    }

    /**
     * Получить столбец {@link Zone#_col}.
     * @return столбец.
     */
    public int col() {
        return _col;
    }

    /**
     * Конструктор
     * @param row строка
     * @param col столбец
     */
    public Zone(int row, int col) {
        _row = row;
        _col = col;
    }

    /**
     * членистоногое
     */
    private Arthropod _arthropod;

    /**
     * Получить членистоногое {@link Zone#_arthropod}.
     * @return членистоногое.
     */
    public Arthropod getArthropod() {
        return _arthropod;
    }

    /**
     * Пустая ли зона
     * @return состояние зоны
     */
    public boolean isEmpty() {
        return (_arthropod == null);
    }

    /**
     * Установить членистоногого {@link Zone#_arthropod}
     * @param arthropod членистоногое
     */
    public void putArthropod(Arthropod arthropod) {
        _arthropod = arthropod;
        arthropod._zone = this;
    }

    /**
     * Вынуть членистоногое из зоны
     */
    public void extractArthropod(){
        if (_arthropod != null) {
            _arthropod._zone = null;
        }
        _arthropod = null;
    }
}