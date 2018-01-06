/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "User.findByJoinedDate", query = "SELECT u FROM User u WHERE u.joinedDate = :joinedDate")})
public class User implements Serializable {

    @Column(name = "isEmp")
    private Boolean isEmp;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private Boolean gender;
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "joinedDate")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @OneToMany(mappedBy = "userid")
    private Collection<Employee> employeeCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Customers> customersCollection;
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @ManyToOne
    private Addresses addressId;

    public static User mainUser;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String password) throws SQLException, ClassNotFoundException {
        this.userId = userId;
        this.password = password;
        String sql = "select * from user as u where u.userid =  " + userId + " and u.password  = '" + password + "' ";
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql);

    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws SQLException, ClassNotFoundException {
        String sql = "update table user where userId =  " + userId + " set name = " + name;
        DatabaseAPI db = new DatabaseAPI();
        db.write(sql);
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password, String oldpass) throws SQLException, ClassNotFoundException {
        String sql = "select * from user as u  where u.userId =  " + userId + " and u.password  = '" + oldpass + "'";
        DatabaseAPI db = new DatabaseAPI();
        ResultSet s = db.read(sql);
        if (s.next()) {
            this.password = password;
            String sql1 = "update table user where userId =  " + userId + " set dateofBirth = " + dateOfBirth;
            db.write(sql1);
            return true;
        }
        return false;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws SQLException, ClassNotFoundException {
        this.email = email;
        String sql = "update table user where userId =  " + userId + " set email = " + email;
        DatabaseAPI db = new DatabaseAPI();

        db.write(sql);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) throws SQLException, ClassNotFoundException {
        this.dateOfBirth = dateOfBirth;
        String sql = "update table user where userId =  " + userId + " set dateofBirth = " + dateOfBirth;
        DatabaseAPI db = new DatabaseAPI();

        db.write(sql);
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }

    public Addresses getAddressId() {
        return addressId;
    }

    public void setAddressId(Addresses addressId) throws SQLException, ClassNotFoundException {
        this.addressId = addressId;
        String sql1 = "select * from addresses where addressid =  " + addressId;
        DatabaseAPI db = new DatabaseAPI();
        ResultSet set = db.read(sql1);

        if (set.next()) {
            String sql = "update table user where userId =  " + userId + " set addressId = " + addressId;
            db.write(sql);
        }

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.User[ userId=" + userId + " ]";
    }

    public Boolean getIsEmp() {
        return isEmp;
    }

}
