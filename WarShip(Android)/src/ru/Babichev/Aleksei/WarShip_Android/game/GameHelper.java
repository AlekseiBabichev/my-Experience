package ru.Babichev.Aleksei.WarShip_Android.game;

/**
 * <tt></>GameHelper</tt> утилитный класc
 *
 * @author Бабичев Алексей
 * @see Ship
 * @see WarShipMain
 * @see Field
 * @see ConstParam
 */
public class GameHelper {

    private volatile static int x;
    private volatile static int y;

    public static void setX(int x) {
        GameHelper.x = x;
    }

    public static void setY(int y) {
        GameHelper.y = y;
    }

    public static void setShot(boolean shot) {

        isShot = shot;
    }

    private static boolean isShot = false;




    /**
     * этот метод принимает строку и предназначен для пользовательского ввода,
     * он выводит переданную ему строку и ожидает ввода с клавиатуры.
     * Нужно передовать строку, которая бы сигрализировала пользователю о том,
     * что нужно сделать ввод
     *
     * @param prompt строка которая будет выведена перед вводом
     * @return возвращает строку введённую пользователем
     */
    public String getUserInput(String prompt) {
        String inputLine;
        while(true){
            if (isShot) {
                inputLine = String.valueOf(ConstParam.ALPHABET.charAt(x)).concat(String.valueOf(y));
                isShot = false;
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return inputLine;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
}
