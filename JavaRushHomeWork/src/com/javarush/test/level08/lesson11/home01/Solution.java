package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        for (Cat cat : cats)
        {
            cats.remove(cat);
            break;
        }

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> cats = new HashSet<Cat>();
        Cat cat = new Cat();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        cats.add(cat);
        cats.add(cat1);
        cats.add(cat2);
        return cats;
    }

    public static void printCats(Set<Cat> cats)
    {
        for (Cat cat: cats)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        String name;
    }


}
