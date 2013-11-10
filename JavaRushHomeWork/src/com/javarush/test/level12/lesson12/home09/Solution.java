package com.javarush.test.level12.lesson12.home09;

public class Solution
{

    public static void main(String[] args)
    {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman
    {
        public void workHard();
    }

    public static class CTO extends Rodich implements Businessman
    {

    }


    private static class Rodich
    {
        public void workHard(){

        }
    }
}
