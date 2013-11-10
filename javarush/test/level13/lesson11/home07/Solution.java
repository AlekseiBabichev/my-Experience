package com.javarush.test.level13.lesson11.home07;

/*
1 Создайте класс StringObject
2 В классе StringObject реализуйте интерфейс SimpleObject с параметром типа String.
3 Программа должна компилироваться.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
       SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }
    public static class StringObject<Object> implements SimpleObject<String>
    {

        @Override
        public SimpleObject<String> getInstance()
        {
            return null;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

}
