package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Кулин", "Саша");
        map.put("Бабичев", "Алексей");
        map.put("Партута", "Юра");
        map.put("Корягин", "Алексей");
        map.put("Кузнецова", "Лена");
        map.put("Сотникова", "Лена");
        map.put("Харин", "Сергей");
        map.put("Корягин", "Дима");
        map.put("Скуратовский", "Сергей");
        map.put("Нету", "Такого");

        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
