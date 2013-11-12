import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <tt></>GameHelper</tt> утилитный класc
 *
 * @author  Бабичев Алексей
 * @see     Ship
 * @see     WarShipMain
 * @see     Field
 * @see     ConstParam
 */
public class GameHelper {


    /**
     * этот метод принимает строку и предназначен для пользовательского ввода,
     * он выводит переданную ему строку и ожидает ввода с клавиатуры.
     * Нужно передовать строку, которая бы сигрализировала пользователю о том,
     * что нужно сделать ввод
     * @param prompt строка которая будет выведена перед вводом
     * @return возвращает строку введённую пользователем
     */
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.println(prompt + " ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e){
            System.out.println("IOException " + e);
        }
        assert inputLine != null;
        return inputLine.toLowerCase();
    }


}
