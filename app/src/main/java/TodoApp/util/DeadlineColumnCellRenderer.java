/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TodoApp.util;

import TodoApp.model.Task;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ALAN
 */
public class DeadlineColumnCellRenderer extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int col){
        JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, 
                isSelected, hasFocus, row, col);
        label.setHorizontalAlignment(CENTER);
        
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);
                
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = dateFormat.format(new Date());
        
        try {
            if(task.getDeadline().compareTo(dateFormat.parse(dateToday)) < 0){
                label.setBackground(Color.red);
            }else{
                label.setBackground(Color.green);
            }
        } catch (ParseException ex) {
            Logger.getLogger(DeadlineColumnCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return label;
    }
            
    
}
