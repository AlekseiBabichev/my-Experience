package com.javarush.test.level15.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 30.05.13
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class Moon implements Planet
{
    private static volatile Moon instance  = null;

    private Moon(){  }

        public static Moon getInstance(){
            if (instance == null){
                synchronized (Moon.class){
                    if(instance == null){
                        instance = new Moon();
                    }
                }
            }
            return instance;
        }
}
