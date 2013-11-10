package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 31.05.13
 * Time: 1:57
 * To change this template use File | Settings | File Templates.
 */
public class LatteMaker extends DrinkMaker
{
    @Override
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }

    @Override
    void putIngredient()
    {
        System.out.println("Делаем кофе");
    }

    @Override
    void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
    }
}
