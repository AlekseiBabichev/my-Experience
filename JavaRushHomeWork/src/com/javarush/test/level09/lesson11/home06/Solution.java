package com.javarush.test.level09.lesson11.home06;

import java.util.ArrayList;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static LittleRedRidingHood hood = new LittleRedRidingHood();
    public static Grandmother grandmother = new Grandmother();
    public static Patty patty = new Patty();
    public static Woodman woodman = new Woodman();
    public static Wolf wolf = new Wolf();

    public static void main(String[] args)
    {
       patty.ate.add(wolf);
       grandmother.ate.add(patty);
       wolf.ate.add(grandmother);
       woodman.killed.add(wolf);
        hood.ate.add(woodman);
        System.out.println(patty);
        System.out.println(grandmother);
        System.out.println(wolf);
        System.out.println(woodman);
        System.out.println(hood);
    }

    //красная шапочка
    public static class LittleRedRidingHood
    {
        public ArrayList<Object> killed  = new ArrayList<Object>();
        public ArrayList<Object> ate  = new ArrayList<Object>();
    }

    //бабушка
    public static class Grandmother
    {
        public ArrayList<Object> killed  = new ArrayList<Object>();
        public ArrayList<Object> ate  = new ArrayList<Object>();
    }

    //пирожек
    public static class Patty
    {
        public ArrayList<Object> killed  = new ArrayList<Object>();
        public ArrayList<Object> ate  = new ArrayList<Object>();
    }

    //дровосек
    public static class Woodman
    {
        public ArrayList<Object> killed  = new ArrayList<Object>();
        public ArrayList<Object> ate  = new ArrayList<Object>();
    }

    //волк
    public static class Wolf
    {
        public ArrayList<Object> killed  = new ArrayList<Object>();
        public ArrayList<Object> ate  = new ArrayList<Object>();
    }

}
