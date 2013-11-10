package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 08.11.13
 * Time: 12:21
 * To change this template use File | Settings | File Templates.
 */
public class Thread5 implements Runnable
{
    @Override
    public void run()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int summ = 0;
        int buf = 0;
        while (true){
            try
            {
                String sBuf = reader.readLine();
                if ("N".equals(sBuf)){
                    System.out.println(summ);
                    break;
                }
                summ += Integer.parseInt(sBuf);

            }
            catch (IOException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
