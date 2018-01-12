/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import static database.User_.password;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmpId", query = "SELECT e FROM Employee e WHERE e.empId = :empId")
    , @NamedQuery(name = "Employee.findByRank", query = "SELECT e FROM Employee e WHERE e.rank = :rank")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empId")
    private Integer empId;
    @Column(name = "rank")
    private Integer rank;
    @ManyToMany(mappedBy = "employeeCollection")
    private Collection<Sections> sectionsCollection;
    @JoinColumn(name = "userid", referencedColumnName = "userId")
    @ManyToOne
    private User userid;
    @OneToMany(mappedBy = "empId")
    private Collection<Medicalsituation> medicalsituationCollection;
    @OneToMany(mappedBy = "empId")
    private Collection<Programs> programsCollection;

    public Employee() {
    }

    public Employee(Integer userId) throws SQLException, ClassNotFoundException {

        String sql = "select * from employee as u where u.userid =  " + userId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        while (set.next()) {
            this.empId = set.getInt(1);
            this.rank = set.getInt(2);
        }
    }

    public Integer getEmpId() {
        return empId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) throws SQLException, ClassNotFoundException {
        DatabaseAPI db = new DatabaseAPI();
        String sql = "update table employee where empId =  " + empId + " set rank = " + rank;
        db.write(sql);
        
        this.rank = rank;
    }

    @XmlTransient
    public Collection<Sections> getSectionsCollection() {
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
    public Collection<Programs> getProgramsCollection() {
        return programsCollection;
    }

    public void setProgramsCollection(Collection<Programs> programsCollection) {
        this.programsCollection = programsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Employee[ empId=" + empId + " ]";
    }

    public static int addEmployee(String rank, int userId) throws SQLException, ClassNotFoundException {
        DatabaseAPI db = new DatabaseAPI();
        String sql = "insert into employee values (null, " + rank + " ," + userId + " )";
       
        int ide = 0;
        ide = db.write(sql);
        System.out.println(ide+"this is the employee id!!!");
        return ide;
    }

    public static void removeEmployee(int id) throws SQLException, ClassNotFoundException {
        DatabaseAPI db = new DatabaseAPI();
        String sql = "SELECT u.userid FROM user as u,employee as c WHERE c.empid = " + id + " and c.userid = u.userid";
        ResultSet set = db.read(sql);
        int usid = 0;
        while (set.next()) {
            usid = set.getInt(1);
        }
        String sql2 = "delete from  employee where empid = " + id;
        db.write(sql2);
        String sql3 = "delete from  user where userid = " + usid;
        db.write(sql3);
       
       

    }

}
