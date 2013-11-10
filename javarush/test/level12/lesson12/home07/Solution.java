package com.javarush.test.level12.lesson12.home07;

/*
 Напиши интерфейсы Fly(летать), Swim(плавать), Run(бегать).
 Добавь эти интерфейсы классам Duck(утка), Penguin(пингвин), Toad(жаба), CaptainJackSparrow(Капитан Джек Воробей).
 */
public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Run
    {
        public void run();
    }

    public interface Swim
    {
        public void swim();
    }

    public class Duck
    {
       //не может бегать
    }

    public class Penguin
    {

    }

    public class Toad
    {

    }

    public class CaptainJackSparrow //Капитан Джек Воробей :)
    {

    }
}
