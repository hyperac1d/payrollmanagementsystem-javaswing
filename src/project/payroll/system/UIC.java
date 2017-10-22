/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.payroll.system;

import java.util.Date;

/***
 * Class Name: UIC
 * Class Description: Yet Another Java Helper Class for Desktop Dev't
 * Requirements:
 * (a) Java Development Kit 7 (suggested version jdk 1.8)
 * (b) Netbeans IDE 8 and below (suggested version 8.2)
 * (c) Project > Libraries > Add JAR/Folder > jcalendar.jar
 */

public class UIC {
    
    public static class Frame{
        public static void setDefault(javax.swing.JFrame frame){
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
        }
    }
    
    public static class Table{
        public static void setModel(javax.swing.JTable table, String[][] records, String[] columns){
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(records, columns){
                @Override
                public boolean isCellEditable(int row, int column) {return false;}
            };
            table.setModel(model);
        }
        public static int getSelectedRow(javax.swing.JTable table){
            try{
                return java.lang.Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            }
            catch(Exception e){
                return 0;
            }
        }
    }
    
    public static class DateChooser{
        //https://stackoverflow.com/questions/30235183/how-do-we-disable-editing-options-on-jdatechooser
        public static void setReadOnly(com.toedter.calendar.JDateChooser chooser){
            com.toedter.calendar.JTextFieldDateEditor editor = (com.toedter.calendar.JTextFieldDateEditor) chooser.getDateEditor();
            editor.setEditable(false);
        }

        //https://stackoverflow.com/questions/21012751/get-jdatechooser-date-to-jlabel
        public static String getDate(com.toedter.calendar.JDateChooser chooser){
            java.util.Date date = chooser.getDate();
            return java.text.DateFormat.getDateInstance().format(date);
        }    
        //https://stackoverflow.com/questions/21012751/get-jdatechooser-date-to-jlabel
        public static Date getDatee(com.toedter.calendar.JDateChooser chooser){
            java.util.Date date = chooser.getDate();
            return date;
        }    
    }
}
