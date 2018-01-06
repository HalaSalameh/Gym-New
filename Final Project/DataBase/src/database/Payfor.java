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
@Table(name = "payfor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payfor.findAll", query = "SELECT p FROM Payfor p")
    , @NamedQuery(name = "Payfor.findByMemId", query = "SELECT p FROM Payfor p WHERE p.payforPK.memId = :memId")
    , @NamedQuery(name = "Payfor.findByCusId", query = "SELECT p FROM Payfor p WHERE p.payforPK.cusId = :cusId")
    , @NamedQuery(name = "Payfor.findByPayDate", query = "SELECT p FROM Payfor p WHERE p.payDate = :payDate")
    , @NamedQuery(name = "Payfor.findByCost", query = "SELECT p FROM Payfor p WHERE p.cost = :cost")})
public class Payfor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PayforPK payforPK;
    @Column(name = "payDate")
    @Temporal(TemporalType.DATE)
    private Date payDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @JoinColumn(name = "memId", referencedColumnName = "memId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Membership membership;
    @JoinColumn(name = "cusId", referencedColumnName = "cusid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customers customers;

    public Payfor() {
    }

    public Payfor(PayforPK payforPK) {
        this.payforPK = payforPK;
    }

    public Payfor(int memId, int cusId) {
        this.payforPK = new PayforPK(memId, cusId);
    }

    public PayforPK getPayforPK() {
        return payforPK;
    }

    public void setPayforPK(PayforPK payforPK) {
        this.payforPK = payforPK;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
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
        hash += (payforPK != null ? payforPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payfor)) {
            return false;
        }
        Payfor other = (Payfor) object;
        if ((this.payforPK == null && other.payforPK != null) || (this.payforPK != null && !this.payforPK.equals(other.payforPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Payfor[ payforPK=" + payforPK + " ]";
    }
    
}
