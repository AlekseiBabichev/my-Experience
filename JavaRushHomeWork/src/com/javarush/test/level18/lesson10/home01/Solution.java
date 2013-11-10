package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int count = 0;
        FileInputStream reader = new FileInputStream(args[0]);

        int line;

        while (reader.available() > 0){
            line = reader.read();
            if (line >= 65 && line <= 90 || line >= 97 && line <= 122){
                count++;
            }
        }

        System.out.println(count);

        reader.close();
    }
}
