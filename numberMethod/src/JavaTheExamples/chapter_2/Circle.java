package JavaTheExamples.chapter_2;

/**
 *Этот класс представляет собой круг(Circle) который определяет
 * его на координатной плоскости и позволяет совершать с ним различные операции
 */
public class Circle {
    /**
     * Это поля класса:
     * х и у определяют центр окружности
     * r определяет радиус окружности
     */
    private double r, x, y;

    /**
     * Это конструктор окружности который иницициализирует поля
     * определяющие состояние окружности(ваш КО)
     * @param xCenter центр окружности по оси х
     * @param yCenter центр окружности по оси у
     * @param radius радиус окружности
     */
    public Circle(double xCenter, double yCenter, double radius){
        r = radius;
        x = xCenter;
        y = yCenter;
    }

    /**
     * метод который позволяет перемещать окружность
     * по координатной плоскости
     * @param moveX перемещение по оси х
     * @param moveY перемещение по оси у
     */
    public void move(double moveX, double moveY){
        x += moveX;
        y += moveY;
    }

    /**
     * Этот метод определяет принадлежность точки
     * к окружности
     * @param x положение точки по оси х
     * @param y положение точки по оси у
     * @return возвращает true или false в зависимости от принадлежности точки к окружности
     */
    public boolean isInside(double x, double y){
        System.out.println(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return (Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2) <= Math.pow(r, 2));
    }

    /**
     * Метод который создаёт прямоугольник типа Rect, минимальных размеров в который вписана
     * текущая окружность
     * @return прямоугольник в который вписана эта окружность
     */
    public Rect boundingBox(){
        double x1,x2,y1,y2;
        x1 = x - r;
        y1 = y + r;
        x2 = x + r;
        y2 = y - r;
        return new Rect(x1, y1, x2, y2);
    }

    public double getR() {
        return r;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X = " + x + ", Y = " + y + ", R = " + r;
    }
}
