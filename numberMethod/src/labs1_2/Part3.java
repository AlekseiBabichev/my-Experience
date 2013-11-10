package labs1_2;

public class Part3 {

    private double a;
    private double b;
    private double c;

    Part3(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    void calculate(){
        double result = Math.pow(b - c, 2) / (2 * a + b);

        System.out.println(result);
    }

    public static void main(String[] args) {
        Part3 part3 = new Part3(4.05, 6.723, 0.03254);
        part3.calculate();
    }

}
