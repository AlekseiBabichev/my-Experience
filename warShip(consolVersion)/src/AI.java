/**
 * <tt></>User</tt> класс который наследуется от <tt>Player</tt> выступает в роли AI
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     GameHelper
 * @see     Field
 * @see     ConstParam
 */

public class AI extends Player {

    /**
     * результат предыдущего выстрела TODO(пока не используется)
     */
    public String theResultOfPreviousShot = "Мимо";

    /**
     * метод который рандомно загадывает координату выстрела
     * TODO пока учитывает только координаты по которым стрелял уже, и больше не палит туда
     * @return возвращает координату
     */
    @Override
    public String guess() {
        int asGuess;
        do {
            asGuess = (int) (Math.random()* ConstParam.GRID_SIZE);
        } while(grid[asGuess] != 0);
        int row = asGuess / ConstParam.GRID_LENGTH;
        int column = asGuess % ConstParam.GRID_LENGTH;
        String temp = String.valueOf(ConstParam.ALPHABET.charAt(column));
        String result = temp.concat(Integer.toString(row));
        System.out.println(result);
        grid[asGuess] = 1;
        return result;
    }
}
