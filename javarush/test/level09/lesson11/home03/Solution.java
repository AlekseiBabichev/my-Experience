package com.javarush.test.level09.lesson11.home03;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        readData();
    }

    public static void readData() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        try
        {
            while (true)
            {
                int i = Integer.parseInt(reader.readLine());
                list.add(i);
            }
        }
        catch (Exception e)
        {
            for (Integer x : list)
            {
                System.out.println(x);
            }
        }
    }
}
