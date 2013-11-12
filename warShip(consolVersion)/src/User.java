/**
 * <tt></>User</tt> класс который наследуется от <tt>Player</tt> выступает в роли пользователя
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     GameHelper
 * @see     Field
 * @see     ConstParam
 */
public class User extends Player {
    /**
     *<tt>helper</tt> этот объект содержит утилитные для игры методы (ввод данных)
     */
    private GameHelper helper = new GameHelper();

    /**
     * метод который считывает с консоли ход игрока
     * @return возвращает координату
     */
    @Override
    public String guess() {
        return helper.getUserInput("Сделайте ход");
    }
}
