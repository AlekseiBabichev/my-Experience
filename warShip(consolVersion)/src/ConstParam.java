/**
 * <tt></>ConstParam</tt> интерфейс хранящий основные константы
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     GameHelper
 * @see     Field
 * @see     WarShipMain
 */
public interface ConstParam {
    /**
     * количество однопалубников
     */
    int NUMBER_OF_SINGLE_DECKER_SHIPS = 4;
    /**
     * количество двухпалубников
     */
    int NUMBER_OF_DOUBLE_DECKER_SHIPS = 3;
    /**
     * количество трёхпалубников
     */
    int NUMBER_OF_TRIPLE_DECKER_SHIPS = 2;
    /**
     * количество четырёхпалубников
     */
    int NUMBER_OF_FOUR_DECKER_SHIPS = 1;

    /**
     * размер стороны игрового поля
     */
    int GRID_LENGTH = 10;
    /**
     * размер всего игрового поля
     */
    int GRID_SIZE = GRID_LENGTH * GRID_LENGTH;

    /**
     * каждый символ этой строки соответствует определённой строки игрового поля
     */
    String ALPHABET = "abcdefghij";
}
