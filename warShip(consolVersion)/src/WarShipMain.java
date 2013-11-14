import java.util.ArrayList;

/**
 * <tt></>WarShipMain</tt> класс который содержит основные стартовые методы для игры в морской бой,
 * в том числе и <tt>main</tt> метод.
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     GameHelper
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
    AI ai = new AI();

    /**
     * объект игрока(пользователя)
     */
    User user = new User();

    /**
     * проверка на принадлежность хода игроку
     */
    boolean belongsToTheUserMove = true;

    /**
     *метод подготовки игры. Создаёт и размещает корабли, создаёт и отрисовывает матрицу,
     * а так же выводит брифинг игрока в консоль
     */
    private void setUpGame(){

        ai.field.createEmptyField();
        user.field.createEmptyField();
        
        createShipsAndPlacing(ai, "четырёхпалубник", ConstParam.NUMBER_OF_FOUR_DECKER_SHIPS, 4);
        createShipsAndPlacing(ai, "трёхпалубник",  ConstParam.NUMBER_OF_TRIPLE_DECKER_SHIPS, 3);
        createShipsAndPlacing(ai, "двухпалубник",  ConstParam.NUMBER_OF_DOUBLE_DECKER_SHIPS, 2);
        createShipsAndPlacing(ai, "однопалубник",  ConstParam.NUMBER_OF_SINGLE_DECKER_SHIPS, 1);

        createShipsAndPlacing(user, "четырёхпалубник", ConstParam.NUMBER_OF_FOUR_DECKER_SHIPS, 4);
        createShipsAndPlacing(user, "трёхпалубник",  ConstParam.NUMBER_OF_TRIPLE_DECKER_SHIPS, 3);
        createShipsAndPlacing(user, "двухпалубник",  ConstParam.NUMBER_OF_DOUBLE_DECKER_SHIPS, 2);
        createShipsAndPlacing(user, "однопалубник",  ConstParam.NUMBER_OF_SINGLE_DECKER_SHIPS, 1);



        System.out.println("Ваша цель - потопить все корабли противника.");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов");

        ai.field.drawField();
        user.field.drawField();
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
            ArrayList<String> newLocation = player.field.placeShip(countDeckers);
            ship.setLocationCells(newLocation);
            player.shipList.add(ship);
        }
    }

    /**
     * метод который проверяет в цикле наличие кораблей в списке и в случае
     * их наличия предлагает пользователю сделать ход, а затем отправляет
     * введёную строку на проверку. Когда список пустой, вызывает метод
     * завершения игры
     */
    private void startPlaying(){
        while (!ai.shipList.isEmpty() || !user.shipList.isEmpty()){
            if (belongsToTheUserMove){
                checkUserGuess(ai ,user.guess());
            } else {
                System.out.println("ходит противник");
                checkUserGuess(user, ai.guess());
            }

        }
        finishGame();
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
     */
    private void checkUserGuess(Player player, String userGuess) {

        numOfGuesses++;

        String result = "Мимо";

        for (Ship shipToTest : player.shipList){
            result = shipToTest.checkYourself(userGuess);
            if (result.equals("Попал")){
                break;
            } else if (result.equals("Потопил")){
                player.shipList.remove(shipToTest);
                break;
            }
        }
        if (result.equals("Мимо")) {
            pass(player);
        }
        if (player instanceof User)
        ai.theResultOfPreviousShot = result;
        System.out.println(result);
    }

    /**
     * если мимо, то передать ход другому
     * @param player игрок которому надо передать ход
     */
    private void pass(Player player) {
        if (player instanceof User){
            belongsToTheUserMove = true;
        } else {
            belongsToTheUserMove = false;
        }
    }

    /**
     * главный метод, тут и говорить нечего:)
     * @param args
     */
    public static void main(String[] args) {
        WarShipMain game = new WarShipMain();
        game.setUpGame();
        //game.startPlaying();
    }


}
