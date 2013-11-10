package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = null;
        FileOutputStream fileInputStream1 = null;
        FileOutputStream fileInputStream2 = null;

        try
        {
            fileInputStream = new FileInputStream(reader.readLine());
            fileInputStream1 = new FileOutputStream(reader.readLine());
            fileInputStream2 = new FileOutputStream(reader.readLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if (fileInputStream.available() > 0 && fileInputStream.available() % 2 != 0){
            int count = fileInputStream.available()/2;

            byte[] buffer = new byte[count + 1];
            fileInputStream.read(buffer);
            fileInputStream1.write(buffer, 0, count + 1);
            fileInputStream.read(buffer);
            fileInputStream2.write(buffer, 0, count);
            
        } else {
            int count = fileInputStream.available()/2;

            byte[] buffer = new byte[count];
            fileInputStream.read(buffer);
            fileInputStream1.write(buffer, 0, count);
            fileInputStream.read(buffer);
            fileInputStream2.write(buffer, 0, count);
        }



    }
}
