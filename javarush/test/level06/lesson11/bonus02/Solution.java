package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dedName = reader.readLine();
        Cat catDed = new Cat(dedName);

        String babkaName = reader.readLine();
        Cat catBabka = new Cat(babkaName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName,null, catDed);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catBabka, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catDed);
        System.out.println(catBabka);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            if (mother == null && father == null)
                return "Cat name is " + name + ", no mother, no father";
            else
            if (mother == null)
                return "Cat name is " + name + ", no mother, father is "+ father.name;
            else
                if (father == null)
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
                else
                    return "Cat name is " + name + ", mother is " + mother.name + ", father is "+ father.name;
        }
    }

}
