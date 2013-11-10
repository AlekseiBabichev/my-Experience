package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }

         int count = 0;
        String result = null;

        for (String x : list)
        {
              result = result + x;
              //            for (int i = 0; i < x.length(); i++)
//            {
//                for (int j = 0; j < alphabet.size(); j++)
//                {
//                    count.add(x.indexOf(alphabet.get(j)));
//
//                }
//
//            }
        }
        char[] cResult = result.toCharArray();
        for (int i = 0; i < alphabet.size(); i++)
        {
            for (int j = 0; j < result.length(); j++)
            {
                 if (alphabet.get(i).equals(cResult[j]))
                     count++;
            }
            System.out.println(alphabet.get(i) + " " + count);
            count = 0;
        }
    }

}
