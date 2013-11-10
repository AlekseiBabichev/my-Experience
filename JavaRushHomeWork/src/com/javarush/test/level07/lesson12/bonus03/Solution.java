package com.javarush.test.level07.lesson12.bonus03;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
         removeTheFirstNameDuplicates(createMap());
    }
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Кулин", "Саша");
        map.put("Бабичев", "Алексей");
        map.put("Партута", "Юра");
        map.put("Градов", "Алексей");
        map.put("Кузнецова", "Лена");
        map.put("Сотникова", "Лена");
        map.put("Харин", "Сергей");
        map.put("Корягин", "Дима");
        map.put("Скуратовский", "Сергей");
        map.put("Нету", "Такого");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        for (Map.Entry<String, String> pair2 : map.entrySet())
        {
            String value = pair2.getValue();
            removeItemFromMapByValue(map, value);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
/*
Создать словарь (Map<String, String>)
занести в него десять записей по принципу «фамилия»- «имя».
Удалить людей, имеющих одинаковые имена.
*/
