import java.util.ArrayList;

/**
 * <tt></>Ship</tt> класс "корабль" экземпляры которого содержат
 * в себе необходимую информацию для игры: такие как тип корабля,
 * количество палуб(при попадании уменьшается), и саму проверку
 * на попадание
 * @author  Бабичев Алексей
 * @see     WarShipMain
 * @see     GameHelper
 * @see     Field
 * @see     ConstParam
 */
public class Ship {

    /**
     * тип корабля(строковое значение, может быть любым, например:
     * "однопалубник" это только отразится на тексте выводимом в консоль,
     * грубо говоря его имя)
     */
    private String type;

    /**
     * список содержащий координаты каждой палубы кораблей, иначе говоря
     * количество элементов в списке - это количество живых палуб, а значение
     * в них - это сами координаты этих палуб
     */
    private ArrayList<String> locationCells;

    /**
     * конструктор который принимает название типа корабля
     * @param type тип корабля
     */
    public Ship(String type){
        this.type = type;
    }

    /**
     * сеттер для списка содержащего координаты палуб
     * @param locationCells список с палубами
     */
    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    /**
     * метод который сверяет введённые пользователем данные с координатами
     * всех его палуб
     * @param userGuess строка введёная пользователем
     * @return возвращает ключевое слово результата проверки на сделаный ход
     */
    public String checkYourself(String userGuess) {
        String result = "Мимо";
        int index = locationCells.indexOf(userGuess);
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "Потопил";
                System.out.println("Вы потопили " + type);
            } else {
                result = "Попал";
            }
        }
        return result;
    }
}
