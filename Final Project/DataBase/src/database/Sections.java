/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
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
    private Collection<Appointments> appointmentsCollection;
    @JoinColumn(name = "classId", referencedColumnName = "classId")
    @ManyToOne
    private Classes classId;

    public Sections() {
    }

    public Sections(Integer sectionId) {
        this.sectionId = sectionId;
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

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @XmlTransient
    public Collection<Appointments> getAppointmentsCollection() {
        return appointmentsCollection;
    }

    public void setAppointmentsCollection(Collection<Appointments> appointmentsCollection) {
        this.appointmentsCollection = appointmentsCollection;
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
    
}
