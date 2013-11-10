package com.javarush.test.level14.lesson08.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Наибольший общий делитель (НОД)
Ввести с клавиатуры 2 целых положительных числа
Вывести в консоль наибольший общий делитель
Например, числа 24 и 16
Результат будет 8, т.к. и 24 и 16 нацело делятся на 8 - максимальное из всех делителей
 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 1;
        int b = 1;
        try
        {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        if (a > 0 && b > 0){
        while (a != 0 && b != 0)
        {
            if (a > b)
                a = a % b;
            else b = b % a;
        }
        System.out.println(a+b);}
    }
}
