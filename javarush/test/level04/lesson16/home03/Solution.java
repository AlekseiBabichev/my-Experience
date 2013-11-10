package com.javarush.test.level04.lesson16.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)   throws Exception
    {  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int i = 0;
        while (i != -1)
        {
            String si = reader.readLine();
            i = Integer.parseInt(si);
            sum = sum + i;

        }
        System.out.println(sum);
    }
}
