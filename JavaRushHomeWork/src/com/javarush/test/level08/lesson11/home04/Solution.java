package com.javarush.test.level08.lesson11.home04;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        int min = minValue(createList());
        printMin(min);
    }

    public static ArrayList<Integer> createList() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

         ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++)
        {
            list.add(Integer.parseInt(reader.readLine()));
        }


        return list;
    }

    public static int minValue(ArrayList<Integer> list)
    {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++)
        {
            if (min > list.get(i))
                min = list.get(i);
        }


        return min;
    }

    public static void printMin (int min)
    {
         System.out.println(min);
    }
}
