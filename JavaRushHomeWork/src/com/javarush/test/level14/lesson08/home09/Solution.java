package com.javarush.test.level14.lesson08.home09;

import java.util.ArrayList;
import java.util.List;

/*
1 Реализуйте метод getAmount в классе Money:
1.1 Подумайте, какого типа нужно создать приватную переменную, если метод getAmount будет ее возвращать
1.2 Создайте приватную переменную этого типа и верните ее в методе getAmount
1.3 В конструкторе присвойте ей значение, полученное параметром
2 В отдельном файле создайте класс Hrivna
3 Наследуйте класс Hrivna от класса Money
4 В классе Hrivna реализуйте метод getCurrencyName, который возвращает "HRN"
5 В отдельном файле создайте класс USD
6 Наследуйте класс USD от класса Money
7 В классе USD реализуйте метод getCurrencyName, который возвращает "USD"
8 Подумайте, объекты каких классов можно добавить в список(лист) allMoney
9 Добавить в конструктор класса Person заполнение листа allMoney объектами всех возможных классов
*/
public class Solution
{
    public static void main(String[] args)
    {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney())
        {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person
    {
        public String name;

        Person(String name)
        {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            allMoney.add(new USD(10));
            allMoney.add(new Hrivna(50));//Add your code here
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney()
        {
            return allMoney;
        }
    }
}
