package com.javarush.test.level05.lesson12.home04;

import java.util.Scanner;

public class MyMassiv extends Massiv{
    // конструктор по умолчанию
    public MyMassiv() {
        this.mass = new int[1];
            mass[1] = 0;
    }

    // конструктор с параметрами
    public MyMassiv(int row) {
        this.mass = new int[row];

        for (int i = 0; i < row; i++)
            mass[i] = 0;
    }

    @Override
    public int[] Input() {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите массив:");
        for (int i = 0; i < mass.length; i++)
            mass[i] = s.nextInt();
        return mass;
    }

    @Override
    public void Output() {
        for (int mas : mass)
        {
            System.out.print(mas + " ");
            System.out.println();
        }

    }
    @Override
    public void Sort(Massiv a) {
        for (int i = 0; i < mass.length; i++)
        {
            int temp = mass[i];// запомним i-ый элемент
            int j =i-1;//будем идти начиная с i-1 элемента
            while(j >= 0 && mass[j] > temp)
// пока не достигли начала массива
// или не нашли элемент больше i-1-го
// который храниться в переменной temp
            {
                mass[j + 1] = mass[j];
//проталкиваем элемент вверх
                j--;
            }
            mass[j + 1] = temp;
// возвращаем i-1 элемент
        }
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Введите размерность массива А:");
        Massiv A = new MyMassiv(s.nextInt());
        A.Input();
        System.out.println("Массив А:");
        A.Output();

//сортировка массива А
        A.Sort(A);
        System.out.println("отсортированный массив А:");
        A.Output();



    }

}
