package labs7_8.testDesigner;



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

    public static void hackPentagon() throws NumberFormatException{
        double[] x = buildX();
        double[] y = buildY();
        double arg = getArg();
        String[] newLine = new String[GUI.getCountPoint() + 4];

        double result = 0;
        for (int i = 0; i < GUI.getCountPoint(); i++) {
            newLine[0] = "<html><h1>x<sub>" + i + "</sub></h1></html>";
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
        for (int i = 0; i <= GUI.getCountPoint() + 1; i++) {
            newLine[i] = null;
        }
        newLine[GUI.getCountPoint() + 2] = "сумма = ";
        newLine[GUI.getCountPoint() + 3] = String.valueOf(result);
        GUI.getModel().setValueAt(newLine);

    }

    public static double getArg() throws NumberFormatException{
        JTextField buf = (JTextField) GUI.getCenterTablePanel().getComponent(GUI.getCountPoint()*3 + 4);
        return Double.parseDouble(buf.getText().trim().replace(',','.'));
    }

    private static double[] buildY() throws NumberFormatException{
        double[] y = new double[GUI.getCountPoint()];
        for (int i = 0; i < GUI.getCountPoint(); i++) {
            JTextField buf = (JTextField) GUI.getCenterTablePanel().getComponent(GUI.getCountPoint()*2 + 3 + i);
            y[i] = Double.parseDouble(buf.getText().trim().replace(',','.'));
        }

        return y;
    }

    public static double[] buildX() throws NumberFormatException{
        double[] x = new double[GUI.getCountPoint()];
        for (int i = 0; i < GUI.getCountPoint(); i++) {
            JTextField buf = (JTextField) GUI.getCenterTablePanel().getComponent(GUI.getCountPoint() + 3 + i);
            x[i] = Double.parseDouble(buf.getText().trim().replace(',','.'));
        }

        return x;
    }
}
