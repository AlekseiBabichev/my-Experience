package com.javarush.test.level13.lesson11.home03;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1 Считать с консоли имя файла
2 Вывести в консоль(на экран) содержимое файла.
3 Не забыть закрыть файл и поток
*/
public class Solution
{
    public static void main(String[] args)
    {
        String name = "Natasha";
        String res = "";
        int i = 1, b = 1;

        for (i=1; i<=10; i++)
        {
            res = res + name + " " ;
        }
        for (b=1; b<=5; b++)
        {
            System.out.println(res);
        }

    }
}