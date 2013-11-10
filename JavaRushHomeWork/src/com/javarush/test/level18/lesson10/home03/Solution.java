package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine(), true);
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        while (fileInputStream1.available() > 0){
            int data = fileInputStream1.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileInputStream1.close();
        fileOutputStream.close();

    }
}
