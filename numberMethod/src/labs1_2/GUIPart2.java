package labs1_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 12.09.13
 * Time: 1:56
 * To change this template use File | Settings | File Templates.
 */
public class GUIPart2 extends JFrame {

    private static final JFrame frame = new JFrame("Test frame");

    private static BusinesLogic businesLogic;

    private static double a;
    private static double b;
    private static double deltaA;
    private static double deltaB;

    private static JPanel panel = new JPanel();
    private static JPanel p_a = new JPanel();
    private static JPanel p_b = new JPanel();
    private static JPanel p_deltaA = new JPanel();
    private static JPanel p_deltaB = new JPanel();

    private static JTextField t_A = new JTextField();
    private static JTextField t_B = new JTextField();
    private static JTextField t_DeltaA = new JTextField();
    private static JTextField t_DeltaB = new JTextField();

    private static JLabel l_a = new JLabel("a");
    private static JLabel l_b = new JLabel("b");
    private static JLabel l_deltaA = new JLabel("delta a");
    private static JLabel l_deltaB = new JLabel("delta b");
    private static JLabel l_result = new JLabel("Здесь мог бы быть ваш результат:)");
    private static JLabel l_deltaResult = new JLabel();

    static JButton button = new JButton("Примерно почувствовать");


    public static void createGUI(){

        t_A.setColumns(10);
        t_B.setColumns(10);
        t_DeltaA.setColumns(10);
        t_DeltaB.setColumns(10);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p_a.add(t_A);
        p_a.add(l_a);
        p_b.add(t_B);
        p_b.add(l_b);

        p_deltaA.add(t_DeltaA);
        p_deltaA.add(l_deltaA);
        p_deltaB.add(t_DeltaB);
        p_deltaB.add(l_deltaB);

        panel.setLayout(new FlowLayout());
        panel.add(p_a);
        panel.add(p_b);
        panel.add(p_deltaA);
        panel.add(p_deltaB);
        panel.add(l_result);
        panel.add(l_deltaResult);
        panel.add(button);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                a = Double.parseDouble(t_A.getText());
                b = Double.parseDouble(t_B.getText());
                deltaA = Double.parseDouble(t_DeltaA.getText());
                deltaB = Double.parseDouble(t_DeltaB.getText());

                businesLogic = new BusinesLogic(a, b, deltaA, deltaB);
                l_result.setText("Результат: " + String.valueOf(businesLogic.calculateResult()));
                l_deltaResult.setText("абсолютная погрешность: " + String.valueOf(businesLogic.calculateDeltaResult()));
            }
        });

        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });

    }
}
