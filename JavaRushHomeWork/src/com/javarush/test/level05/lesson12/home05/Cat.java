package com.javarush.test.level05.lesson12.home05;


import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 2/2/13
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */

    public class Cat
    {
        //Напишите тут ваш код
        String name;
        static int catCount = 0;
        public Cat(String name)
        {
            this.name = name;
            catCount++;
            System.out.println(catCount);
        }
        public static void main(String []args)
        {
            Cat vaska = new Cat("Vaksa");
            Cat murzik = new Cat("Murzik");

        }
    }