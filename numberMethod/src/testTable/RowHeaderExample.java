package testTable;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 15.10.13
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class RowHeaderExample extends JFrame
{
    JScrollPane scroll;
    public RowHeaderExample()
    {
        super( "Row Header Example" );
        setSize( 300, 150 );

        ListModel lm = new AbstractListModel()
        {
            String headers[] = {"a1", "b", "c", "d", "e", "f", "g", "h", "i"};
            public int getSize()
            {return headers.length;}

            public Object getElementAt(int index)
            {
                return headers[index];
            }
        };
        DefaultTableModel dm = new DefaultTableModel(lm.getSize(),10);
        JTable table = new JTable(dm);

        JList rowHeader = new JList(lm);
        rowHeader.setFixedCellWidth(50);

        rowHeader.setCellRenderer(new RowHeaderRenderer(table));
        scroll = new JScrollPane(table);

        scroll.setRowHeaderView(rowHeader);
        getContentPane().add(scroll, BorderLayout.CENTER);
    }

    public JScrollPane getScroll()
    {
        return scroll;
    }
    public static void main(String[] args)
    {
        RowHeaderExample frame = new RowHeaderExample();
        frame.addWindowListener( new WindowAdapter()
        {
            public void windowClosing( WindowEvent e )
            {
                System.exit(0);
            }
        });
        frame.setVisible(true);
        //frame.getScroll().setColumnHeaderView(null);

    }
}
