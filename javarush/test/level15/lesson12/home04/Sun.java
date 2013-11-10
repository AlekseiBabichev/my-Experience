package com.javarush.test.level15.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 30.05.13
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class Sun implements Planet
{
    private static volatile Sun instance  = null;

    private Sun(){  }

        public static Sun getInstance(){
            if (instance == null){
                synchronized (Sun.class){
                    if(instance == null){
                        instance = new Sun();
                    }
                }
            }
            return instance;
        }
}
