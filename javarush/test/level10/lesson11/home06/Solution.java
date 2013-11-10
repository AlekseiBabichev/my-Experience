package com.javarush.test.level10.lesson11.home06;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        int height = 160;
        String name;
        int age = 18;
        boolean sex = true;
        String familiya;
        boolean car = false;

        public Human(){

        }
        public Human(String name, String familiya){
            this.name = name;
            this.familiya = familiya;
        }
        public Human(String name, String familiya, int age){
            this.name = name;
            this.familiya = familiya;
            this.age = age;
        }
        public Human(String name, String familiya, int age, boolean sex){
            this.name = name;
            this.familiya = familiya;
            this.age = age;
            this.sex = sex;
        }
        public Human(String name, String familiya, int age, boolean sex, int height){
            this.name = name;
            this.familiya = familiya;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }
        public Human(String name, String familiya, int age, boolean sex, int height, boolean car){
            this.name = name;
            this.familiya = familiya;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.car = car;
        }
        public Human(String name) {
            this.name = name;
        }
        public Human(String name, String familiya, int age, boolean sex, boolean car){
            this.name = name;
            this.familiya = familiya;
            this.age = age;
            this.sex = sex;
            this.car = car;
        }
        public Human(String name, int age, boolean sex, int height, boolean car){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.car = car;
        }
        public Human(String name, String familiya, boolean sex, int height, boolean car){
            this.name = name;
            this.familiya = familiya;
            this.sex = sex;
            this.height = height;
            this.car = car;
        }

    }
}
