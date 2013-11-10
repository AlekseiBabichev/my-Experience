package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/11/13
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class HenFactory
{
    static Hen getHen(String country) {
        Hen hen = null;
        if (country.equals(Country.BELARUS))
            return new BelarusianHen();
        else if (country.equals(Country.MOLDOVA))
            return new MoldovanHen();
        else if (country.equals(Country.RUSSIA))
            return new RussianHen();
        else if (country.equals(Country.UKRAINE))
            return new UkrainianHen();
        else return hen;
    }
}
