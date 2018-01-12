/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.DataBase;
import database.User;
import java.sql.ResultSet;
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

        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 32766));
        setMinimumSize(new java.awt.Dimension(32767, 32767));
        setPreferredSize(new java.awt.Dimension(789, 495));
        setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        add(jLabel5);
        jLabel5.setBounds(70, 350, 210, 40);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/Picture111.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(150, 0, 399, 240);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(80, 260, 140, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 153, 153));
        jTextField1.setToolTipText("User Name");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(80, 290, 210, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Password");
        add(jLabel4);
        jLabel4.setBounds(410, 260, 140, 30);

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 0));
        jButton1.setText("Log In");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(300, 350, 120, 40);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 153, 153));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        add(jPasswordField1);
        jPasswordField1.setBounds(410, 290, 230, 30);

        jLabel3.setLabelFor(jLabel3);
        add(jLabel3);
        jLabel3.setBounds(0, 0, 0, 0);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /* EntityManager em = new EntityManager;
        System.out.println(em.createNamedQuery("findAll")
    .getResultList());*/

        String userName = jTextField1.getText();
        String pass = jPasswordField1.getText();
        System.out.println(userName.substring(0, 3) + "   " + userName.substring(0, 3).equals("emp"));
        if (userName.length() < 3) {
            jLabel5.setText("Invalid Username Or Password");
        } else if (userName.substring(0, 3).equals("emp")) {

            try {

                String sql = "SELECT u.userid FROM user as u,employee as c WHERE u.password = '" + pass + "' and c.empId= " + userName.substring(3) + " and c.userid = u.userid";
                System.out.println(sql);
              
                DatabaseAPI db = new DatabaseAPI();
                  System.out.println("here?");
                ResultSet set = db.read(sql);
              

                if (set.next()) {
                   
                    User user = new User(set.getInt(1), pass);
                    User.mainUser = user;
                    if (user.getIsEmp()) {
                        int rank = User.mainUser.getEmp().getRank();
                        if (rank == 1 || rank==3) {
                            JPanel ReceptionPanel = new Reception();
                            DataBase.changePanel(ReceptionPanel);
                        } else {
                            JPanel empMainScreenPanel = new empMainScreen();
                            DataBase.changePanel(empMainScreenPanel);

                        }

                    }
                } else {
                    jLabel5.setText("Invalid Username Or Password");
                    System.out.println("1");

                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        } else if (userName.substring(0, 3).equals("cus")) {

            try {

                String sql = "SELECT u.userid FROM user as u, customers as c WHERE u.password = '" + pass + "' and c.cusId = " + userName.substring(3) + " and c.userid = u.userid";
                System.out.println(sql);
                DatabaseAPI db = new DatabaseAPI();
                System.out.println("here?");
                ResultSet set = db.read(sql);
                boolean count = false;
               if (set.next()) {
                    User user = new User(set.getInt(1), pass);
                    User.mainUser = user;
                    JPanel temp = new Customer();
                    DataBase.changePanel(temp);
                   
                    count = true;
                }
                 else {
                    jLabel5.setText("Invalid Username Or Password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();

            }

        } else {
            jLabel5.setText("Invalid username or password!");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
