package com.javarush.test.level05.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 13.06.13
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 */
public abstract class Massiv {
    protected int[] mass;

    public abstract int[] Input (); // ввод массива с клавиатуры
    public abstract void Output (); // вывод массива на экран
    public abstract void Sort (final Massiv a); // сортировка
}
