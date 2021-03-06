/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import database.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class ClassesProgram extends javax.swing.JPanel {

    /**
     * Creates new form ClassesProgram
     */
    public ClassesProgram() throws SQLException, ClassNotFoundException {
        initComponents();
        name.setText(User.mainUser.getName());
        DefaultTableModel model = (DefaultTableModel) sch.getModel();
         DatabaseAPI db = new DatabaseAPI();
         String sql="";
         int count=0;
        if (User.mainUser.getIsEmp()==false)
        {
              sql="select cl.className ,s.sectionid,s.day,s.hour  from customers as c, sections as s, signup as si ,classes as cl where s.sectionid=si.sectionid and c.cusid= si.cusid and s.classid=cl.classid and c.cusid = "+User.mainUser.getCus().getCusid();       
        }
        else
        {
             sql="select cl.className , s.sectionId, s.day, s.hour from sections as s, signup as si, classes as cl where s.sectionid=si.sectionid and s.classid=cl.classid and s.empId = "+User.mainUser.getEmp().getEmpId();
        }
        ResultSet set = db.read(sql);
              while (set.next())
              {
                  count++;
                   String f=day(set.getInt(3));
                  model.addRow(new Object[]{set.getString(1), set.getString(2), f, set.getString(4)});
              }
        num.setText("Number Of Classes : "+count);
        
    }
     public String day(int i)
    {
        switch (i)
        {
            case 0: return "Saturday";
            case 1: return "Sunday";
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5 :return "Thursday";
            case 6: return "Friday";
            
        }
        return null;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sch = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(770, 550));
        setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/log.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(600, 320, 130, 100);

        num.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        num.setForeground(new java.awt.Color(255, 102, 0));
        add(num);
        num.setBounds(60, 330, 370, 40);

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(0, 153, 153));
        add(name);
        name.setBounds(270, 40, 290, 40);

        sch.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        sch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sch.setForeground(new java.awt.Color(0, 153, 153));
        sch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class Name", "Section Number", "Day", "ClassTime "
            }
        ));
        jScrollPane1.setViewportView(sch);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 710, 150);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Schedule For :");
        add(jLabel2);
        jLabel2.setBounds(80, 40, 190, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/test.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 393, 648);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel num;
    private javax.swing.JTable sch;
    // End of variables declaration//GEN-END:variables
}
