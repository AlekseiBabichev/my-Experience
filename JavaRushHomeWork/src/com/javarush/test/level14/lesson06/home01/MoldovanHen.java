package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/11/13
 * Time: 12:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 200;  //To change body of implemented methods use File | Settings | File Templates.
    }
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - "+Country.MOLDOVA+". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
