package telas;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TextAreaCellRenderer extends JTextPane implements TableCellRenderer {  
	  
    public TextAreaCellRenderer() {  

        
        setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N  
        setMargin(new java.awt.Insets(5, 5, 5, 5));  
        StyledDocument doc = getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		setStyledDocument(doc);
    }  

    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {  

        // set color & border here                
        this.setText(value.toString());  
        
        setText((value == null) ? "" : value.toString());  
        setSize(table.getColumnModel().getColumn(column).getWidth(),  
                getPreferredSize().height);  

        if (table.getRowHeight(row) < getPreferredSize().height) {  
            table.setRowHeight(row, getPreferredSize().height );  
        }  

        return this;  
    }
}  
