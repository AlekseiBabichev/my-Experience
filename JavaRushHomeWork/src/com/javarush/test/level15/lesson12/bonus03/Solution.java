package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
   Написать метод, который вичисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
   Пример: factorial(4) = 1*2*3*4 = 24
   1. Ввести с консоли число <=150
   2. Реализовать фукнцию  factorial
   3. Если введенное число <= 0, то вывести 0
*/
public class Solution {
//    static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long input = Long.parseLong(reader.readLine());
        reader.close();

        if (input <= 150){
        System.out.println(factorial(input));
        }
    }

    public static String factorial(long n) {
        if (n <= 0) {
            return "0";
        } else {
//            return "1";
//        } else if (n == 2) {
//            return "2";
//        } else {
//        return Long.toString(n * Long.parseLong(factorial(n - 1)));//add your code here
         BigInteger ret = BigInteger.ONE;
        for (int i = 1; i <= n; ++i) ret = ret.multiply(BigInteger.valueOf(i));
        return ret.toString();
        }

    }
}

