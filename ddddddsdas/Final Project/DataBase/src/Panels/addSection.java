/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.DataBase;
import database.Sections;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class addSection extends javax.swing.JPanel {
 ArrayList <Integer> a=new ArrayList<Integer>();
    /**
     * Creates new form addSection
     */
    public addSection() throws SQLException, ClassNotFoundException {
        initComponents();
        String sql=" select u.name ,e.empid from user as u,employee as e where u.userid=e.userid and e.rank =3";
          DatabaseAPI db = new DatabaseAPI();
            ResultSet set = db.read(sql);
            while (set.next())
            {
                name.addItem(set.getString(1));
                a.add(set.getInt(2));
                
            }
        String sql1="select c.classId,c.className,c.type from classes c";
         DefaultTableModel model = (DefaultTableModel) browse.getModel();
         set = db.read(sql1);
            while (set.next())
            {
                 System.out.println(set.getString(1)+" "+ set.getString(2) +" "+set.getString(3) );
                 model.addRow(new Object[]{set.getString(1), set.getString(2), set.getString(3)});
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

        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        hour = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        browse = new javax.swing.JTable();
        name = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        level = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(663, 650));
        setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 0));
        jButton1.setText("Add Section");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(140, 550, 180, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("Hour : ");
        add(jLabel6);
        jLabel6.setBounds(80, 210, 110, 30);

        day.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        day.setForeground(new java.awt.Color(0, 153, 153));
        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });
        add(day);
        day.setBounds(140, 160, 170, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Day :");
        add(jLabel5);
        jLabel5.setBounds(80, 160, 110, 30);

        age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        age.setForeground(new java.awt.Color(0, 153, 153));
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        add(age);
        age.setBounds(180, 110, 140, 30);

        hour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hour.setForeground(new java.awt.Color(0, 153, 153));
        hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourActionPerformed(evt);
            }
        });
        add(hour);
        hour.setBounds(150, 210, 170, 30);

        browse.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        browse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        browse.setForeground(new java.awt.Color(0, 153, 153));
        browse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "classId", "Class Name", "Type"
            }
        ));
        jScrollPane1.setViewportView(browse);
        if (browse.getColumnModel().getColumnCount() > 0) {
            browse.getColumnModel().getColumn(0).setMinWidth(0);
            browse.getColumnModel().getColumn(0).setPreferredWidth(0);
            browse.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 300, 430, 220);

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setForeground(new java.awt.Color(0, 153, 153));
        add(name);
        name.setBounds(160, 250, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Coach : ");
        add(jLabel4);
        jLabel4.setBounds(80, 250, 110, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Age Limit :");
        add(jLabel3);
        jLabel3.setBounds(80, 100, 120, 40);

        level.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        level.setForeground(new java.awt.Color(0, 153, 153));
        level.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelActionPerformed(evt);
            }
        });
        add(level);
        level.setBounds(150, 60, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Level :");
        add(jLabel2);
        jLabel2.setBounds(80, 50, 70, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/test.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(10, -20, 663, 648);
    }// </editor-fold>//GEN-END:initComponents

    private void levelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelActionPerformed

    private void hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourActionPerformed

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String x=(String)name.getSelectedItem().toString();
        if ( !level.getText().equals("")&& !age.getText().equals("") && !day.getText().equals("") && !hour.getText().equals("")&& !x.equals(""))   
       {
           if (browse.getSelectedRow()!=-1)
           {
               try {
                   String sec =  (String) browse.getValueAt(browse.getSelectedRow(), 1);
                   Sections.addSection(Integer.parseInt(sec) , Integer.parseInt(level.getText()),Integer.parseInt(age.getText()), Integer.parseInt(day.getText()), Double.parseDouble(hour.getText()),a.get(name.getSelectedIndex()));
               } catch (SQLException ex) {
                   Logger.getLogger(addSection.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(addSection.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           else
           {
               try {
                   
                   JPanel temp = new addClass(Integer.parseInt(level.getText()),Integer.parseInt(age.getText()), Integer.parseInt(day.getText()), Double.parseDouble(hour.getText()),a.get(name.getSelectedIndex()));
                   DataBase.changePanel(temp);
               } catch (SQLException ex) {
                   Logger.getLogger(addSection.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(addSection.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
        
       
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.JTable browse;
    private javax.swing.JTextField day;
    private javax.swing.JTextField hour;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField level;
    private javax.swing.JComboBox<String> name;
    // End of variables declaration//GEN-END:variables
}
