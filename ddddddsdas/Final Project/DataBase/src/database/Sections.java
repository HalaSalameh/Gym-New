/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "sections")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sections.findAll", query = "SELECT s FROM Sections s")
    , @NamedQuery(name = "Sections.findBySectionId", query = "SELECT s FROM Sections s WHERE s.sectionId = :sectionId")
    , @NamedQuery(name = "Sections.findByLevel", query = "SELECT s FROM Sections s WHERE s.level = :level")
    , @NamedQuery(name = "Sections.findByAge", query = "SELECT s FROM Sections s WHERE s.age = :age")})
public class Sections implements Serializable {

    @Column(name = "numOfstudents")
    private Integer numOfstudents;
    @JoinColumn(name = "empid", referencedColumnName = "empId")
    @ManyToOne
    private Employee empid;

    @Column(name = "day")
    private Integer day;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "hour")
    private Double hour;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sectionId")
    private Integer sectionId;
    @Column(name = "level")
    private Integer level;
    @Column(name = "age")
    private Integer age;
    @ManyToMany(mappedBy = "sectionsCollection")
    private Collection<Customers> customersCollection;
    @JoinTable(name = "teaches", joinColumns = {
        @JoinColumn(name = "sectionId", referencedColumnName = "sectionId")}, inverseJoinColumns = {
        @JoinColumn(name = "empId", referencedColumnName = "empId")})
    @ManyToMany
    private Collection<Employee> employeeCollection;
    @OneToMany(mappedBy = "sectionId")
    @JoinColumn(name = "classId", referencedColumnName = "classId")
    @ManyToOne
    private Classes classId;

    public Sections() {
    }

    public Sections(Integer sectionId, int level, int age) {
        this.sectionId = sectionId;
        this.level = level;
        this.age = age;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) throws SQLException, ClassNotFoundException {
        this.level = level;
        DatabaseAPI db = new DatabaseAPI();
        String sql = "update table classes where classId =  " + this.sectionId + " set level = " + level;
        db.write(sql);

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) throws SQLException, ClassNotFoundException {
        this.age = age;
        DatabaseAPI db = new DatabaseAPI();
        String sql = "update table classes where classId =  " + this.sectionId + " set age = " + age;
        db.write(sql);

    }

    @XmlTransient
    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public Classes getClassId() {
        return classId;
    }

    public void setClassId(Classes classId) {
        this.classId = classId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sections)) {
            return false;
        }
        Sections other = (Sections) object;
        if ((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Sections[ sectionId=" + sectionId + " ]";
    }

    public static void addSection(int classId, int level, int age, int day, double hour,int empid) throws SQLException, ClassNotFoundException {

        DatabaseAPI db = new DatabaseAPI();
        String sql = "insert into sections values (null , " + classId + " , " + level + " , " + age + " ," + day + " , " + hour + " , "+empid+" , "+0+" )";
        System.out.println(sql);
        db.write(sql);

    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Integer getNumOfstudents() {
        return numOfstudents;
    }

    public void setNumOfstudents(Integer numOfstudents) {
        this.numOfstudents = numOfstudents;
    }

    public Employee getEmpid() {
        return empid;
    }

    public void setEmpid(Employee empid) {
        this.empid = empid;
    }

}
