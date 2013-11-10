package com.javarush.test.level07.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listMultiply = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++)
        {
            String s = list.get(i);
            if (s.length() % 2 == 0)
                s += " "+ s;
            else
                s += " "+ s + " "+ s;
            listMultiply.add(s);
        }

        for (int i = 0; i < listMultiply.size(); i++)
        {
            System.out.println(listMultiply.get(i));
        }
    }
}
