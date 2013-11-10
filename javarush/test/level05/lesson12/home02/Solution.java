package com.javarush.test.level05.lesson12.home02;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Алексей", 19, "Мурманск") ;
        Man man2 = new Man("Андрей", 24, "Мурманск");
        Woman woman1 = new Woman("Лена", 17, "Мурманск" );
        Woman woman2 = new Woman("Настя", 20, "Мурманск");

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man{
        private String name;
        private int age;
        private String address;
        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    public static class Woman{
        private String name;
        private int age;
        private String address;
        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
    // Напишите тут ваши классы
}
