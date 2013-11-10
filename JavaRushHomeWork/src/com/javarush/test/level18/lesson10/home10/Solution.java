package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        FileOutputStream fos = null;
        List<File> list = new ArrayList<File>();
        File file;
        String fileStr;
        String newFileName;

        try {
            //add all files in list
            while ( ! (fileStr = reader.readLine()).equals("end")) {
                file = new File(fileStr);
                list.add(file);
            }
            //Collections.sort(list);
            File[] files = new File[list.size()];
            files = list.toArray(files);
            for (int i = 0; i < files.length; i++)
            {
                for (int j = i + 1; j < files.length; j++)
                {
                    int a = Integer.parseInt(files[i].getName().substring(files[i].getName().lastIndexOf('.') + 1).substring(4));
                    int b = Integer.parseInt(files[j].getName().substring(files[j].getName().lastIndexOf('.') + 1).substring(4));

                    if (a > b){
                        File buf = files[i];
                        files[i] = files[j];
                        files[j] = buf;
                    }
                }
            }

            for (int i = 0; i < files.length; i++)
            {
                System.out.println(files[i]);
            }

            //create new file in the same dir
            newFileName = list.get(0).getName().substring(0, list.get(0).getName().lastIndexOf('.'));

            File newFile = new File(newFileName);
            newFile.createNewFile();

            //write all files in one
            fos = new FileOutputStream(newFile);
            byte[] buffer = new byte[100];
            int len;
            for (int i = 0; i < files.length; i++)
            {
                fis = new FileInputStream(files[i]);
                while( (len = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
            }

        } catch (IOException e) {
        } finally {
            try {
                reader.close();
            }
            catch (IOException e){}
            if (fis != null) {
                try {
                    fis.close();
                }
                catch (IOException e){}
            }
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e){}
            }
        }

    }
}