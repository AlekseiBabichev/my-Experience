package com.javarush.test.level04.lesson16.home04;

public class Cat
{
    public String name;
    public int age = 2;
    public int weight = 3;
    public int strength = 20;

    public Cat()
    {

    }

    Cat cat = new Cat();
    public boolean fight (Cat anotherCat)
    {

        if  ((cat.age > (anotherCat.age +1)) || (cat.weight > (anotherCat.weight +1)) || (cat.strength > (anotherCat.strength +5)))
            return true;
        else
            return false;

    }
}

