package ru.Babichev.Aleksei.WarShip_Android.game;

import java.util.ArrayList;

/**
 * <tt></>Player</tt> абстрактный класс который содержит основные общие черты игроков
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     Field
 * @see     ConstParam
 */
public abstract class Player {

    public int[] getGrid() {
        return grid;
    }

    /**
     * матрица с которй работает игрок(стреляет по ней). В неё записываются все
     * простреленные ячейки
     */
    int[] grid = new int[ConstParam.GRID_SIZE];

    private Field field = new Field();

    /**
     *список в который помещяются созданные корабли
     */
    public ArrayList<Ship> shipList = new ArrayList<Ship>();

    /**
     * абстрактный метод который реализуют игроки (загадывание числа)
     * @return возвращает строковое значение координаты
     */
    public String guess(int i, int j){
        String temp = String.valueOf(ConstParam.ALPHABET.charAt(j));
        System.out.println(temp.concat(Integer.toString(i)));
        return temp.concat(Integer.toString(i));
    }

/**
     * <tt>field</tt> позволяет создавать поле боя(виртуальный массив), а так же
     * заполнять его кораблями и рисовать в консоль матрицу поля
     */ public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }}
