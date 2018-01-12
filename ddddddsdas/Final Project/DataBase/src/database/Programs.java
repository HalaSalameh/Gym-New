/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "programs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programs.findAll", query = "SELECT p FROM Programs p")
    , @NamedQuery(name = "Programs.findByProgramId", query = "SELECT p FROM Programs p WHERE p.programId = :programId")
    , @NamedQuery(name = "Programs.findByWeeklyTrainingHour", query = "SELECT p FROM Programs p WHERE p.weeklyTrainingHour = :weeklyTrainingHour")
    , @NamedQuery(name = "Programs.findByFoodType", query = "SELECT p FROM Programs p WHERE p.foodType = :foodType")})
public class Programs implements Serializable {

    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "Breakfast")
    private String breakfast;
    @Column(name = "Lunch")
    private String lunch;
    @Column(name = "Dinner")
    private String dinner;
    @Column(name = "Notes")
    private String notes;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "programId")
    private Integer programId;
    @Column(name = "weeklyTrainingHour")
    private Integer weeklyTrainingHour;
    @Column(name = "foodType")
    private String foodType;
    @OneToMany(mappedBy = "programId")
    private Collection<Customers> customersCollection;
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    @ManyToOne
    private Employee empId;

    public Programs() {
    }

    public Programs(Integer programId) throws SQLException, ClassNotFoundException {

        this.programId = programId;
        String sql = "select * from programs as u where u.programid =  " + programId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        while (set.next()) {
            
            //this.empId=set.getInt(2);
            this.breakfast=set.getString(3);
            this.lunch=set.getString(4);
            this.dinner=set.getString(5);
            this.notes=set.getString(6);
        }
       
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

   

    @XmlTransient
    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) throws SQLException, ClassNotFoundException {
        this.empId = empId;
           DatabaseAPI db = new DatabaseAPI();
         String sql = "update table programs where programId =  " + this.programId + " set empid = " + empId;
         db.write(sql);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programs)) {
            return false;
        }
        Programs other = (Programs) object;
        if ((this.programId == null && other.programId != null) || (this.programId != null && !this.programId.equals(other.programId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Programs[ programId=" + programId + " ]";
    }
    
   
    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) throws SQLException, ClassNotFoundException {
        this.breakfast = breakfast;
        
          DatabaseAPI db = new DatabaseAPI();
         String sql = "update table programs where programId =  " + this.programId + " set breakfast = '" + breakfast+"' ";
         db.write(sql);
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) throws SQLException, ClassNotFoundException {
        this.lunch = lunch;
        
          DatabaseAPI db = new DatabaseAPI();
         String sql = "update table programs where programId =  " + this.programId + " set lunch = '" + lunch+"' ";
         db.write(sql);
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) throws SQLException, ClassNotFoundException {
        this.dinner = dinner;
          DatabaseAPI db = new DatabaseAPI();
         String sql = "update table programs where programId =  " + this.programId + " set dinner = '" + dinner+"' ";
         db.write(sql);
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) throws SQLException, ClassNotFoundException {
        this.notes = notes;
          DatabaseAPI db = new DatabaseAPI();
         String sql = "update table programs where programId =  " + this.programId + " set notes = '" + notes+"' ";
         db.write(sql);
    }
     public static int newProgram(int empId,String Breakfast,String lunch ,String dinner ,String notes) throws SQLException, ClassNotFoundException
    {
        DatabaseAPI db = new DatabaseAPI();
        String sql = "insert into programs values (null, " +  empId+ ", '" +Breakfast+"' , '"+lunch+"' , '"+dinner + "' , '"+notes+"' )";
        System.out.println(sql);
        int ide=0;
        ide=db.write(sql);
        return ide;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) throws SQLException, ClassNotFoundException {
        this.startDate = startDate;
         DatabaseAPI db = new DatabaseAPI();
         String sql = "update table programs where programId =  " + this.programId + " set startDate = '" + startDate+"' ";
         db.write(sql);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) throws SQLException, ClassNotFoundException {
        this.endDate = endDate;
        DatabaseAPI db = new DatabaseAPI();
         String sql = "update table programs where programId =  " + this.programId + " set endDate = '" + endDate+"' ";
         db.write(sql);
    }

    
}
