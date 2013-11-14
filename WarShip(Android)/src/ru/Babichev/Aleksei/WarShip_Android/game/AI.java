package ru.Babichev.Aleksei.WarShip_Android.game;

/**
 * <tt></>User</tt> класс который наследуется от <tt>Player</tt> выступает в роли AI
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     Field
 * @see     ConstParam
 */

public class AI extends Player {

    /**
     * результат предыдущего выстрела TODO(пока не используется)
     */
    public String theResultOfPreviousShot = "Мимо";

    /**
     * метод который рандомно загадывает координату выстрела
     * TODO пока учитывает только координаты по которым стрелял уже, и больше не палит туда
     * @return возвращает координату
     */

}
