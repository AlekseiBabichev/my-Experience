package labs7_8.testDesigner;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 20.10.13
 * Time: 19:40
 * To change this template use File | Settings | File Templates.
 */
public class TableModel extends AbstractTableModel {
    private ArrayList<String[]> myData; // хранилище данных на основе
    // которых строится таблица

    public TableModel(ArrayList<String[]> myData){
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
