package com.javarush.test.level05.lesson12.home05;

import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         String sa = null;
        int sum = 0;
        while (sa != "сумма")
        {
            sa = reader.readLine();
            if (!(sa.equals("сумма"))){
                int a = Integer.parseInt(sa);
                sum = sum + a;
            }  else
                break;
        }
        System.out.println(sum);

    }
}
