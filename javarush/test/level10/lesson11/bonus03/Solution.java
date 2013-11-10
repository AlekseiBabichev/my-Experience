package com.javarush.test.level10.lesson11.bonus03;

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
        int[] array = new int[30];
        for (int i = 0; i < 30; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[10]);
        System.out.println(array[11]);
    }

    public static void sort(int[] array)
    {
        int a;
        for (int i = 0; i < array.length;i++){

            for (int j = 0; j < array.length-1; j++){
                if (array[j]>array[j+1])
                {
                    a = array[j];
                    array[j] = array[j+1];
                    array[j+1] = a;
                }

            }
        }






    }
}
