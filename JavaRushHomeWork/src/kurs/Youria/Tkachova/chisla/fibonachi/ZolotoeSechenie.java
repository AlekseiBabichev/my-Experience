package kurs.Youria.Tkachova.chisla.fibonachi;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 4/17/13
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ZolotoeSechenie
{
    public static void main(String[] args)
    {
        int[] a = new int[] {1, 1, 2, 3, 3, 3, 4, 4, 6, 7, 8, 8, 33, 54, 223, 343};
        System.out.println(sortZS(a));
    }

    private static int sortZS(int[] a)
    {                                                                                       return Arrays.binarySearch(a, 33);
    }

}
