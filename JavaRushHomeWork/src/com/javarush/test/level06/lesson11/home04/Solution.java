package com.javarush.test.level06.lesson11.home04;

import java.util.Date;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {

        Date dt = new Date();

        int day;
        day = dt.getDay();
        if (day % 2 == 0)
        {
            System.out.println("Мама мыла раму");
        }
        else
        {
            System.out.println("Рама мыла маму");
        }
        //Напишите тут ваш код
    }
}
