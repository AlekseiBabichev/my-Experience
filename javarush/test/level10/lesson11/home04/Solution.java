package com.javarush.test.level10.lesson11.home04;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        System.out.println(s);
        for (int i =0; i < 39; i++)
        {
            s = s.substring(1);
            System.out.println(s);
        }
    }

}
