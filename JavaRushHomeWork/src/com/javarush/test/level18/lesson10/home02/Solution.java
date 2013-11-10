package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int fullCount = fileInputStream.available();
        int spaceCount = 0;

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (data == ' ') spaceCount++;
        }
        double result = (double) spaceCount/fullCount * 100;
        System.out.println(new BigDecimal(result).setScale(2, BigDecimal.ROUND_DOWN));

        fileInputStream.close();
    }
}
