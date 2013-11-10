package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();


        char[] a = s.toCharArray(); //разбили строку на массив символов;

        for (int i = 0; i < a.length; i++) { //перебераем массив по очереди;
          //  a[0] = Character.toUpperCase(a[0]); //с помощью этого стандартного метода класса Чарактер делаем 1й символ
//большим (если символ - не маленькая буква, то ничего не изменится);
            if (a[i] == ' ' && i < (a.length - 1)) { //это условие говорит: "если на і-том месте стоит пробел,
                a[i + 1] = Character.toUpperCase(a[i + 1]); //и значение і меньше, чем номер последнего элемента
            } //массива, то следующий элемент обрабатываем тем же методом;
        }

        String t = new String(a); //создаем новую строку из массива символов (в принципе можно записать в старую
//переменную s для экономии памяти;
        System.out.println(t); //и выводим на экран =);
    }

}

