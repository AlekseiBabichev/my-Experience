package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/*
 Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
 */
public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] arrayOfStringList = new ArrayList[3];
        arrayOfStringList[0] = new ArrayList<String>();
        arrayOfStringList[0].add("мама");
        arrayOfStringList[0].add("мыла");
        arrayOfStringList[0].add("раму");

        arrayOfStringList[1] = new ArrayList<String>();
        arrayOfStringList[1].add("иди");
        arrayOfStringList[1].add("говно");
        arrayOfStringList[1].add("чистить");

        arrayOfStringList[2] = new ArrayList<String>();
        arrayOfStringList[2].add("я");
        arrayOfStringList[2].add("тут");
        arrayOfStringList[2].add("насру");

//        arrayOfStringList[3] = new ArrayList<String>();
//        arrayOfStringList[3].add("и");
//        arrayOfStringList[3].add("все");
//        arrayOfStringList[3].add("мухи");
//        arrayOfStringList[3].add("слетятся");


        return arrayOfStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}