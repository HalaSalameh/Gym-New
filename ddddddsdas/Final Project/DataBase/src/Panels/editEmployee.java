/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.DataBase;
import database.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class editEmployee extends javax.swing.JPanel {

    /**
     * Creates new form editEmployee
     */
    public editEmployee() {
        initComponents();
        if (User.mainUser.getIsEmp()==true)
        userName.setText("User Name :emp"+User.mainUser.getEmp().getEmpId());
        else  userName.setText("User Name :emp"+User.mainUser.getCus().getCusid());
        dob.setText("Date Of Birth : "+User.mainUser.getDateOfBirth().toString());
        if (User.mainUser.getGender()==true)
           inf.setText("Gender : Female ");
        else inf.setText("Gender : Male ");
        hire.setText("Hire Date "+User.mainUser.getJoinedDate());
        inf.setText("Information Updated Successfully!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        city = new javax.swing.JTextField();
        street = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        building = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        userName = new javax.swing.JLabel();
        inf = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        dob = new javax.swing.JLabel();
        hire = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(1030, 400));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Name");
        add(jLabel1);
        jLabel1.setBounds(130, 110, 90, 29);

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(0, 153, 153));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add(name);
        name.setBounds(240, 120, 240, 23);

        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(0, 153, 153));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        add(email);
        email.setBounds(240, 160, 240, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("City");
        add(jLabel4);
        jLabel4.setBounds(130, 210, 90, 29);

        city.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        city.setForeground(new java.awt.Color(0, 153, 153));
        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });
        add(city);
        city.setBounds(240, 210, 103, 23);

        street.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        street.setForeground(new java.awt.Color(0, 153, 153));
        street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetActionPerformed(evt);
            }
        });
        add(street);
        street.setBounds(470, 220, 103, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Street");
        add(jLabel5);
        jLabel5.setBounds(410, 210, 90, 29);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("building");
        add(jLabel6);
        jLabel6.setBounds(120, 250, 90, 29);

        building.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        building.setForeground(new java.awt.Color(0, 153, 153));
        building.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildingActionPerformed(evt);
            }
        });
        add(building);
        building.setBounds(240, 250, 103, 23);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 153));
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(510, 340, 90, 31);

        userName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(userName);
        userName.setBounds(130, 70, 239, 28);

        inf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(inf);
        inf.setBounds(660, 290, 239, 28);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/Picture111.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        add(jLabel12);
        jLabel12.setBounds(620, -10, 410, 260);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/ضضض.png"))); // NOI18N
        add(jLabel13);
        jLabel13.setBounds(0, 0, 110, 620);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 153));
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(210, 340, 90, 25);

        dob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(dob);
        dob.setBounds(130, 290, 239, 28);

        hire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(hire);
        hire.setBounds(420, 290, 239, 28);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 102, 0));
        jLabel16.setText("E-mail");
        add(jLabel16);
        jLabel16.setBounds(130, 150, 90, 29);
        add(jLabel2);
        jLabel2.setBounds(600, 300, 270, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed

    private void streetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetActionPerformed

    private void buildingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buildingActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("1");
        try {
            if (!building.getText().equals(""))
                User.mainUser.getAddressId().setBuilding(building.getText());
            if (!city.getText().equals(""))
                User.mainUser.getAddressId().setCity(city.getText());
            if (!email.getText().equals(""))
                User.mainUser.setEmail(email.getText());
            if (!name.getText().equals(""))
                User.mainUser.setName(name.getText());
            if (!street.getText().equals(""))
                User.mainUser.getAddressId().setStreet(street.getText());
        } catch (SQLException ex) {
            Logger.getLogger(editEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JPanel temp = new empMainScreen();
        DataBase.changePanel(temp);    
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField building;
    private javax.swing.JTextField city;
    private javax.swing.JLabel dob;
    private javax.swing.JTextField email;
    private javax.swing.JLabel hire;
    private javax.swing.JLabel inf;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JTextField street;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}