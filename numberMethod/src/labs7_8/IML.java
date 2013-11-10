package labs7_8;



import javax.swing.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 15.10.13
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class IML {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI.createGUI();
            }
        });

        System.out.println(lagranj(2.5, new double[]{2, 3, 5, 6}, new double[]{4, 1, 7, 2}));

    }

    private static double lagranj(double arg, double[] x, double[] y) {
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            double k = 1;
            for (int j = 0; j < y.length; j++) {
                if (j != i) {
                    k *=x[i] - x[j];
                } else {
                    k *= arg - x[j];
                }
                System.out.println(k);
            }
            System.out.println();
            result += y[i] / k;
        }
        return result;
    }

    public static void hackPentagon() {
        double[] x = buildX();
        double[] y = buildY();
        double arg = getArg();
        String[] newLine = new String[GUI.getCountPoint() + 4];

        double result = 0;
        for (int i = 0; i < GUI.getCountPoint(); i++) {
            newLine[0] = "X" + i;
            double k = 1;
            for (int j = 0; j < GUI.getCountPoint(); j++) {
                if (j != i) {
                    k *=x[i] - x[j];
                    newLine[j + 1] = String.valueOf(x[i] - x[j]);
                } else {
                    k *= arg - x[j];
                    newLine[j + 1] = String.valueOf(arg - x[j]);
                }
            }
            newLine[GUI.getCountPoint() + 1] = String.valueOf(k);
            newLine[GUI.getCountPoint() + 2] = String.valueOf(y[i]);
            newLine[GUI.getCountPoint() + 3] = String.valueOf(y[i]/k);
            GUI.getModel().setValueAt(newLine.clone());
            System.out.println(Arrays.toString(newLine));
            result += y[i] / k;
        }

    }

    private static double getArg() {
        JTextField buf = (JTextField) GUI.getCenterTablePanel().getComponent(GUI.getCountPoint()*3 + 4);
        return Double.parseDouble(buf.getText());
    }

    private static double[] buildY() {
        double[] y = new double[GUI.getCountPoint()];
        for (int i = 0; i < GUI.getCountPoint(); i++) {
            JTextField buf = (JTextField) GUI.getCenterTablePanel().getComponent(GUI.getCountPoint()*2 + 3 + i);
            y[i] = Double.parseDouble(buf.getText());
        }

        return y;
    }

    private static double[] buildX() {
        double[] x = new double[GUI.getCountPoint()];
        for (int i = 0; i < GUI.getCountPoint(); i++) {
            JTextField buf = (JTextField) GUI.getCenterTablePanel().getComponent(GUI.getCountPoint() + 3 + i);
            x[i] = Double.parseDouble(buf.getText());
        }

        return x;
    }
}
