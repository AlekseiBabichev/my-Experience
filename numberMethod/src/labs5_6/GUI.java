package labs5_6;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUI extends JFrame{

    public static JFrame frame = new JFrame("Метод простой итерации");

    public static JTextField arrayTextField = new JTextField();

    public static ArrayList<String[]> dataTable = new ArrayList<String[]>();

    public static MyModel model;

    private static int clrBuff = 1;

    public static int n;

    public static JPanel arrayPanel;
    public static JPanel vectorPanel;

    public static void  createGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        final JPanel inputPanel = new JPanel();
        panel.setLayout(new BorderLayout());
        inputPanel.setLayout(new BorderLayout());
        JPanel inputPanelInner = new JPanel();



        JLabel aLabel = new JLabel("колличество переменных = ");
        JButton aButton = new JButton("Build");

        arrayPanel = new JPanel();
        vectorPanel = new JPanel();
        final JPanel systemPanel = new JPanel();
        final JTable table = new JTable();

        arrayTextField.setColumns(5);

        inputPanelInner.add(aLabel);
        inputPanelInner.add(arrayTextField);
        inputPanelInner.add(aButton);

        inputPanel.add(inputPanelInner, BorderLayout.NORTH);

        inputPanel.add(systemPanel, BorderLayout.CENTER);

        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    n = Integer.parseInt(arrayTextField.getText().trim());
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(frame, "неверно задано количество уравнений", "Ошибка",
                                            JOptionPane.DEFAULT_OPTION);
                    e1.printStackTrace();
                }
                if (inputPanel.getComponentCount()>1) {
                    inputPanel.remove(1);
                }
                arrayPanel.removeAll();
                vectorPanel.removeAll();
                arrayPanel.setLayout(new GridLayout(n, n));
                vectorPanel.setLayout(new GridLayout(n, 0));

                for (int i = 0; i < n*n; i++) {
                    arrayPanel.add(new JTextField(5));

                }

                for (int i = 0; i < n; i++) {
                    vectorPanel.add(new JTextField(5));
                }
                systemPanel.add(arrayPanel);
                systemPanel.add(vectorPanel);
                inputPanel.add(systemPanel);

                String[] columns = new String[n + 1];

                for (int i = 0; i < n; i++) {
                    columns[i] = "x" + i;
                }
                columns[n] = "epsilon";

                model = new MyModel(dataTable);
                model.clearData();
                model.setValueAt(columns);
                table.setModel(model);
                panel.updateUI();
            }
        });


        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton button = new JButton("Примерно почувствовать:)");
        panel.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MethodEasyIteration logic = new MethodEasyIteration();
                logic.hackPentagon();
                clrBuff = model.myData.size();
            }
        });

        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
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
                for (int i = 0; i < clrBuff; i++) {
                    myData.remove(0);
                    fireTableDataChanged();
                }
            }
        }
    }
}
