package com.javarush.test.level05.lesson12.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
   public static void main(String[] args) throws IOException
   {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sa = reader.readLine();
        int a = Integer.parseInt(sa);
        String sb = reader.readLine();
       int b = Integer.parseInt(sb);


        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
