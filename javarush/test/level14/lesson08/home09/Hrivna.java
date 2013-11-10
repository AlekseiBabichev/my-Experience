package com.javarush.test.level14.lesson08.home09;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/12/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hrivna extends Money
{
    public Hrivna(double amount)
    {
        super(amount);
    }

    @Override
    public String getCurrencyName()
    {
        return "HRN";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
