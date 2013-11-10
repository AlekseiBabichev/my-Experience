package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 31.05.13
 * Time: 1:53
 * To change this template use File | Settings | File Templates.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }

}
