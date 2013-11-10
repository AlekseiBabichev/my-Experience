package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int a = 0;
        for (int i = 0; i<10; i++)
        {
            a = Integer.parseInt(reader.readLine());
            if (maximum<a)
                maximum = a;
        }

        //напишите здесь ваш код




        System.out.println(maximum);

    }
}
