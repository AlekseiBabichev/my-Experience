package com.javarush.test.level15.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 30.05.13
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class Earth implements Planet
{
    private static volatile Earth instance  = null;

    private Earth(){  }

        public static Earth getInstance(){
            if (instance == null){
                synchronized (Earth.class){
                    if(instance == null){
                        instance = new Earth();
                    }
                }
            }
            return instance;
        }
}
