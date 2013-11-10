package com.javarush.test.level10.lesson11.home10;

public class Solution
{
    public static void main(String[] args)
    {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o)
    {

      // Cat.getName();
    }

    public static class Cat
    {
         public void getName()
        {
            System.out.println("Кошка");
        }
    }

    public static class Dog
    {
        String name = "Собака";
    }

    public static class Bird
    {
        String name = "Птица";
    }

    public static class Lamp
    {
        String name = "Лампа";
    }
}

