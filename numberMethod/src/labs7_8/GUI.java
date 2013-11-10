package labs7_8;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 15.10.13
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 */
public class GUI {

    private static JFrame frame = new JFrame("Построение ИМЛ");
    private static JPanel centerTablePanel;
    private static MyModel model;

    public static MyModel getModel() {
        return model;
    }

    public static int getCountPoint() {
        return countPoint;
    }

    private static int countPoint;

    public static JPanel getCenterTablePanel() {
        return centerTablePanel;
    }

    public static void createGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel mainPanel = new JPanel(new BorderLayout());

        final JTextField countPointTextField = new JTextField(5);
        JButton countPointButton = new JButton("Craft table");
        JPanel inputStepPointsPanel = new JPanel();

        inputStepPointsPanel.add(countPointTextField);
        inputStepPointsPanel.add(countPointButton);
        mainPanel.add(inputStepPointsPanel, BorderLayout.NORTH);

        centerTablePanel = new JPanel(new GridBagLayout());
        mainPanel.add(centerTablePanel, BorderLayout.CENTER);
        final GridBagConstraints constraints = new GridBagConstraints();

        final JButton calculateButton = new JButton("примерно почувствовать:)");



        countPointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                     countPoint = Integer.parseInt(countPointTextField.getText());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "Неверно введено колличество точек",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }

                centerTablePanel.removeAll();

                constraints.anchor = GridBagConstraints.CENTER;
                constraints.fill   = GridBagConstraints.BOTH;
                constraints.gridheight = 1;
                constraints.gridwidth  = 1;
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

                centerTablePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                frame.setPreferredSize(new Dimension(100 + countPoint * 60, 300));
                frame.pack();
                frame.repaint();
            }
        });

        final JTable table = new JTable();
        final JScrollPane scrollPane = new JScrollPane(table);
        final ArrayList<String[]> myData = new ArrayList<String[]>();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model = new MyModel(myData);
                mainPanel.remove(1);
                setColsName();
                IML.hackPentagon();
                table.setModel(model);
                scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.blue, Color.blue));
                mainPanel.add(scrollPane, BorderLayout.CENTER);
                mainPanel.revalidate();


            }
        });

        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private static void setColsName() {
        String[] colsName = new String[countPoint + 4];
        colsName[0] = "X";
        for (int i = 0; i < countPoint; i++) {
            colsName[i + 1] = "X" + i;
        }
        colsName[countPoint + 1] = "Pi";
        colsName[countPoint + 2] = "Yi";
        colsName[countPoint + 3] = "Yi/Pi";
        model.setValueAt(colsName);
    }


    public static class MyModel extends AbstractTableModel {

        private ArrayList<String[]> myData; // хранилище данных на основе
        // которых строится таблица

        public MyModel(ArrayList<String[]> myData){
            this.myData = myData;
        }
        @Override
        public int getRowCount(){
            return myData.size();//количество строк = размер ArrayList myData
        }

        @Override
        public int getColumnCount(){
            return myData.get(0).length;// myData.get(0).length;//количество строк = размер массива String в ArrayList myData
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex){
            return myData.get(rowIndex)[columnIndex];
        }

        public void setValueAt(String[] newData){
            myData.add(newData);//добавляем в наш ArrayList новые данные
            fireTableDataChanged();//обновляем данные
        }

        public void clearData(){
            if (myData.size() > 0) {
                for (int i = 0; i < myData.size(); i++) {
                    myData.remove(0);
                    fireTableDataChanged();
                }
            }
        }
    }
}
