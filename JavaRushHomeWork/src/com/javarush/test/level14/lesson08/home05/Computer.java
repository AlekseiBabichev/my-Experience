package com.javarush.test.level14.lesson08.home05;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/12/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Computer
{
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
    }
}
