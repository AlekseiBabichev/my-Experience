package com.javarush.test.level07.lesson12.home06;

/**
 * User: General
 * Date: 12/21/12
 * Time: 11:59 PM
 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {

        Human ded1 = new Human("ded1", true, 60, null, null);
        Human ded2 = new Human("ded2", true, 63, null, null);
        Human babka1 = new Human("babka1", false, 55, null, null);
        Human babka2 = new Human("babka2", false, 58, null, null);
        Human ania = new Human("Аня", false, 21, ded1, babka1);
        Human oleg = new Human("Олег", true, 23, ded2, babka2);
        Human child1 = new Human("child1", true, 15, oleg, ania);
        Human child2 = new Human("child2", true, 11, oleg, ania);
        Human child3 = new Human("child3", false, 8, oleg, ania);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(babka1);
        System.out.println(babka2);
        System.out.println(ania);
        System.out.println(oleg);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name,boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }


        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
