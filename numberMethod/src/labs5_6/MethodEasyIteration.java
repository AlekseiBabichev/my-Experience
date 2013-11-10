package labs5_6;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;


public class MethodEasyIteration {

    double[][] iterArr;
    double[] iterVector;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI.createGUI();
            }
        });
    }

    public void hackPentagon() {

        double[][] arr = new double[GUI.n][GUI.n];
        double[] vector = new double[GUI.n];

        iterArr = new double[GUI.n][GUI.n];
        iterVector = new double[GUI.n];


        arr = buildArray(arr);
        vector = buildVector(vector);

        buildIterArrAndIterVector(arr, vector);

        if (checkConvergence(iterArr)) return;

        double delta = 0.001;

        easyIterMethod(iterArr, iterVector, delta);


    }

    private void easyIterMethod(double[][] iterArr, double[] iterVector, double acceptableDelta) {
        GUI.model.clearData();

        String[] columns = new String[GUI.n + 1];

        for (int i = 0; i < GUI.n; i++) {
            columns[i] = "x" + i;
        }
        columns[GUI.n] = "epsilon";

        GUI.model.setValueAt(columns);

        double[] x = new double[GUI.n];
        double[] x0 = new double[GUI.n];
        double[] epsilon = new double[GUI.n];
        double delta;
        String[] values = new String[GUI.n + 1];


        do {
            for (int i = 0; i < GUI.n; i++) {
                x[i] = 0;
                for (int j = 0; j < GUI.n; j++) {
                    if (i != j) x[i] -= iterArr[i][j] * x0[j];
                }
                x[i] = iterVector[i] - x[i];
                epsilon[i] = Math.abs(x[i] - x0[i]);
            }
            delta = epsilon[0];
            for (int i = 0; i < GUI.n; i++) {
                if (delta < epsilon[i]) delta = epsilon[i];
            }
            x0 = x.clone();
            for (int i = 0; i < GUI.n; i++) {
                values[i] = String.valueOf(BigDecimal.valueOf(x0[i]).setScale(5, BigDecimal.ROUND_HALF_DOWN));
            }
            values[GUI.n] = String.valueOf(BigDecimal.valueOf(delta).setScale(5, BigDecimal.ROUND_HALF_DOWN));
            GUI.model.setValueAt(values.clone());

        } while (delta > acceptableDelta);
    }

    private boolean checkConvergence(double[][] iterArr) {
        double summ = 0;
        for (int i = 0; i < GUI.n; i++) {
            for (int j = 0; j < GUI.n; j++) {
                summ = summ + iterArr[i][j]*iterArr[i][j];
                System.out.print(summ + " ");
            }
            System.out.println();
        }
        if (Math.sqrt(Math.abs(summ)) > 1){
            JOptionPane.showMessageDialog(GUI.frame, "Данная система не удовлетворяет условию сходимости",
                                          "ошибка", JOptionPane.ERROR_MESSAGE);
            return true;
        } else return false;
    }

    private void buildIterArrAndIterVector(double[][] arr, double[] vector) {
        for (int i = 0; i < GUI.n; i++) {
            for (int j = 0; j < GUI.n; j++) {
                if (i == j) iterArr[i][j] = 0;
                else iterArr[i][j] = -arr[i][j]/arr[i][i];
                System.out.print(iterArr[i][j] + " ");
            }
            System.out.println();
            iterVector[i] = vector[i]/arr[i][i];
        }
    }

    private double[] buildVector(double[] vector) {
        try {
            for (int i = 0; i < GUI.n; i++) {
                    JTextField buff = (JTextField) GUI.vectorPanel.getComponent(i);
                    vector[i] = Double.parseDouble(buff.getText().replace(',', '.'));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GUI.frame, "Неверно введены данные в вектор свободных членов!!!111!!",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return vector;  
    }

    public double[][] buildArray(double arr[][]) {
        try {
            for (int i = 0; i < GUI.n; i++) {
                for (int j = 0; j < GUI.n; j++) {
                        JTextField buff = (JTextField) GUI.arrayPanel.getComponent(j + i * GUI.n);
                        arr[i][j] = Double.parseDouble(buff.getText().replace(',','.'));
                        System.out.print(arr[i][j] + "   ");
                }
                System.out.println();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GUI.frame, "Неверно введены данные в массив!!!111!!",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return arr;
    }
}
