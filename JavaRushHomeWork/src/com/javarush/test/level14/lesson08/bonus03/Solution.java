package com.javarush.test.level14.lesson08.bonus03;

/*

Класс является синглтоном (реализует паттерн(шаблон) Singleton), если позволяет создать всего один объект своего типа.

Реализовать Singleton pattern:
1 создать класс Singleton в отдельном файле.
2 добавить в него статический метод getInstance()
3 метод getIstance должен возвращать один и тот же объект класса Singleton при любом вызове метода getInstance
4 Подумайте, каким образом можно запретить создание других объектов этого класса.
5 Сделайте все конструкторы в классе Singleton приватными (private)

6 В итоге должна быть возможность создать объект (экземпляр класса) ТОЛЬКО используя метод getInstance
*/
public class Solution
{
    public static void main(String[] args)
    {
        Singleton.getInstance();
    }
}
