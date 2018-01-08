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

    public static void addNewPay(Membership mem, Customers cus, double cost) throws SQLException, ClassNotFoundException {
		String sql = "insert into memcus values (" + mem.getMemId() + " , " + cus.getCusid() + " , " + cost + " ,'"

                        + LocalDateTime.now() + " )";
		DatabaseAPI db = new DatabaseAPI();
		db.write(sql);
                

		

	}
   
    
}
