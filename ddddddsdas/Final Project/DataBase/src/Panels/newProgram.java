/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.DataBase;
import database.Programs;
import database.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author dell
 */
public class newProgram extends javax.swing.JPanel {

    /**
     * Creates new form Program
     */
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker1;
    int cusId;

    public newProgram(int cusId) throws SQLException, ClassNotFoundException {
        this.cusId = cusId;
        initComponents();

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(270, 110, 200, 27);
        add(datePicker);
        UtilDateModel model2 = new UtilDateModel();
        Properties p2 = new Properties();
        p2.put("text.today", "Today");
        p2.put("text.month", "Month");
        p2.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model2, p2);
        datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        datePicker1.setBounds(270, 140, 200, 27);
        add(datePicker1);
        String sql = "select u.name from user as u ,customers as c where u.userId = c.userId and c.cusId = " + cusId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        while (set.next()) {
            title.setText("New Programm For " + set.getString(1));
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        notes = new java.awt.TextArea();
        breakfast = new java.awt.TextArea();
        lunch = new java.awt.TextArea();
        dinner = new java.awt.TextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        setLayout(null);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 102, 0));
        jButton3.setText("Set");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(570, 590, 60, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 102, 0));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(290, 590, 80, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Notes :");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        add(jLabel12);
        jLabel12.setBounds(80, 520, 80, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Dinner :");
        add(jLabel10);
        jLabel10.setBounds(80, 430, 80, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Lunch : ");
        add(jLabel9);
        jLabel9.setBounds(80, 330, 80, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Breakfast : ");
        add(jLabel8);
        jLabel8.setBounds(50, 230, 120, 20);

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 102, 0));
        title.setText("Program...............................................");
        add(title);
        title.setBounds(90, 20, 470, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/test.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 70, 648);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/big.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(640, -10, 330, 260);

        notes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        notes.setForeground(new java.awt.Color(255, 102, 0));
        add(notes);
        notes.setBounds(160, 500, 720, 70);

        breakfast.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        breakfast.setForeground(new java.awt.Color(255, 102, 0));
        add(breakfast);
        breakfast.setBounds(160, 220, 720, 70);

        lunch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lunch.setForeground(new java.awt.Color(255, 102, 0));
        add(lunch);
        lunch.setBounds(160, 320, 720, 70);

        dinner.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dinner.setForeground(new java.awt.Color(255, 102, 0));
        add(dinner);
        dinner.setBounds(160, 410, 720, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         try {
            // TODO add your handling code here:
            int ide = Programs.newProgram(User.mainUser.getEmp().getEmpId(), breakfast.getText(),lunch.getText(),dinner.getText(), notes.getText());
            String sql = "update customers set programid = "+ ide + " where customers.cusId = " + cusId;
             System.out.println(sql);
            DatabaseAPI db = new DatabaseAPI();
            db.write(sql);
        } catch (SQLException ex) {
            Logger.getLogger(newProgram.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(newProgram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
        JPanel temp = new empMainScreen();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea breakfast;
    private java.awt.TextArea dinner;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.TextArea lunch;
    private java.awt.TextArea notes;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
