package com.javarush.test.level16.lesson03.task01;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 17.08.13
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
public class TestThread implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("My first thread");
    }
}
