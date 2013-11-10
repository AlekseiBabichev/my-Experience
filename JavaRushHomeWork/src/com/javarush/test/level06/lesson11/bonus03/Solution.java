package com.javarush.test.level06.lesson11.bonus03;

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
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listReverse = new ArrayList<String>();
        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }
        for (int i = 0; i < list.size(); i++)
        {
            listReverse.add(list.get(list.size() - i - 1));
            System.out.println(listReverse.get(i));
        }

    }
}

