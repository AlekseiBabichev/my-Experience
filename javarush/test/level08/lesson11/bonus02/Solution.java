package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        //list of addresses
        Map<String, String> addresses = new HashMap<String, String>();
        while (true)
        {
            String town = reader.readLine();
            if (town.isEmpty()) break;
            String family = reader.readLine();


            addresses.put(town, family);
        }

        //read home number
        String townRead = reader.readLine();

        if (addresses.containsKey(townRead))
        {
            String familySecondName = addresses.get(townRead);
            System.out.println(familySecondName);
        }
    }
}
