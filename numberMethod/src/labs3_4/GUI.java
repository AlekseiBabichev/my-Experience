package labs3_4;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUI extends JFrame{

    public static JFrame frame = new JFrame("Метод половинного деления");
    public static JOptionPane optionPane = new JOptionPane();

    public static JTextField aTextField = new JTextField();
    public static JTextField bTextField = new JTextField();
    public static JTextField deltaTextField = new JTextField();

    public static ArrayList<String[]> dataTable = new ArrayList<String[]>();

    public static MyModel model;

    private static int clrBuff;

    public static void  createGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel panelInput = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel aLabel = new JLabel("a = ");
        JLabel bLabel = new JLabel("b = ");
        JLabel deltaLabel = new JLabel("погрешность = ");

        aTextField.setColumns(5);
        bTextField.setColumns(5);
        deltaTextField.setColumns(5);

        panelInput.add(aLabel);
        panelInput.add(aTextField);
        panelInput.add(bLabel);
        panelInput.add(bTextField);
        panelInput.add(deltaLabel);
        panelInput.add(deltaTextField);

        panel.add(panelInput, BorderLayout.NORTH);

        dataTable.add(new String[]{"a", "b", "f(a)", "f(b)", "Xm = (a + b)/2", "f(Xm)","b-a"});

        model = new MyModel(dataTable);

        final JTable table = new JTable(model);


        panel.add(table, BorderLayout.CENTER);

        JButton button = new JButton("Примерно почувствовать:)");
        panel.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MethodHalfDivideLogic logic = new MethodHalfDivideLogic();
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
            return myData.get(0).length;//количество строк = размер массива String в ArrayList myData
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
            if (myData.size() > 1) {
                for (int i = 0; i < clrBuff-1; i++) {
                    myData.remove(1);
                    fireTableDataChanged();
                }
            }
        }
    }
}
