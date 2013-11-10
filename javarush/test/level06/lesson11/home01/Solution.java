package com.javarush.test.level06.lesson11.home01;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
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
        Cat cat7= new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        Cat cat10 = new Cat();


        System.out.println(Cat.catCount);
    }

    public static class Cat
    {   public static int catCount;
        //Напишите тут ваш код

        public Cat()
        {

            catCount++;
        }
    }

}
