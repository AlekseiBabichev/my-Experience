package com.javarush.test.level09.lesson11.home01;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {
        try
        {
        int x =  5/0;
        System.out.println(x);
        }
        catch (ArithmeticException e)
        {
            System.out.println("ArithmeticException");
        }
    }
}
