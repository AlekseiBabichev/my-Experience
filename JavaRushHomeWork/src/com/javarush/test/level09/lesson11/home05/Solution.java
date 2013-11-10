package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 Написать программу, которая вводит с клавиатуры строку текста.
 Программа должна вывести на экран две строки: первая строка содержит только гласные, а вторая  - только согласные буквы из введённой строки.
 Пример ввода:
 Мама мыла раму.
 Пример вывода:
 а а  ы а  а у
 М м  м л  р м .
 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuffer vovelString = new StringBuffer();
        StringBuffer soglasString = new StringBuffer();

        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] == ' ') {vovelString.append(c[i]);
            vovelString.append(' ');
            } else
            if (isVowel(c[i])){
                vovelString.append(c[i]);
                vovelString.append(' ');
            }
        }
        System.out.println();
        for (int i = 0; i < c.length; i++)
        {
            if (!isVowel(c[i])){
               soglasString.append(c[i]);
                soglasString.append(' ');
            }
        }
        System.out.println(vovelString);
        System.out.println(soglasString);//Написать тут ваш код
    }

    public static char[] soglas = new char[]{'й', 'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ъ',
                                            'ф', 'в', 'п', 'р', 'л', 'д', 'ж', 'ч', 'с', 'м',
                                            'т', 'ь', 'б', 'Й', 'Ц', 'К', 'Н', 'Г', 'Ш', 'Щ',
                                            'З', 'Х', 'Ъ', 'Ф', 'В', 'П', 'Р', 'Л', 'Д', 'Ж',
                                            'Ч', 'С', 'М', 'Т', 'Ь', 'Б',' '};

    //метод проверяет, гласная ли буква
    public static boolean isSoglas(char c)
    {
//        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : soglas)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё',
                                             'А', 'Я', 'У', 'Ю', 'И', 'Ы', 'Э', 'Е', 'О', 'Ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
//        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
