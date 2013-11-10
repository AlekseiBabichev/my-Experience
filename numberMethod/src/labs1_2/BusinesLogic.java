package labs1_2;

import static java.lang.Math.*;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 09.09.13
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class BusinesLogic {
    private double a;
    private double b;
    private double deltaA;
    private double deltaB;

    private double oneEvent;
    private double twoEvent;
    private double threeEvent;
    private double fiveEvent;
    private double sixEvent;

    BusinesLogic(double a, double b, double deltaA, double deltaB){
        this.a = a;
        this.b = b;
        if (deltaA < 0 || deltaB < 0) throw new ArithmeticException("погрешность имеет отрицательное значение!!11одинодин");
        this.deltaA = deltaA;
        this.deltaB = deltaB;
    }

    public double calculateResult(){

        oneEvent = exp(a);
        twoEvent = pow(b, 2);
        threeEvent = oneEvent + twoEvent;
        double fourEvent = pow(b, 2);
        fiveEvent = a + fourEvent;
        sixEvent = log(fiveEvent);
        double sevenEvent = threeEvent / sixEvent;

        System.out.println("             Результат: " + sevenEvent);
        return sevenEvent;
    }

    public double calculateDeltaResult(){
        double deltaOneEvent = oneEvent * deltaA;
        double deltaTwoEvent = deltaB / (2 * twoEvent);
        double deltaThreeEvent = deltaOneEvent + deltaTwoEvent;
        double deltaFourEvent = 2 * b * deltaB;
        double deltaFiveEvent = deltaA + deltaFourEvent;
        double deltaSixEvent = deltaFiveEvent / fiveEvent;
        double deltaSevenEvent = (abs(threeEvent) * deltaSixEvent + abs(sixEvent) * deltaThreeEvent) / pow(sixEvent, 2);

        System.out.println("Абсолютная погрешность: " + deltaSevenEvent);
        return deltaSevenEvent;
    }


}
