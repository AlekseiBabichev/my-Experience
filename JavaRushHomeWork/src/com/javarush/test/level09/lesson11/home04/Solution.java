package com.javarush.test.level09.lesson11.home04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {
        Date currentDate = new Date();
        SimpleDateFormat TIMESTAMP = new SimpleDateFormat("'APR' dd, yyyy");
        System.out.println(TIMESTAMP.format(currentDate));
    }
}
