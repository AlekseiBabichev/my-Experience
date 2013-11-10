package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2, true);
        FileWriter fileWriterClear = new FileWriter(filename2, false);

        fileWriterClear.write("");

            do
            {
                String DoubleNumber = "";
                char buff;
                do
                {
                    buff = (char) fileReader.read();
                    DoubleNumber += buff;
                }
                while (buff != ' ' && buff != 65535);

                fileWriter.write(DoubleNumber.substring(0, DoubleNumber.indexOf('.')) + " ");
                if (buff == 65535) break;
            }
            while (true);

        fileReader.close();
        fileWriter.close();
    }
}
