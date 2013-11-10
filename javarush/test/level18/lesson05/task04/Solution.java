package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try
        {
            fileInputStream = new FileInputStream(reader.readLine());
            fileOutputStream = new FileOutputStream(reader.readLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            for (int i = count - 1; i >= 0; i--)
            {
                fileOutputStream.write(buffer[i]);
            }
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
