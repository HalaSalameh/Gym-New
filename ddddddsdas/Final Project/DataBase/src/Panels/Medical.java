/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.DataBase;
import database.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class Medical extends javax.swing.JPanel {

    /**
     * Creates new form Medical
     */
    public Medical(int cusId) throws SQLException, ClassNotFoundException {
        initComponents();
         String sql = "select u.name ,m.weight , m.diseases, m.measurment from user as u ,medicalsituation as m ,customers as c where m.cusId = c.cusid  and u.userId = c.userid and c.cusId = " + cusId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        while (set.next()) {
            Name.setText(set.getString(1) + " Medical Situation ");
            weight.setText("Weight :" + set.getDouble(2));
            nut.setText("Diseases :" + set.getString(3));
            height1.setText("Height :" + set.getString(4));
        
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

        nut = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        height1 = new javax.swing.JLabel();
        weight = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(790, 400));
        setLayout(null);

        nut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nut.setForeground(new java.awt.Color(0, 153, 153));
        add(nut);
        nut.setBounds(70, 220, 130, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 102, 0));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(400, 280, 70, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 51));
        jButton1.setText("Back ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(70, 270, 80, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Diseases : ");
        add(jLabel6);
        jLabel6.setBounds(70, 170, 310, 40);

        height1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        height1.setForeground(new java.awt.Color(0, 153, 153));
        height1.setText("Height : ");
        add(height1);
        height1.setBounds(70, 140, 280, 20);

        weight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        weight.setForeground(new java.awt.Color(0, 153, 153));
        weight.setText("Weight : ");
        add(weight);
        weight.setBounds(70, 100, 260, 30);

        Name.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 102, 0));
        Name.setText("Medical Situation .....................................................");
        add(Name);
        Name.setBounds(60, 20, 620, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/test.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 491, 515);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/big.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(460, 80, 330, 262);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (User.mainUser.getIsEmp()==false)
        {JPanel CustomerPanel = new Customer();
        DataBase.changePanel(CustomerPanel);}
        else
        {
            try {
                JPanel CustomerPanel = new Reception();
                DataBase.changePanel(CustomerPanel);
            }
            // TODO add your handling code here:
            catch (SQLException ex) {
                Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Medical.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         DataBase.exitFrame();
    }//GEN-LAST:event_jButton2ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JLabel height1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel nut;
    private javax.swing.JLabel weight;
    // End of variables declaration//GEN-END:variables
}
