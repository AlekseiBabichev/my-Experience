package com.javarush.test.level07.lesson12.home03;

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

        int  maximum = 0;
        int  minimum = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }
        minimum = list.get(0);
        maximum = list.get(0);
        for (Integer x : list){
            if (minimum > x)
                minimum = x;
            else
                if (maximum < x)
                    maximum = x;
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
