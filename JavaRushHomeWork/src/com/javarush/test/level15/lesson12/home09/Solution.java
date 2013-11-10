package com.javarush.test.level15.lesson12.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Парсер реквестов
Считать с консоли URl ссылку
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются & , например, lvl=15)
URL содержит минимум 1 параметр
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
 */
public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = null;
        String argsValueObj = null;
        try
        {
            url = reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String arguments = url.substring(url.indexOf('?') + 1);
//        System.out.println(arguments);
        String[] arrayArgsAndValue = arguments.split("&");

        String[] arrayArgs = new String[arrayArgsAndValue.length];
        for (int i = 0; i < arrayArgsAndValue.length; i++)
        {
            if (arrayArgsAndValue[i].indexOf('=') == -1){
                arrayArgs[i] = arrayArgsAndValue[i];
            } else
            arrayArgs[i] = arrayArgsAndValue[i].substring(0, arrayArgsAndValue[i].indexOf('='));
        }

        for (int i = 0; i < arrayArgs.length; i++)
        {
            System.out.print(arrayArgs[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arrayArgsAndValue.length; i++)
        {
            if (arrayArgs[i].equals("obj")){
               argsValueObj = arrayArgsAndValue[i].substring(arrayArgsAndValue[i].indexOf('=')+1);
                try{
                    alert(Double.parseDouble(argsValueObj));
                } catch (Exception e) {
                    alert(argsValueObj);
                }
            }
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
