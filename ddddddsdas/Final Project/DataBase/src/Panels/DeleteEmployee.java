/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.DataBase;
import database.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP
 */
public class DeleteEmployee extends javax.swing.JPanel {

    /**
     * Creates new form searchForEmp
     */
   public DeleteEmployee() throws SQLException, ClassNotFoundException {
        initComponents();
        String sql = "select * from user as u , employee as e where u.userId = e.userid; ";
        DatabaseAPI db = new DatabaseAPI();

        ResultSet set = db.read(sql);
        DefaultTableModel model = (DefaultTableModel) emps.getModel();
        while (set.next()) {
            int userId = set.getInt(1);
            String name = set.getString(2);
            String gender = "";
            if (set.getBoolean(4)) {
                gender = "Female";
            } else {
                gender = "Male";
            }

            String email = set.getString(5);

            String DoB = set.getString(6);
            String Hd = set.getString(8);
            int empId = set.getInt(10);
            String rank = "";
            switch (set.getInt(11)) {
                case 1:
                    rank = "Receptionist";
                    break;
                case 2:
                    rank = "Manager";
                    break;
                case 3:
                    rank = "Coach";
                    break;
                case 4:
                    rank = "Nutritionist";
            }

            model.addRow(new Object[]{userId, "emp" + empId, name, rank, email, gender, Hd, DoB});
            emps.getColumnModel().getColumn(1).setMinWidth(0);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rank = new javax.swing.JComboBox<>();
        name = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        emps = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(929, 591));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Name");
        add(jLabel1);
        jLabel1.setBounds(103, 103, 64, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Rank");
        jLabel4.setToolTipText("");
        add(jLabel4);
        jLabel4.setBounds(100, 200, 64, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Delete an employee .....");
        add(jLabel5);
        jLabel5.setBounds(113, 33, 363, 29);

        rank.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rank.setForeground(new java.awt.Color(0, 153, 153));
        rank.setMaximumRowCount(4);
        rank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Receptionist", "Manager", "Coach", "Nutritionist" }));
        add(rank);
        rank.setBounds(270, 200, 110, 20);

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(0, 153, 153));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add(name);
        name.setBounds(268, 105, 198, 23);

        userName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userName.setForeground(new java.awt.Color(0, 153, 153));
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        add(userName);
        userName.setBounds(268, 136, 198, 23);

        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(0, 153, 153));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        add(email);
        email.setBounds(268, 167, 198, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/Picture111.png"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(470, 0, 350, 240);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 102, 0));
        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(100, 450, 110, 31);

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 102, 0));
        jButton2.setText("search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(320, 240, 130, 31);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 0));
        jButton1.setText("Delete The selected");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(470, 460, 230, 31);

        emps.setBackground(new java.awt.Color(204, 204, 204));
        emps.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        emps.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        emps.setForeground(new java.awt.Color(0, 153, 153));
        emps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "user name ", "email", "rank"
            }
        ));
        jScrollPane1.setViewportView(emps);

        add(jScrollPane1);
        jScrollPane1.setBounds(100, 290, 670, 130);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Email");
        add(jLabel3);
        jLabel3.setBounds(103, 165, 64, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("User Name");
        add(jLabel2);
        jLabel2.setBounds(103, 134, 103, 22);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/ضضض.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        add(jLabel7);
        jLabel7.setBounds(0, 0, 880, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            int r = emps.getSelectedRow();
            String empId =  (String) emps.getValueAt(r, 1);
         ((DefaultTableModel)emps.getModel()).removeRow(r);
            int id = id = Integer.parseInt( empId.substring(3));
            Employee.removeEmployee(id );
            System.out.println(r);
          
        } catch (SQLException ex) {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         emps.setRowSorter(null);

        if (!name.getText().equals("")) {

            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) emps.getModel()));
            sorter.setRowFilter(RowFilter.regexFilter(name.getText(),2));
            emps.setRowSorter(sorter);

        }
        if (!email.getText().equals("")) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) emps.getModel()));
            sorter.setRowFilter(RowFilter.regexFilter(email.getText(),4));
            emps.setRowSorter(sorter);

        }
         if (!userName.getText().equals("")) {

            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) emps.getModel()));
            sorter.setRowFilter(RowFilter.regexFilter(userName.getText(),1));
            emps.setRowSorter(sorter);

        }
        if (rank.getSelectedIndex()!=0) {
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) emps.getModel()));
            sorter.setRowFilter(RowFilter.regexFilter(rank.getSelectedItem().toString(),3));
            System.out.println(rank.getSelectedItem().toString());
            emps.setRowSorter(sorter);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         JPanel temp = new empMainScreen();
         DataBase.changePanel(temp);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JTable emps;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JComboBox<String> rank;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}