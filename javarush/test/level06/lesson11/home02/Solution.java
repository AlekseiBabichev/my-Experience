package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/*
 Создай класс кот - Cat. В нем создай статическую переменную cats (ArrayList &lt;Cat&gt;). Пусть при каждом создании кота (нового объекта Cat), в переменную cats добавляется этот новый кот.
 Создать 10 объектов Cat, и вывести их всех на экран, пользуясь переменной cats.
 */
public class Solution
{
    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        Cat cat10 = new Cat();//Напишите тут ваш код

        for (int i=0;i<Cat.cats.size();i++)
        {
            System.out.println(Cat.cats.get(i));
        }

    }

    public static class Cat
    {
        static ArrayList<Cat> cats = new ArrayList<Cat>();//Напишите тут ваш код

        public Cat()
        {
            cats.add(this);
        }
    }

}
