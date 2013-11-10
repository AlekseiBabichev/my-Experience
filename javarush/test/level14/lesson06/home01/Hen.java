package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/11/13
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Hen
{
    abstract int getCountOfEggsPerMonth();

    public String getDescription()
    {
        return "Я курица.";
    }
}
