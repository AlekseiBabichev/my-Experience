package com.javarush.test.level14.lesson08.home09;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/12/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Singleton
{
    private static Singleton singleton = new Singleton();

    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        return singleton;

    }
}
