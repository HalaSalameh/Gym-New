/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
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
    private Collection<Payfor> payforCollection;
    @JoinColumn(name = "userid", referencedColumnName = "userId")
    @ManyToOne
    private User userid;
    @JoinColumn(name = "programId", referencedColumnName = "programId")
    @ManyToOne
    private Programs programId;

    public Customers() {
    }

    public Customers(Integer cusid) {
        this.cusid = cusid;
    }

    public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
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
    public Collection<Memcus> getMemcusCollection() {
        return memcusCollection;
    }

    public void setMemcusCollection(Collection<Memcus> memcusCollection) {
        this.memcusCollection = memcusCollection;
    }

    @XmlTransient
    public Collection<Payfor> getPayforCollection() {
        return payforCollection;
    }

    public void setPayforCollection(Collection<Payfor> payforCollection) {
        this.payforCollection = payforCollection;
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

    public void setProgramId(Programs programId) {
        this.programId = programId;
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
    
}
