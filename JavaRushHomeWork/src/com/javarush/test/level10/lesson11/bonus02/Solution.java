package com.javarush.test.level10.lesson11.bonus02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/*
 Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
 Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.Пустая строка – конец ввода данных. Числа могу повторяться. Строки всегда уникальны. Введенные данные не должны потеряться!
 Затем программа выводит содержание HashMap на экран.
 Пример ввода:
 1
 Мама
 2
 Рама

 Пример вывода:
 1 Мама
 2 Рама
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new HashMap<String,Integer>();

        int id = 0;
        String name = "";

        do {

            try
            {
                id = Integer.parseInt(reader.readLine());
                name = reader.readLine();
                map.put(name,id);
            }
            catch (Exception e)
            {
                break;
            }

        } while(true);

        printPeopleList(map);
    }

    public static void printPeopleList( Map<String, Integer> map )
    {
        for ( Map.Entry<String, Integer> s : map.entrySet() )
        {
            System.out.println( s.getValue() + " " + s.getKey() );
        }
    }

}