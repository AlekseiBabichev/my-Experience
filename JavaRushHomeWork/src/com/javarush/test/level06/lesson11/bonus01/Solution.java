package com.javarush.test.level06.lesson11.bonus01;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static int max = 100;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int max;
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        max = a > b ? a : b;

        System.out.println("Max is " + max);
    }

}
