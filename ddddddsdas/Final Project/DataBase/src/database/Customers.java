/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import static database.User_.userId;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCusid", query = "SELECT c FROM Customers c WHERE c.cusid = :cusid")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cusid")
    private Integer cusid;
    @JoinTable(name = "signup", joinColumns = {
        @JoinColumn(name = "cusId", referencedColumnName = "cusid")}, inverseJoinColumns = {
        @JoinColumn(name = "sectionId", referencedColumnName = "sectionId")})
    @ManyToMany
    private Collection<Sections> sectionsCollection;
    @OneToMany(mappedBy = "cusId")
    private Collection<Medicalsituation> medicalsituationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Collection<Memcus> memcusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    //private Collection<Payfor> payforCollection;
    @JoinColumn(name = "userid", referencedColumnName = "userId")
    @ManyToOne
    private User userid;
    @JoinColumn(name = "programId", referencedColumnName = "programId")
    @ManyToOne
    private Programs programId;

    public Customers() {
    }

    public Customers(Integer userId) throws SQLException, ClassNotFoundException {
        String sql = "select * from Customers as c where c.userId = " + userId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        if (set.next()) {
            this.cusid = set.getInt(1);
            this.programId = new Programs(set.getInt(3));
        }

    }

    @XmlTransient
    public Collection<Sections> getSectionsCollethisction() {
        return sectionsCollection;
    }

    public void setSectionsCollection(Collection<Sections> sectionsCollection) {
        this.sectionsCollection = sectionsCollection;
    }

    @XmlTransient
    public Collection<Medicalsituation> getMedicalsituationCollection() {
        return medicalsituationCollection;
    }

    public void setMedicalsituationCollection(Collection<Medicalsituation> medicalsituationCollection) {
        this.medicalsituationCollection = medicalsituationCollection;
    }

    @XmlTransient
    public Collection<Memcus> getMemcusCollection() {
        return memcusCollection;
    }

    public void setMemcusCollection(Collection<Memcus> memcusCollection) {
        this.memcusCollection = memcusCollection;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Programs getProgramId() {
        return programId;
    }

    public void setProgramId(Programs programId) throws SQLException, ClassNotFoundException {
        this.programId = programId;
        String sql = "update  customers set programId = " + programId.getProgramId() + " where cusId = " + cusid;
        DatabaseAPI db = new DatabaseAPI();
        db.write(sql);

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusid != null ? cusid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.cusid == null && other.cusid != null) || (this.cusid != null && !this.cusid.equals(other.cusid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Customers[ cusid=" + cusid + " ]";
    }

    public static int addCus(int userId, boolean isEmp) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO customers (userId , programId )  Values ( " + userId + " ,null)";

        DatabaseAPI db = new DatabaseAPI();
        int ide = 0;
        ide = db.write(sql);

        return ide;
    }

    public Integer getCusid() {
        return cusid;
    }

    public static void removeCustomer(int id) throws SQLException, ClassNotFoundException {
        DatabaseAPI db = new DatabaseAPI();
        String sql = "SELECT u.userid FROM user as u,customers as c WHERE c.cusid = " + id + " and c.userid = u.userid";
        ResultSet set = db.read(sql);
        int usid = 0;
        while (set.next()) {
            usid = set.getInt(1);
        }
        String sql2 = "delete from  customers where cusid = " + id;
        db.write(sql2);
        String sql3 = "delete from  user where userid = " + usid;
        db.write(sql3);

    }

    public static void signForAClass(int sectionId, int cusId) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO signup Values ( " + cusId + " , " + sectionId +" , '" + LocalDateTime.now().toString().substring(0,10)+ "' )";
        System.out.println(sql);
        System.out.println(sql);
        DatabaseAPI db = new DatabaseAPI();

        db.write(sql);

    }

    public static boolean getMemStates(int cusId) throws SQLException, ClassNotFoundException {
        boolean active = false;
        String sql = "select * from memcus where cusId = " + cusId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        Date current = java.sql.Timestamp.valueOf(LocalDateTime.now());
        while (set.next()) {

            Calendar c1 = Calendar.getInstance();
            int memId = set.getInt(1);
            String sql2 = " select m.mounths from membership as m where m.memid = " + memId;
            ResultSet set2 = db.read(sql2);
            int months = 0;
            while (set2.next()) {
                months = set2.getInt(1);
            }
            c1.setTime(set.getDate(3));

            c1.add(Calendar.MONTH, months);
            Date endDate = (Date) c1.getTime();

            if (current.compareTo(set.getDate(3)) * current.compareTo(endDate) <= 0) {
                active = true;
            }

        }
        return active;

    }

    public static double getBalance(int cusId) throws SQLException, ClassNotFoundException {
        double payments = 0;
        double cost = 0;

        String sql = "select cost from memcus where cusId = " + cusId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        while (set.next()) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+set.getDouble(1));
            cost += set.getDouble(1);
        }

        sql = "select payment from payments where cusId = " + cusId;
        set = db.read(sql);
        while (set.next()) {
            payments += set.getDouble(1);
        }

        return payments - cost;

    }
    
    public static int getActiv(int cusId){
        int memId = 0 ;
         return memId;
         
    
}
    
    
    public static String endDate (int cusId) throws SQLException, ClassNotFoundException
            
    {
        String endDateStr = "";
        String sql = "select * from memcus where cusId = " + cusId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        Date current = java.sql.Timestamp.valueOf(LocalDateTime.now());
        while (set.next()) {

            Calendar c1 = Calendar.getInstance();
            int memId = set.getInt(1);
            String sql2 = " select m.mounths from membership as m where m.memid = " + memId;
            ResultSet set2 = db.read(sql2);
            int months = 0;
            while (set2.next()) {
                months = set2.getInt(1);
            }
            c1.setTime(set.getDate(3));

            c1.add(Calendar.MONTH, months);
            Date endDate = (Date) c1.getTime();

            if (current.compareTo(set.getDate(3)) * current.compareTo(endDate) <= 0) {
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
                endDateStr = dt1.format(endDate);
            }

        }
        
        return   endDateStr;
    }
    
    public static boolean getMemStates(int cusId, int memId1) throws SQLException, ClassNotFoundException {
        boolean active = false;
        String sql = "select mem.memid ,mem.cusId , mem.startDate , mem.cost , m.mounths  from memcus as mem ,membership as m where mem.cusId = " + cusId + " and mem.memId = " + memId1 + " and mem.memId = m.memid";
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        Date current = java.sql.Timestamp.valueOf(LocalDateTime.now());
        while (set.next()) {

            Calendar c1 = Calendar.getInstance();
            int memId = set.getInt(1);
   
            int months = 0;
           
                months = set.getInt(5);
            
            c1.setTime(set.getDate(3));

            c1.add(Calendar.MONTH, months);
            Date endDate = (Date) c1.getTime();

            if (current.compareTo(set.getDate(3)) * current.compareTo(endDate) <= 0) {
                active = true;
            }

        }
        return active;

    }
}
