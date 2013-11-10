package com.javarush.test.level07.lesson09.task01;

//Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём массивам:
// Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
// Выведи эти три массива на экран (числа, которые делятся на 3 и на 2,
// например 6, попадают только в первый массив).

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class solution2
{
    public static void main(String[] args) throws Exception
    {
//Напишите тут ваш код
        ArrayList<Integer> m1 = new ArrayList<Integer>(); //главный массив
        ArrayList<Integer> m2 = new ArrayList<Integer>(); //делится на 3
        ArrayList<Integer> m3 = new ArrayList<Integer>(); //делится на 2
        ArrayList<Integer> m4 = new ArrayList<Integer>(); //остальные числа

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//ЗАПОЛНЯЕМ МАССИВ из 20 элементов
        for (int i = 0; i < 20; i++ ){
            int j = Integer.parseInt(reader.readLine());
            m1.add(j);
        }

//СОРТИРУЕМ НА ОСТАЛЬНЫЕ 3 МАССИВА

        for (Integer aM1 : m1)
        {

//в массив идут числа кратные 3
            if (aM1 % 3 == 0)
            {
                m2.add(aM1);

            }
//в массив идут числа кратные 2
            else if (aM1 % 2 == 0)
            {
                m3.add(aM1);

            }
//в массив идут остальные числа
            else
            {
                m4.add(aM1);
            }
        }

        Integer[] arr1 = (Integer[]) m2.toArray();
        Integer[] arr2 = (Integer[]) m3.toArray();
        Integer[] arr3 = (Integer[]) m4.toArray();

//ВЫВОДИМ НА ЭКРАН СНАЧАЛА КРАТНЫЕ ТРЕМ, ДВУМ, ОСТАЛЬНЫЕ ЧИСЛА
        System.out.println(arr1);
//        for (Integer aM2 : m2)
//        {
//            System.out.print(aM2);
//        }
        System.out.println();
        System.out.println(arr2);
//        for (Integer aM3 : m3)
//        {
//            System.out.print(aM3);
//        }
        System.out.println();

        System.out.println(arr3);
//        for (Integer aM4 : m4)
//        {
//            System.out.print(aM4);
//        }

    }
}
