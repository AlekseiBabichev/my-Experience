package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (map.containsKey(data)){
                map.put(data, (map.get(data)) + 1);
            } else {
                map.put(data, 1);
            }
        }
        fileInputStream.close();

        int max = 0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            Integer value = pair.getValue();
            if (value > max) max = value;
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == max){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
