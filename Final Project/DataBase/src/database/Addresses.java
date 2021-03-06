/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import static database.User_.userId;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@Table(name = "addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a")
    , @NamedQuery(name = "Addresses.findByAddressId", query = "SELECT a FROM Addresses a WHERE a.addressId = :addressId")
    , @NamedQuery(name = "Addresses.findByBuilding", query = "SELECT a FROM Addresses a WHERE a.building = :building")
    , @NamedQuery(name = "Addresses.findByCity", query = "SELECT a FROM Addresses a WHERE a.city = :city")
    , @NamedQuery(name = "Addresses.findByStreet", query = "SELECT a FROM Addresses a WHERE a.street = :street")})
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "addressId")
    private Integer addressId;
    @Column(name = "building")
    private String building;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @OneToMany(mappedBy = "addressId")
    private Collection<User> userCollection;

    public Addresses() {
    }

    public Addresses(Integer addressId) throws SQLException, ClassNotFoundException {
        String sql = "select * from Addresses as u where u.addressid =  " + addressId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);
        while (set.next()) {
            this.addressId = addressId;
            this.building = set.getString(2);
            this.city = set.getString(3);
            this.street = set.getString(4);
        }
        
        System.out.println(this.addressId);
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) throws SQLException, ClassNotFoundException {
        this.building = building;
        DatabaseAPI db = new DatabaseAPI();
        String sql = "update table programs where addressid =  " + this.addressId + " set building = " + building;
        db.write(sql);
     
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws SQLException, ClassNotFoundException {
        this.city = city;
        DatabaseAPI db = new DatabaseAPI();
        String sql = "update table programs where addressid =  " + this.addressId + " set city = " + city;
        db.write(sql);
        
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws SQLException, ClassNotFoundException {
        this.street = street;
        DatabaseAPI db = new DatabaseAPI();
        String sql = "update table programs where addressid =  " + this.addressId + " set street = " + street;
        db.write(sql);
    
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.city + " / " + this.street + " / " + this.building + "/ " + this.street;
    }

    public static int addAddress(String city, String street, String building) throws SQLException, ClassNotFoundException {
        DatabaseAPI db = new DatabaseAPI();
        String sql = "insert into Addresses values (null, '" + building + "' , '" + city + "' , '" + street + "' )";
        System.out.println(sql);
        int f=db.write(sql); 
        return f;
    }

}
