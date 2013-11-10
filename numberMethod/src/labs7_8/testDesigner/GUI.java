package labs7_8.testDesigner;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 20.10.13
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class GUI {
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JTextField stepsCountTextField;
    private JLabel stepsCountLabel;
    private JButton stepsCountButton;
    private static JPanel centerTablePanel = new JPanel(new GridBagLayout());
    private static int countPoint;
    private JButton calculateButton = new JButton("Примерно почувствовать :)");
    private static JFrame frame;
    private static TableModel model;
    private JButton restartButton = new JButton("заново");

    public static void main(String[] args) {

        frame = new JFrame("ИМЛ");
        frame.setContentPane(new GUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public GUI() {

        mainPanel.add(centerTablePanel, BorderLayout.CENTER);
        stepsCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    countPoint = Integer.parseInt(stepsCountTextField.getText().trim());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(mainPanel, "Неверно введено колличество точек",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                    return;
                }

                centerTablePanel.removeAll();

                GridBagConstraints constraints = new GridBagConstraints();
                constraints.anchor = GridBagConstraints.CENTER;
                constraints.fill = GridBagConstraints.BOTH;
                constraints.gridheight = 1;
                constraints.gridwidth = 1;
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.insets = new Insets(0, 0, 0, 0);

                centerTablePanel.add(new Label("i"), constraints);
                constraints.gridy = 1;
                centerTablePanel.add(new Label("X="), constraints);
                constraints.gridy = 2;
                centerTablePanel.add(new Label("Y="), constraints);
                constraints.gridy = 0;


                for (int i = 1; i <= countPoint; i++) {
                    constraints.gridx = GridBagConstraints.RELATIVE;
                    centerTablePanel.add(new JLabel(String.valueOf(i)), constraints);
                }

                for (int i = 1; i <= 2; i++) {
                    constraints.gridy = i;
                    for (int j = 1; j <= countPoint; j++) {
                        centerTablePanel.add(new JTextField(5), constraints);
                    }
                }

                constraints.gridy = 3;
                constraints.fill = GridBagConstraints.EAST;
                JLabel argLabel = new JLabel("X =");
                constraints.gridx = countPoint - 1;
                centerTablePanel.add(argLabel, constraints);

                constraints.anchor = GridBagConstraints.CENTER;
                constraints.gridx = countPoint;
                JTextField argTextField = new JTextField(5);
                centerTablePanel.add(argTextField, constraints);

                mainPanel.add(calculateButton, BorderLayout.SOUTH);

//                centerTablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                centerTablePanel.setPreferredSize(new Dimension(100 + countPoint * 60, 100));
                frame.pack();
                frame.repaint();
            }
        });

        final JTable table = new JTable();
        table.setRowHeight(40);
        final JScrollPane scrollPane = new JScrollPane(table);
        final ArrayList<String[]> myData = new ArrayList<String[]>();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    checkArg();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, "Ошибка ввода аргумента", "Лалка", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                    return;
                }
                myData.clear();
                model = new TableModel(myData);
                setColsName();

                try {
                    IML.hackPentagon();
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "Ошибка ввода в таблице или аргумента", "Лалка", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                    return;
                }
                mainPanel.removeAll();
                table.setModel(model);
//                scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.blue, Color.blue));
                mainPanel.add(scrollPane, BorderLayout.CENTER);
//                frame.pack();
//                mainPanel.add(restartButton, BorderLayout.SOUTH);
                mainPanel.revalidate();
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new GUI().mainPanel);
                frame.repaint();
            }
        });


    }

    private void checkArg() throws Exception {
        double arg = IML.getArg();
        double[] x = IML.buildX();
        for (int i = 0; i < x.length; i++) {
            if (arg == x[i]) throw new Exception("аргумент введён неверно");
        }
    }


    private void setColsName() {
        String[] colsName = new String[countPoint + 4];
        colsName[0] = "x";
        for (int i = 0; i < countPoint; i++) {
            colsName[i + 1] = "<html>x<sub>" + i + "</sub></html>";
        }
        colsName[countPoint + 1] = "<html>p<sub>i</sub></html>";
        colsName[countPoint + 2] = "<html>y<sub>i</sub></html>";
        colsName[countPoint + 3] = "<html>y<sub>i</sub>/p<sub>i</sub></html>";
        model.setValueAt(colsName);
    }

    public static int getCountPoint() {
        return countPoint;
    }

    public static TableModel getModel() {
        return model;
    }

    public static JPanel getCenterTablePanel() {
        return centerTablePanel;
    }

    public static JFrame getFrame() {
        return frame;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        stepsCountLabel = new JLabel();
        stepsCountLabel.setText("размерность");
        inputPanel.add(stepsCountLabel);
        stepsCountTextField = new JTextField();
        stepsCountTextField.setColumns(5);
        inputPanel.add(stepsCountTextField);
        stepsCountButton = new JButton();
        stepsCountButton.setText("построить");
        inputPanel.add(stepsCountButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
