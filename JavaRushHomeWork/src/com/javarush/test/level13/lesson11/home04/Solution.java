package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file = null;
        ArrayList<String> list = new ArrayList<String>();
        try
        {
            file = new File(reader.readLine());
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        String buff;
        try
        {
            while(true){
                buff = reader.readLine();
                list.add(buff);
                if ("exit".equals(buff)) break;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter(file);
            for(String str : list) {
                fileWriter.write(str + "\n");
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally{
            try
            {
                fileWriter.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
