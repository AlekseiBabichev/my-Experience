package com.javarush.test.level04.lesson16.home02;

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
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sa = reader.readLine();
        String sb = reader.readLine();
        String sc = reader.readLine();
        int a = Integer.parseInt(sa);
        int b = Integer.parseInt(sb);
        int c = Integer.parseInt(sc);

        if (a < b && b <c || c < b && b <a)
            System.out.println(b);
        else if (b<a && a<c || c<a && a<b)
            System.out.println(a);
        else if (a<c && c<b || b<c && c<a)
            System.out.println(c);



    }
}
