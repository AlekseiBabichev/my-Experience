package kurs.Youria.Tkachova.chisla.fibonachi;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/17/13
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fibonachi
{
    public static void main(String[] args)
    {
        System.out.println(getFibonachi(150));
    }

    private static long getFibonachi(int n)
    {
        long a11 = 1, a12 = 1, a21 = 1, a22 =  0; //матрица оператора
        long r11 = 1, r12 =  0; //вектор-столбец результа
        long q11 =  0, q12 =  0, q21 =  0, q22 =  0; //вспомогательная матрица при перемножении
        while (n >  0) {
            if ((n & 1)==1) {
                q11 = (r11 * a11 + r12 * a21);
                q12 = (r11 * a12 + r12 * a22);
                r11 = q11;
                r12 = q12;
            }
            q11 = (a11 * a11 + a12 * a21);
            q12 = (a11 * a12 + a12 * a22);
            q21 = (a21 * a11 + a22 * a21);
            q22 = (a21 * a12 + a22 * a22);
            a11 = q11;
            a12 = q12;
            a21 = q21;
            a22 = q22;

            n >>= 1;
        }
        return r12; //возвращаем Fn
    }
}
