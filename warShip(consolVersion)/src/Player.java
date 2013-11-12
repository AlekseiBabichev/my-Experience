import java.util.ArrayList;

/**
 * <tt></>Player</tt> абстрактный класс который содержит основные общие черты игроков
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     GameHelper
 * @see     Field
 * @see     ConstParam
 */
public abstract class Player {

    /**
     * матрица с которй работает игрок(стреляет по ней). В неё записываются все
     * простреленные ячейки
     */
    int[] grid = new int[ConstParam.GRID_SIZE];

    /**
     * <tt>field</tt> позволяет создавать поле боя(виртуальный массив), а так же
     * заполнять его кораблями и рисовать в консоль матрицу поля
     */
    public Field field = new Field();

    /**
     *список в который помещяются созданные корабли
     */
    public ArrayList<Ship> shipList = new ArrayList<Ship>();

    /**
     * абстрактный метод который реализуют игроки (загадывание числа)
     * @return возвращает строковое значение координаты
     */
    public abstract String guess();
}
