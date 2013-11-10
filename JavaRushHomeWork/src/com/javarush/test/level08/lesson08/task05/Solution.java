package com.javarush.test.level08.lesson08.task05;

import java.util.*;

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String,String> map = new HashMap<String, String>();
        map.put("1","алексей");
        map.put("2","вася");
        map.put("3","петя");
        map.put("4","алексей");
        map.put("5","саша");
        map.put("6","паша");
        map.put("7","алексей");
        map.put("8","дмитрий");
        map.put("9","саша");
        map.put("10","лена");
        // /Напишите тут ваш код
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
//Напишите тут ваш код
        Set<String> setNames = new HashSet<String>();
        Set <String> duplicateNames = new HashSet<String>();

                        for ( Map.Entry<String, String> pair : map.entrySet() )
                {
                           String name = pair.getValue();

                            if ( setNames.contains( name ) )
                    {
                                duplicateNames.add( name );
                    }
                    else
                    {
                               setNames.add( name );
                   }
               }

                        for ( String name : duplicateNames )
                {
                            removeItemFromMapByValue( map, name );
                }
//        System.out.println(map);
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

//    public static void main(String[] args) {
//        removeTheFirstNameDuplicates(createMap());
//    }
}
