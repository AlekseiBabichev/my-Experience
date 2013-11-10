package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Set;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> cats = new HashSet<Cat>();

        for (int i = 0; i < 4; i++)
        {
            cats.add(new Cat());
        }

        return cats;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> dogs = new HashSet<Dog>();

        for (int i = 0; i < 3; i++)
        {
            dogs.add(new Dog());
        }

        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        HashSet pets = new HashSet();

        pets.addAll(cats);
        pets.addAll(dogs);

        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        for (Object cat : cats)
        pets.remove(cat);
    }

    public static void printPets(Set<Object> pets)
    {
        for (Object pet : pets)
        {
            System.out.println(pet);
        }

        System.out.println();
    }

    public static class Cat
    {

    }

    public static class Dog
    {

    }


}
