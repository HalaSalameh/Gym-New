/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.Customers;
import database.DataBase;
import database.Memcus;
import database.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
public class CustomerForRes extends javax.swing.JPanel {

    /**
     * Creates new form Customer
     */
    JDatePickerImpl datePicker;
    JDatePickerImpl datePicker1;
    int cusId;
    ArrayList<Integer> memsId;

    public CustomerForRes(int cusId) {
        this.cusId = cusId;
        memsId = new ArrayList<>();
        try {
            initComponents();
            UtilDateModel model = new UtilDateModel();
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
            JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
            datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
            datePicker.setBounds(200, 300, 200, 27);
            add(datePicker);

            String sql = "select u.name ,u.email from user as u , customers as c where u.userid = c.userid and c.cusid  = " + cusId;
            System.out.println(sql);
            DatabaseAPI db = new DatabaseAPI();
            ResultSet set = db.read(sql);
            while (set.next()) {
                Name.setText("Name :" + set.getString(1));
                email.setText("Email :" + set.getString(2));
            }

            sql = "select m.memName ,m.memId from membership as m";
            set = db.read(sql);
            while (set.next()) {
                memTypes.addItem(set.getString(1));
                memsId.add(set.getInt(2));
            }
            
           
           if(Customers.getMemStates(cusId))
               mem.setText("Membership stutas :Active");
           else
              mem.setText("Membership stutas :Not Active");

            balance.setText("Balance :"+Customers.getBalance(cusId));

        } catch (SQLException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
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

        cost = new javax.swing.JTextField();
        memTypes = new javax.swing.JComboBox<>();
        mem = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        memStuats = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        costLabel1 = new javax.swing.JLabel();
        memStuats1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 32766));
        setMinimumSize(new java.awt.Dimension(32767, 32767));
        setPreferredSize(new java.awt.Dimension(663, 647));
        setRequestFocusEnabled(false);
        setLayout(null);

        cost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cost.setForeground(new java.awt.Color(0, 153, 153));
        cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costActionPerformed(evt);
            }
        });
        add(cost);
        cost.setBounds(230, 470, 100, 30);

        memTypes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        memTypes.setForeground(new java.awt.Color(0, 153, 153));
        add(memTypes);
        memTypes.setBounds(240, 330, 100, 30);

        mem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mem.setForeground(new java.awt.Color(255, 102, 0));
        mem.setText("Membership stutas :");
        add(mem);
        mem.setBounds(50, 160, 250, 30);

        balance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 102, 0));
        balance.setText("Balance :");
        add(balance);
        balance.setBounds(310, 160, 150, 30);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 153, 153));
        jButton10.setText("Current MemberShip");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        add(jButton10);
        jButton10.setBounds(50, 200, 210, 40);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 153, 153));
        jButton5.setText("Financial Record");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(300, 200, 210, 40);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 153, 153));
        jButton9.setText("Add New Payment");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9);
        jButton9.setBounds(310, 520, 200, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Renew MemberShip:");
        add(jLabel10);
        jLabel10.setBounds(60, 250, 190, 20);

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 153, 153));
        jButton11.setText("Add new Membership");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        add(jButton11);
        jButton11.setBounds(310, 380, 200, 40);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 102, 0));
        jButton7.setText("Exit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7);
        jButton7.setBounds(340, 580, 80, 25);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 102, 0));
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(40, 580, 140, 23);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setText("Payed amount");
        add(jLabel9);
        jLabel9.setBounds(90, 460, 140, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("add new payment");
        add(jLabel8);
        jLabel8.setBounds(60, 440, 190, 20);

        memStuats.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        memStuats.setForeground(new java.awt.Color(255, 102, 0));
        add(memStuats);
        memStuats.setBounds(70, 520, 230, 40);

        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(255, 102, 0));
        email.setText("Email : ");
        add(email);
        email.setBounds(50, 100, 450, 40);

        Name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 102, 0));
        Name.setText("Name : ");
        add(Name);
        Name.setBounds(50, 80, 240, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 0));
        jLabel11.setText("Membership type");
        add(jLabel11);
        jLabel11.setBounds(80, 330, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Customer Information..........");
        add(jLabel4);
        jLabel4.setBounds(50, 40, 470, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/log.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(390, 0, 146, 90);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/test.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, -10, 663, 648);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 0));
        jLabel14.setText("Start Date:");
        add(jLabel14);
        jLabel14.setBounds(80, 290, 110, 30);

        costLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        costLabel1.setForeground(new java.awt.Color(255, 102, 0));
        add(costLabel1);
        costLabel1.setBounds(380, 330, 110, 30);

        memStuats1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        memStuats1.setForeground(new java.awt.Color(255, 102, 0));
        add(memStuats1);
        memStuats1.setBounds(70, 380, 230, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        JPanel LogInPanel = new LogIn();
        DataBase.changePanel(LogInPanel);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        DataBase.exitFrame();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        try {
            //cost.setText(TOOL_TIP_TEXT_KEY);
            double payment = Double.parseDouble(cost.getText());
            String sql = "insert into payments values ( null , " + cusId + " ,  '" + LocalDateTime.now().toString().substring(0, 10) + "' , " + payment + " )";
            DatabaseAPI db = new DatabaseAPI();
            db.write(sql);
            memStuats1.setText("The Payment Added successfully");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            // TODO add your handling code here:
            JPanel temp = new Membership1(cusId);
            DataBase.changePanel(temp);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JPanel temp = new FinancialRecord(cusId);
            DataBase.changePanel(temp);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        try {
            java.sql.Date startDate = new java.sql.Date(((Date) datePicker.getModel().getValue()).getTime());
            int memId = memsId.get(memTypes.getSelectedIndex());
            // double cost = Double.parseDouble(this.cost.getText());
            double cost = 0;
            String sql2 = "select m.cost from membership as m where m.memid = " + memId;
            DatabaseAPI db = new DatabaseAPI();
            ResultSet set = db.read(sql2);
            while (set.next()) {
                cost = set.getDouble(1);
            }
            Memcus.add(cusId, memId, startDate, cost);
            System.out.println("here?????");
            memStuats.setText("Membership Added");

        } catch (SQLException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForRes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JLabel balance;
    private javax.swing.JTextField cost;
    private javax.swing.JLabel costLabel1;
    private javax.swing.JLabel email;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel mem;
    private javax.swing.JLabel memStuats;
    private javax.swing.JLabel memStuats1;
    private javax.swing.JComboBox<String> memTypes;
    // End of variables declaration//GEN-END:variables
}
