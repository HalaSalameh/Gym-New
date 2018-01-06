/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "memcus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memcus.findAll", query = "SELECT m FROM Memcus m")
    , @NamedQuery(name = "Memcus.findByMemId", query = "SELECT m FROM Memcus m WHERE m.memcusPK.memId = :memId")
    , @NamedQuery(name = "Memcus.findByCusId", query = "SELECT m FROM Memcus m WHERE m.memcusPK.cusId = :cusId")
    , @NamedQuery(name = "Memcus.findByStartDate", query = "SELECT m FROM Memcus m WHERE m.startDate = :startDate")
    , @NamedQuery(name = "Memcus.findByEndDate", query = "SELECT m FROM Memcus m WHERE m.endDate = :endDate")})
public class Memcus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MemcusPK memcusPK;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "memId", referencedColumnName = "memId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Membership membership;
    @JoinColumn(name = "cusId", referencedColumnName = "cusid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customers customers;

    public Memcus() {
    }

    public Memcus(MemcusPK memcusPK) {
        this.memcusPK = memcusPK;
    }

    public Memcus(int memId, int cusId) {
        this.memcusPK = new MemcusPK(memId, cusId);
    }

    public MemcusPK getMemcusPK() {
        return memcusPK;
    }

    public void setMemcusPK(MemcusPK memcusPK) {
        this.memcusPK = memcusPK;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memcusPK != null ? memcusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memcus)) {
            return false;
        }
        Memcus other = (Memcus) object;
        if ((this.memcusPK == null && other.memcusPK != null) || (this.memcusPK != null && !this.memcusPK.equals(other.memcusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Memcus[ memcusPK=" + memcusPK + " ]";
    }
    
}
