package JavaTheExamples.chapter_1;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 26.10.13
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class Task1_3 {
    public static void main(String[] args) {
        try {
            System.out.println(args[0].substring(Integer.parseInt(args[1]), Integer.parseInt(args[2]) + 1));
        } catch (NumberFormatException e) {
            System.err.println("Ты неудачник");
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
