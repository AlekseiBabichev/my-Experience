package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Solution
{
    public static void main(String[] args)
    {
        Human child1 = new Human("sina1", true, 18);
        Human child2 = new Human("docha", false, 16);
        Human child3 = new Human("sina2", true, 14);
        Human mother = new Human("mamka", false, 40, child1,child2,child3);
        Human father = new Human("papka", true, 45, child1,child2,child3);
        Human babka1 = new Human("babka1", false, 60, mother);
        Human babka2 = new Human("babka2", false, 65, father);
        Human ded1 = new Human("ded1", true, 66, mother);
        Human ded2 = new Human("ded2", true, 71, father);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(babka1);
        System.out.println(babka2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);



    }

    public static class Human
    {
        private String name;//Написать тут ваш код
        private boolean sex;
        private int age;
        private ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, boolean sex, int age, Human... childrens){
            this.name = name;
            this.age = age;
            this.sex = sex;

            Collections.addAll(this.children, childrens);
        }



        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
