package JavaTheExamples.chapter_2;

/**
 * Этот класс представляет прямоугольник. Его поля представляют координаты
 * углов этого прямоугольника. Его методы определяют операции. которые могут
 * осуществлятся с объектами Rect.
 */
public class Rect {
    private double x1, x2, y1, y2;

    public Rect(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Rect(double height, double width){this(0, 0, height, width);}

    public Rect(){this(0,0,0,0);}

    @Override
    public String toString() {
        return "a = (" + x1 + ";" + y1 + "), b = " + x2 + ";" + y2 + ").";
    }
}
