package com.javarush.test.level05.lesson12.home04;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
        public static void main(String[] s) {
        for (int i = 2; i < 10; i = i++ + i--, i++) {
            System.out.print(--i + " ");
        }
    }
}