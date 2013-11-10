package JavaTheExamples.chapter_2;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 27.10.13
 * Time: 5:19
 * To change this template use File | Settings | File Templates.
 */
public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(2, 3, 5);
        System.out.println(circle.toString());
        circle.move(2, 2);
        System.out.println(circle.toString());
        System.out.println(circle.isInside(0,0));
        System.out.println(circle.isInside(3,3));
        System.out.println(circle.boundingBox());

    }
}
