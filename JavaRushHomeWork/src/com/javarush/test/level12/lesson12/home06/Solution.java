package com.javarush.test.level12.lesson12.home06;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Run
    {
        public void run();
    }

    public interface Swim
    {
        public void swim();
    }

    public class Cat implements Run
    {
        @Override
        public void run()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Dog implements Run, Swim
    {
        @Override
        public void run()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void swim()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Tiger extends Cat implements Swim
    {
        @Override
        public void run()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void swim()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Lion extends Cat
    {
        @Override
        public void run()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
