package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);



        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        Arrays.sort(array);
        int f = 0;
        for (int i = 0; i< array.length/2;i++)
        {
            int first = array[i];
            int last = array[array.length - i - 1];
            array[i] = last;
            array[array.length - i - 1] = first;
        }
    }
}
