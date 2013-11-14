package ru.Babichev.Aleksei.WarShip_Android.game;

import java.util.ArrayList;

/**
 * <tt></>Field</tt> класс который создаёт виртуальный массив(игровое поле),
 * размещает на нём корабли, а так-же создаёт и рисует матрицу с кораблями в консоли
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     WarShipMain
 * @see     ConstParam
 */
public class Field {
    /**
     * виртуальный массив собственной персоной
     */
    private int[] grid = new int[ConstParam.GRID_SIZE];

    /**
     * счётчик кораблей кстановленных на поле, нужен для определения
     * направления кораблей
     */
    private int shipCount = 0;

    public String[][] getField() {
        return field;
    }

    public void setField(String[][] field) {
        this.field = field;
    }

    /**
     * двумерный массив, который хранит рисуется в консоли и хранит координаты кораблей
     */
    private String[][] field = new String[ConstParam.GRID_LENGTH][ConstParam.GRID_LENGTH];

    public int[] getGrid() {
        return grid;
    }

    public void setGrid(int[] grid) {
        this.grid = grid;
    }

    /**
     * метод который размещает новый корабль на поле, а именно:
     * 1) определяет направление
     * 2) ищет доступное место
     * 3) размещает его там
     * 4) генерирует играбельное название координаты и возвращает
     * 5) рисует кораблик на матрице
     * @param ShipSize размер корабля(количество палуб)
     * @return возвращает список с координатами каждой палубы корабля
     */
    public ArrayList<String> placeShip(int ShipSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String temp;

        int direction = calculateDirection();

        int[] coords = findPlace(ShipSize, direction);

        int x = 0;
        int row;
        int column;
        while (x<ShipSize){
            grid[coords[x]] = 1;
            row = coords[x] / ConstParam.GRID_LENGTH;
            column = coords[x] % ConstParam.GRID_LENGTH;
            temp = String.valueOf(ConstParam.ALPHABET.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

            field[row][column] = "#";
        }

        return alphaCells;
    }

    /**
     * метод который определяет направление корабля.
     * С каждым новым кораблём размещённым на поле инкрементируется
     * переменная shipCount, и в зависимости от чётности этого числа
     * определяется направление
     * @return возвращает число которое будет прибавлятся к координате
     * текущего местоположения палубы(если 1, то распологается вертикально,
     * иначе горизонтально)
     */
    private int calculateDirection(){
        shipCount++;
        if ((shipCount % 2) == 1){
            return  ConstParam.GRID_LENGTH;
        } else return 1;
    }

    /**
     * этот метод ищет доступное место на поле для расположения корабля
     * на игровом поле
     * @param ShipSize размер корабля(количество палуб)
     * @param direction направление расположения корабля
     * @return массив координат корабля
     */
    private int[] findPlace(int ShipSize, int direction){
        int[] coords = new int[ShipSize];
        boolean success = false;
        int locationDecker;

        while (!success) {
            locationDecker = (int) (Math.random() * ConstParam.GRID_SIZE);

            int x = 0;
            success = true;

            while (success && x < ShipSize){

                success = checkTheNeighboringElements(locationDecker);
                coords[x++] = locationDecker;
                locationDecker += direction;
                if (locationDecker >= ConstParam.GRID_SIZE){
                    success = false;
                }
                if (x>0 && (locationDecker % ConstParam.GRID_LENGTH == 0)){
                    success = false;
                }

            }
        }
        return coords;
    }

    //всё тлен

    /**
     * проверяет соседние ячейки на использование другим кораблём,
     * если занята хоть одна из них возвращает false, иначе true.
     * Переменные <tt>checkRow</tt> и <tt>checkColumn</tt> хранят в
     * себе значения расположения текущей палубы, а именно <tt>checkRow</tt>
     * хранит строку в виртуальном массиве, а <tt>checkColumn</tt> столбец
     * в которм палуба находится, эти переменные необходимы для проверки
     * расположения палубы в массиве, и позволяет не проверять "не существующие"
     * ячейки. без этих проверок, возникали бы исключения о выходе за границы массива,
     * либо просто некоректно ячейки могополизировали пространство на матрице(в массиве)
     * @param locationDecker ячейка вокруг которой надо проверить
     * @return если занята хоть одна из ячеек возвращает false, иначе true
     */
    private boolean checkTheNeighboringElements(int locationDecker){
        boolean succes = true;
        int checkRow = locationDecker % ConstParam.GRID_LENGTH;
        int checkColumn = locationDecker / ConstParam.GRID_LENGTH;
        if (grid[locationDecker] == 0) {
            if (checkRow == 0){
                if (checkColumn == 0){
                    if (grid[locationDecker + 1] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH] + 1 != 0){
                        succes = false;
                    }
                } else if (checkColumn == ConstParam.GRID_LENGTH - 1) {
                    if (grid[locationDecker + 1] != 0 || grid[locationDecker - ConstParam.GRID_LENGTH] != 0 || grid[locationDecker - (ConstParam.GRID_LENGTH + 1)] != 0){
                        succes = false;
                    }
                } else if (grid[locationDecker + 1] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH + 1] != 0 ||
                        grid[locationDecker - ConstParam.GRID_LENGTH] != 0 || grid[locationDecker - (ConstParam.GRID_LENGTH - 1)] != 0){
                    succes = false;
                }
            } else if (checkRow == ConstParam.GRID_LENGTH - 1){
                if (checkColumn == 0) {
                    if (grid[locationDecker - 1] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH] != 0 || grid[locationDecker + (ConstParam.GRID_LENGTH - 1)] != 0){
                        succes = false;
                    }
                } else if (checkColumn == ConstParam.GRID_LENGTH - 1) {
                    if (grid[locationDecker - 1] != 0 || grid[locationDecker - ConstParam.GRID_LENGTH] != 0 || grid[locationDecker - ConstParam.GRID_LENGTH - 1] != 0){
                        succes = false;
                    }
                } else if (grid[locationDecker - 1] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH] != 0 || grid[locationDecker + (ConstParam.GRID_LENGTH - 1)] != 0 ||
                        grid[locationDecker - ConstParam.GRID_LENGTH] != 0 || grid[locationDecker - ConstParam.GRID_LENGTH - 1] != 0){
                    succes = false;
                }
            } else if (checkColumn == 0){
                if (grid[locationDecker - 1] != 0 || grid[locationDecker + 1] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH] != 0 ||
                        grid[locationDecker + (ConstParam.GRID_LENGTH - 1)] != 0 || grid[locationDecker + (ConstParam.GRID_LENGTH + 1)] != 0){
                    succes = false;
                }
            } else if (checkColumn == ConstParam.GRID_LENGTH -1) {
                if (grid[locationDecker - 1] != 0 || grid[locationDecker + 1] != 0 || grid[locationDecker - ConstParam.GRID_LENGTH] != 0 ||
                        grid[locationDecker - (ConstParam.GRID_LENGTH - 1)] != 0 || grid[locationDecker - (ConstParam.GRID_LENGTH + 1)] != 0){
                    succes = false;
                }
            } else if (grid[locationDecker - 1] != 0 || grid[locationDecker + 1] != 0 || grid[locationDecker + ConstParam.GRID_LENGTH] != 0 ||
                    grid[locationDecker + (ConstParam.GRID_LENGTH - 1)] != 0 || grid[locationDecker + (ConstParam.GRID_LENGTH + 1)] != 0 ||
                    grid[locationDecker - ConstParam.GRID_LENGTH] != 0 || grid[locationDecker - (ConstParam.GRID_LENGTH - 1)] != 0 ||
                    grid[locationDecker - (ConstParam.GRID_LENGTH + 1)] != 0) {
                succes = false;
            }
        } else {
//                    System.out.println("Используется " + locationDecker);
            succes = false;
        }

        return succes;
    }

    /**
     * заполнет пустую матрицу точками
     */
    public void createEmptyField(){
        for (int i = 0; i < ConstParam.GRID_LENGTH; i++) {
            for (int j = 0; j < ConstParam.GRID_LENGTH; j++) {
                field[j][i] = ".";
            }
        }
    }

    /**
     * выводит матрицу(игровое поле) на консоль
     */
    public void drawField(){

        System.out.print("   ");

        for (int i = 0; i < ConstParam.GRID_LENGTH; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < ConstParam.GRID_LENGTH; i++) {
            System.out.print(String.valueOf(ConstParam.ALPHABET.charAt(i)) + "  ");
            for (int j = 0; j < ConstParam.GRID_LENGTH; j++) {
                System.out.print(field[j][i] + " ");
            }
            System.out.println();


        }
    }


}
