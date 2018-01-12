/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

    @Column(name = "paydate")
    @Temporal(TemporalType.DATE)
    private Date paydate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
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


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) throws SQLException, ClassNotFoundException {
        this.startDate = startDate;
        String sql = "update  memcus set startDate = " + startDate + " where memid = " +this.membership.getMemId()+" and cusid = "+this.customers.getCusid() ;
        DatabaseAPI db = new DatabaseAPI();
        db.write(sql);
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) throws SQLException, ClassNotFoundException {
        this.endDate = endDate;
        String sql = "update  memcus set endDate = " + startDate + " where memid = " +this.membership.getMemId()+" and cusid = "+this.customers.getCusid() ;
        DatabaseAPI db = new DatabaseAPI();
        db.write(sql);
        
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
 
    public static void add(int cusId, int memId, java.sql.Date startDate, double cost) throws SQLException, ClassNotFoundException {
        DatabaseAPI db = new DatabaseAPI();
        String sql = "insert into memcus values (" + memId + "," + cusId + " , '" + startDate + "' , " + cost + ")";
        db.write(sql);

    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

   
    
}
