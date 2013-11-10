package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть все потоки ввода-вывода
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        int count = fileInputStream.available();

        if (count < 1000){
            fileInputStream.close();
            fileOutputStream.close();
            throw new DownloadException();
        } else {
            while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            fileOutputStream.write(data);
            }
        }

        fileInputStream.close();
        fileOutputStream.close();

    }

    public static class DownloadException extends Exception{

    }
}
