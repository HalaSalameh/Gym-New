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
@Table(name = "classes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c")
    , @NamedQuery(name = "Classes.findByClassId", query = "SELECT c FROM Classes c WHERE c.classId = :classId")
    , @NamedQuery(name = "Classes.findByClassPeriod", query = "SELECT c FROM Classes c WHERE c.classPeriod = :classPeriod")
    , @NamedQuery(name = "Classes.findByType", query = "SELECT c FROM Classes c WHERE c.type = :type")
    , @NamedQuery(name = "Classes.findByNumOfHours", query = "SELECT c FROM Classes c WHERE c.numOfHours = :numOfHours")
    , @NamedQuery(name = "Classes.findByClassName", query = "SELECT c FROM Classes c WHERE c.className = :className")})
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "classId")
    private Integer classId;
    @Column(name = "classPeriod")
    private String classPeriod;
    @Column(name = "type")
    private String type;
    @Column(name = "numOfHours")
    private Integer numOfHours;
    @Column(name = "className")
    private String className;
    @OneToMany(mappedBy = "classId")
    private Collection<Sections> sectionsCollection;

    public Classes() {
    }

    public Classes(Integer classId) {
        this.classId = classId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassPeriod() {
        return classPeriod;
    }

    public void setClassPeriod(String classPeriod) {
        this.classPeriod = classPeriod;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumOfHours() {
        return numOfHours;
    }

    public void setNumOfHours(Integer numOfHours) {
        this.numOfHours = numOfHours;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @XmlTransient
    public Collection<Sections> getSectionsCollection() {
        return sectionsCollection;
    }

    public void setSectionsCollection(Collection<Sections> sectionsCollection) {
        this.sectionsCollection = sectionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classId != null ? classId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.classId == null && other.classId != null) || (this.classId != null && !this.classId.equals(other.classId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Classes[ classId=" + classId + " ]";
    }
    
}
