/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class LogIn extends javax.swing.JPanel {

    /**
     * Creates new form LogIn
     */
    public LogIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(32767, 32766));
        setMinimumSize(new java.awt.Dimension(32767, 32767));
        setPreferredSize(new java.awt.Dimension(789, 495));
        setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/Picture111.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(150, 0, 399, 240);

        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(80, 260, 140, 30);

        jTextField1.setToolTipText("User Name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(80, 290, 210, 30);

        jLabel4.setText("Password");
        add(jLabel4);
        jLabel4.setBounds(410, 260, 140, 30);

        jButton1.setBackground(java.awt.Color.lightGray);
        jButton1.setForeground(new java.awt.Color(0, 102, 255));
        jButton1.setText("Log In");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(300, 350, 120, 40);
        add(jPasswordField1);
        jPasswordField1.setBounds(410, 290, 230, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/Picture122.png"))); // NOI18N
        jLabel3.setLabelFor(jLabel3);
        add(jLabel3);
        jLabel3.setBounds(0, 0, 789, 445);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        JPanel customerPanel = new Customer();
        System.out.println(customerPanel.size());
        DataBase.changePanel(customerPanel, 500, 800);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
