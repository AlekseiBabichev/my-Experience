package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 08.11.13
 * Time: 12:16
 * To change this template use File | Settings | File Templates.
 */
public class Thread3 implements Runnable
{
    @Override
    public void run()
    {
        while (true){
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            System.out.println("Ура");
        }
    }
}
