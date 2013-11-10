package testTable;

/**
 * Created with IntelliJ IDEA.
 * User: aleksei
 * Date: 15.10.13
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class RowHeaderRenderer extends JLabel implements ListCellRenderer
{
    RowHeaderRenderer(JTable table)
    {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
    }

    public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
