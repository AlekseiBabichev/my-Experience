package labs3_4;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;


public class MethodHalfDivideLogic {

    double a;
    double b;
    double c;
    double delta;
    double funFromA;
    double funFromB;
    double funFromC;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI.createGUI();
            }
        });
    }

    public void hackPentagon() {

        GUI.model.clearData();

        try {
            a = Double.parseDouble(GUI.aTextField.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GUI.frame, "Неверно введенно значение a",
                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        try {
            b = Double.parseDouble(GUI.bTextField.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GUI.frame, "Неверно введенно значение b",
                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }
        try {
            delta = Double.parseDouble(GUI.deltaTextField.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(GUI.frame, "Неверно введенно значение погрешности",
                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }

        if (b - a > delta) {
            do {
                funFromA = a - 10 * Math.sin(a);
                funFromB = b - 10 * Math.sin(b);
                c = (a + b) / 2;
                funFromC = c - 10 * Math.sin(c);
                System.out.println(a + " " + b + " " + funFromA + " " + funFromB + " " + c + " " + funFromC + " " + (b - a));

                GUI.model.setValueAt(new String[]{String.valueOf(BigDecimal.valueOf(a).setScale(5, BigDecimal.ROUND_HALF_DOWN)),
                        String.valueOf(BigDecimal.valueOf(b).setScale(5, BigDecimal.ROUND_HALF_DOWN)),
                        String.valueOf(BigDecimal.valueOf(funFromA).setScale(5, BigDecimal.ROUND_HALF_DOWN)),
                        String.valueOf(BigDecimal.valueOf(funFromB).setScale(5, BigDecimal.ROUND_HALF_DOWN)),
                        String.valueOf(BigDecimal.valueOf(c).setScale(5, BigDecimal.ROUND_HALF_DOWN)),
                        String.valueOf(BigDecimal.valueOf(funFromC).setScale(5, BigDecimal.ROUND_HALF_DOWN)),
                        String.valueOf(BigDecimal.valueOf(b - a).setScale(5, BigDecimal.ROUND_HALF_DOWN))});

                if (funFromA * funFromC <= 0) {
                    b = c;
                } else if (funFromB * funFromC <= 0) {
                    a = c;
                } else {
                    System.out.println("Вы взломали пентагон!!11одинодин");
                    break;
                }
            } while (b - a > delta);
        } else if (b - a < 0){
            String buff = GUI.aTextField.getText();
            GUI.aTextField.setText(GUI.bTextField.getText());
            GUI.bTextField.setText(buff);
            hackPentagon();
        } else {
            JOptionPane.showMessageDialog(GUI.frame, "отрезок имеет нулевой размер или меньше допустимой погрешности",
                    "ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
