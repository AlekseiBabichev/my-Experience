package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 08.11.13
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class Thread2 implements Runnable
{
    @Override
    public void run()
    {
        try
        {
            while (true){
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("InterruptedException");
        }
    }
}
