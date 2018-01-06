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
import javax.persistence.CascadeType;
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
@Table(name = "membership")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membership.findAll", query = "SELECT m FROM Membership m")
    , @NamedQuery(name = "Membership.findByMemId", query = "SELECT m FROM Membership m WHERE m.memId = :memId")
    , @NamedQuery(name = "Membership.findByMemName", query = "SELECT m FROM Membership m WHERE m.memName = :memName")})
public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "memId")
    private Integer memId;
    @Basic(optional = false)
    @Column(name = "memName")
    private String memName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membership")
    private Collection<Memcus> memcusCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membership")
    private Collection<Payfor> payforCollection;

    public Membership() {
    }

    public Membership(Integer memId) {
        this.memId = memId;
    }

    public Membership(Integer memId, String memName) {
        this.memId = memId;
        this.memName = memName;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) throws SQLException, ClassNotFoundException {
        this.memName = memName;
        DatabaseAPI db = new DatabaseAPI();
         String sql = "update table membership where memId =  " + this.memId + " set memName = " +memName;
         db.write(sql);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memId != null ? memId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membership)) {
            return false;
        }
        Membership other = (Membership) object;
        if ((this.memId == null && other.memId != null) || (this.memId != null && !this.memId.equals(other.memId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Membership[ memId=" + memId + " ]";
    }
    public static void addNewMemType(String name) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO membership values ( null , '" + name + "' );";
                DatabaseAPI db = new DatabaseAPI();
                db.write(sql);
	}
    
    
}
