package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
       for (int i = 0; i<array.length; i++){
           for (int j = 0; j<array.length; j++){
               String a = array[i];
               String b = array [j];
               if (isGreaterThen(a,b)!=true) {
                    array[i] = b;
                    array[j] = a;
               }

           }
       }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
