package com.javarush.test.level14.lesson08.bonus03;


public class Singleton
{
    private static Singleton instance;
    private Singleton()
    {
    }

    static Singleton getInstance()
    {
        if (instance == null)
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        return instance;
    }
}

