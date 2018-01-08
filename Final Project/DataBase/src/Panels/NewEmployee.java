/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.Addresses;
import database.DataBase;
import database.Employee;
import database.User;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author dell
 */
public class NewEmployee extends javax.swing.JPanel {

    JDatePickerImpl datePicker;

    /**
     * Creates new form NewEmployee
     */
    public NewEmployee() {

        initComponents();
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(180, 250, 200, 27);
        
        add(datePicker);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b = new javax.swing.ButtonGroup();
        rank = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        building = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        street = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(680, 691));
        setLayout(null);

        rank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rank.setMaximumRowCount(4);
        rank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Receptionist", "Manager", "Coach", "Nutritionist" }));
        add(rank);
        rank.setBounds(140, 420, 110, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Rank :");
        add(jLabel10);
        jLabel10.setBounds(70, 420, 60, 15);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/log.png"))); // NOI18N
        add(jLabel12);
        jLabel12.setBounds(386, 0, 150, 90);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(420, 510, 55, 23);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(80, 510, 61, 23);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Sign Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(220, 460, 110, 40);
        add(building);
        building.setBounds(140, 360, 250, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText(" Building : ");
        add(jLabel9);
        jLabel9.setBounds(60, 360, 90, 15);
        add(street);
        street.setBounds(350, 310, 140, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Street : ");
        add(jLabel8);
        jLabel8.setBounds(290, 310, 60, 15);

        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });
        add(city);
        city.setBounds(120, 310, 130, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("City : ");
        add(jLabel7);
        jLabel7.setBounds(60, 310, 50, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Date Of Birth : ");
        add(jLabel6);
        jLabel6.setBounds(60, 250, 100, 15);
        add(email);
        email.setBounds(120, 190, 310, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email : ");
        add(jLabel5);
        jLabel5.setBounds(60, 190, 80, 15);

        b.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2.setText("Male");
        add(jRadioButton2);
        jRadioButton2.setBounds(330, 140, 53, 23);

        b.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setText("Female");
        add(jRadioButton1);
        jRadioButton1.setBounds(160, 140, 67, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Gender : ");
        add(jLabel4);
        jLabel4.setBounds(60, 140, 80, 20);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add(name);
        name.setBounds(120, 100, 310, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Name : ");
        add(jLabel3);
        jLabel3.setBounds(60, 90, 70, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("New Emplyee Registration....");
        add(jLabel2);
        jLabel2.setBounds(50, 20, 340, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/test.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, -20, 680, 690);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {                                         
            int empId=0;
            int userId=0;
            try {String name1 = name.getText();
            boolean gender = false;
            if( jRadioButton1.isSelected() || jRadioButton2.isSelected())
                gender = jRadioButton1.isSelected();
            String email1 = email.getText();
            int rank1 =rank.getSelectedIndex();
            String city1 = city.getText();
            String street1 = street.getText();
            
            String Building1 = building.getText();
            
            
            int addressId = Addresses.addAddress (city1,street1,Building1);
            java.sql.Date DOB=new java.sql.Date(((Date)datePicker.getModel().getValue()).getTime());
           
                System.out.println(DOB+"date of birth!!!!");
            userId  = User.addNewUser (name1,gender,email1,DOB ,new Addresses(addressId),true);
                System.out.println(userId+" this is the user id!!!!");
            empId=Employee.addEmployee(rank1+"", userId);
            } catch (SQLException ex) {
                Logger.getLogger(NewEmployee.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NewEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JPanel SignUpFinalPanel = new SignUpFinal(empId,userId,true);
            DataBase.changePanel(SignUpFinalPanel);
        } catch (SQLException ex) {
            Logger.getLogger(NewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JPanel temp = new empMainScreen();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DataBase.exitFrame();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup b;
    private javax.swing.JTextField building;
    private javax.swing.JTextField city;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> rank;
    private javax.swing.JTextField street;
    // End of variables declaration//GEN-END:variables

}
