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
@Table(name = "programs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programs.findAll", query = "SELECT p FROM Programs p")
    , @NamedQuery(name = "Programs.findByProgramId", query = "SELECT p FROM Programs p WHERE p.programId = :programId")
    , @NamedQuery(name = "Programs.findByWeeklyTrainingHour", query = "SELECT p FROM Programs p WHERE p.weeklyTrainingHour = :weeklyTrainingHour")
    , @NamedQuery(name = "Programs.findByFoodType", query = "SELECT p FROM Programs p WHERE p.foodType = :foodType")})
public class Programs implements Serializable {

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

    public Programs(Integer programId) {
        this.programId = programId;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Integer getWeeklyTrainingHour() {
        return weeklyTrainingHour;
    }

    public void setWeeklyTrainingHour(Integer weeklyTrainingHour) {
        this.weeklyTrainingHour = weeklyTrainingHour;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
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

    public void setEmpId(Employee empId) {
        this.empId = empId;
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
    
}
