package ru.Babichev.Aleksei.WarShip_Android.game;

import java.util.ArrayList;

/**
 * <tt></>WarShipMain</tt> класс который содержит основные стартовые методы для игры в морской бой,
 * в том числе и <tt>main</tt> метод.
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     Field
 * @see     ConstParam
 */
public class WarShipMain {
    /**
     * количество попыток сделаных игроком, инкрементируется с каждым ходом
     */
    private int numOfGuesses;

    /**
     * объект противника AI
     */
    private AI ai = new AI();

    /**
     * объект игрока(пользователя)
     */
    private User user = new User();

    /**
     * проверка на принадлежность хода игроку
     */
    private boolean belongsToTheUserMove = true;

    /**
     *метод подготовки игры. Создаёт и размещает корабли, создаёт и отрисовывает матрицу,
     * а так же выводит брифинг игрока в консоль
     */
    public void setUpGame(){

        ai.getField().createEmptyField();
        user.getField().createEmptyField();
        
        createShipsAndPlacing(ai, "четырёхпалубник", ConstParam.NUMBER_OF_FOUR_DECKER_SHIPS, 4);
        createShipsAndPlacing(ai, "трёхпалубник",  ConstParam.NUMBER_OF_TRIPLE_DECKER_SHIPS, 3);
        createShipsAndPlacing(ai, "двухпалубник",  ConstParam.NUMBER_OF_DOUBLE_DECKER_SHIPS, 2);
        createShipsAndPlacing(ai, "однопалубник",  ConstParam.NUMBER_OF_SINGLE_DECKER_SHIPS, 1);

        createShipsAndPlacing(user, "четырёхпалубник", ConstParam.NUMBER_OF_FOUR_DECKER_SHIPS, 4);
        createShipsAndPlacing(user, "трёхпалубник",  ConstParam.NUMBER_OF_TRIPLE_DECKER_SHIPS, 3);
        createShipsAndPlacing(user, "двухпалубник",  ConstParam.NUMBER_OF_DOUBLE_DECKER_SHIPS, 2);
        createShipsAndPlacing(user, "однопалубник",  ConstParam.NUMBER_OF_SINGLE_DECKER_SHIPS, 1);

        for (int i = 0; i < ConstParam.GRID_SIZE; i++) {
            user.getGrid()[i] = 0;
            ai.getGrid()[i] = 0;
        }


        System.out.println("Ваша цель - потопить все корабли противника.");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        ai.getField().drawField();
        user.getField().drawField();
    }

    /**
     * Метод который создаёт и размещает корабли на поле,
     * а так же сохраняет их в список
     * @param player игрок
     * @param type тип корабля(строковый), например: "однопалубник" и т.д.
     * @param countShip количество кораблей данного типа
     * @param countDeckers количество палуб у кораблей
     */
    private void createShipsAndPlacing(Player player, String type, int countShip, int countDeckers){
        Ship ship;
        for (int i = 0; i < countShip; i++) {
            ship = new Ship(type);
            ArrayList<String> newLocation = player.getField().placeShip(countDeckers);
            ship.setLocationCells(newLocation);
            player.shipList.add(ship);
        }
    }

    /**
     * метод который проверяет в цикле наличие кораблей в списке и в случае
     * их наличия предлагает пользователю сделать ход, а затем отправляет
     * введёную строку на проверку. Когда список пустой, вызывает метод
     * завершения игры
     * @param i
     * @param j
     */
    public int startUserStep(int i, int j){
        int result = checkUserGuess(ai ,user.guess(i, j), i, j);
        if (ai.shipList.isEmpty() || user.shipList.isEmpty()) finishGame();
        return result;
    }

    public int aiShot(int row, int column) {

        int result = checkUserGuess(user, ai.guess(row, column), row, column);
        return result;
    }

    /**
     * метод который выводит в консоль результат проведённой игры
     */
    private void finishGame() {
       if (user.shipList.isEmpty()){
           System.out.println("Вы проиграли!");
       } else {
           System.out.println("Вы выиграли!");
       }
    }

    /**
     * этот метод отправляет на дальнейшею проверку строку введёную пользователем
     * или загаданную компьютером и после проверки выводит в консоль результат
     * сделанного хода. Так-же он инкрементирует количество сделанных ходов
     * @param player противоположный ходящему игрок
     * @param userGuess загаданые координаты
     * @param i
     * @param j
     */
    private int checkUserGuess(Player player, String userGuess, int i, int j) {

        numOfGuesses++;

        String result = "Мимо";
        int bResult = 0;

        for (Ship shipToTest : player.shipList){
            result = shipToTest.checkYourself(userGuess);
            if (result.equals("Попал")){
                bResult = 1;
                break;
            } else if (result.equals("Потопил")){
                player.shipList.remove(shipToTest);
                bResult = 2;
                break;
            }
        }
        int asGuess = (i*10)+j;
        if (result.equals("Мимо")){
            pass();
            player.grid[asGuess] = 2;
        } else {
            player.grid[asGuess] = 1;
        }

        System.out.println(result);
        return bResult;
    }

    /**
     * если мимо, то передать ход другому
     */
    private void pass() {
        belongsToTheUserMove = !belongsToTheUserMove;
    }


    public int getNumOfGuesses() {
        return numOfGuesses;
    }

    public void setNumOfGuesses(int numOfGuesses) {
        this.numOfGuesses = numOfGuesses;
    }

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isBelongsToTheUserMove() {
        return belongsToTheUserMove;
    }

    public void setBelongsToTheUserMove(boolean belongsToTheUserMove) {
        this.belongsToTheUserMove = belongsToTheUserMove;
    }
}
