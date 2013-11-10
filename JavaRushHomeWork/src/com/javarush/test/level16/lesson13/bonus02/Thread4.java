package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 08.11.13
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class Thread4 implements Runnable, Message
{
    @Override
    public void showWarning()
    {
        Thread.currentThread().interrupt();
    }

    @Override
    public void run()
    {
        while (true){

        }
    }
}
