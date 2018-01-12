/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.DataBase;
import database.User;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class empMainScreen extends javax.swing.JPanel {

    /**
     * Creates new form empMainScreen
     */
    public empMainScreen() {
        initComponents();
        empName.setText(User.mainUser.getName());
        name.setText("Name : " + empName.getText());
        address.setText("Address : " + User.mainUser.getAddressId().toString());
        if (User.mainUser.getGender() == true) {
            gender.setText("Gender : " + "Female");
        } else {
            gender.setText("Gender : " + "Male");
        }
        email.setText("Email : " + User.mainUser.getEmail());
        rank.setText("Rank : " + User.mainUser.getEmp().getRank());
        if (User.mainUser.getEmp().getRank()!=2)
            manager.setEnabled(false);
        DOB.setText(" Date Of Birth : " + User.mainUser.getDateOfBirth());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        empName = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        rank = new javax.swing.JLabel();
        DOB = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        manager = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(1030, 711));
        setLayout(null);

        gender.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(gender);
        gender.setBounds(140, 170, 260, 30);

        email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(email);
        email.setBounds(140, 140, 260, 30);

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(name);
        name.setBounds(140, 110, 260, 30);

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText(" Edit Information");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8);
        jButton8.setBounds(680, 190, 200, 31);

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/ضضض.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 140, 710);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/Picture111.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(680, 460, 350, 240);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setText("welcome ");
        add(jLabel3);
        jLabel3.setBounds(140, 50, 120, 30);

        empName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add(empName);
        empName.setBounds(260, 50, 320, 30);

        address.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(address);
        address.setBounds(150, 290, 340, 30);

        rank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(rank);
        rank.setBounds(140, 200, 260, 30);

        DOB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(DOB);
        DOB.setBounds(140, 230, 260, 30);

        jButton1.setText("Exit");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(630, 590, 110, 40);

        jButton3.setText("Search for Customer");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(390, 340, 180, 40);

        jButton4.setText("my classes ");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(630, 340, 180, 40);

        manager.setText("manger options");
        manager.setToolTipText("");
        manager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerActionPerformed(evt);
            }
        });
        add(manager);
        manager.setBounds(150, 340, 180, 40);

        jButton6.setText("Sign Out");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(150, 590, 120, 40);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("change Password");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7);
        jButton7.setBounds(680, 230, 200, 31);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DataBase.exitFrame();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JPanel temp = new searchForCustomer();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JPanel temp = new ClassesProgram();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void managerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerActionPerformed
        // TODO add your handling code here:
        JPanel temp = new mangerOptions();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_managerActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        JPanel temp = new LogIn();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JPanel temp = new ChangePassword();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        JPanel temp = new editEmployee();
        DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DOB;
    private javax.swing.JLabel address;
    private javax.swing.JLabel email;
    private javax.swing.JLabel empName;
    private javax.swing.JLabel gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton manager;
    private javax.swing.JLabel name;
    private javax.swing.JLabel rank;
    // End of variables declaration//GEN-END:variables
}