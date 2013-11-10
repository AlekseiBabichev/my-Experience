package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/*
Заполните массив exceptions 10 различными эксепшенами. Первое исключение уже реализовано в методе initExceptions
*/
public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {
        String s = "abc";//it's first exception
        int[] a = new int[0];
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //it's second exception
        try
        {
            Integer.parseInt(s);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //it's third exception
        try
        {
           System.out.println(a[3]);
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //it's fourth exception
        try
        {
            String s2 = null;
            if (s2.equals(s))
            {

            }
        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //it's fifth exception

            try
            {
                throw new Exception("a");
            }
            catch (Exception e)
            {
                exceptions.add(e);
            }
        try
        {
            throw new Exception("b");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("c");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("d");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("e");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new Exception("f");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }



    }
}
