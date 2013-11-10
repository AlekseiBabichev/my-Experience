package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader out;

        TreeSet<Integer> list = new TreeSet<Integer>();
        try
        {
            out = new BufferedReader(new FileReader(reader.readLine()));
            String line;
            while (true){
                line = out.readLine();
                if (line == null) break;
                list.add(Integer.parseInt(line));
            }
            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for (int s: list){
            if (s%2 == 0){
                System.out.println(s);
            }
        }

    }
}
