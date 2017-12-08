/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "nutritionist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nutritionist.findAll", query = "SELECT n FROM Nutritionist n")
    , @NamedQuery(name = "Nutritionist.findByNutId", query = "SELECT n FROM Nutritionist n WHERE n.nutId = :nutId")
    , @NamedQuery(name = "Nutritionist.findByNutName", query = "SELECT n FROM Nutritionist n WHERE n.nutName = :nutName")
    , @NamedQuery(name = "Nutritionist.findByPassword", query = "SELECT n FROM Nutritionist n WHERE n.password = :password")
    , @NamedQuery(name = "Nutritionist.findByGender", query = "SELECT n FROM Nutritionist n WHERE n.gender = :gender")
    , @NamedQuery(name = "Nutritionist.findByEmail", query = "SELECT n FROM Nutritionist n WHERE n.email = :email")
    , @NamedQuery(name = "Nutritionist.findByDateOfBirth", query = "SELECT n FROM Nutritionist n WHERE n.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Nutritionist.findByRank", query = "SELECT n FROM Nutritionist n WHERE n.rank = :rank")
    , @NamedQuery(name = "Nutritionist.findByHireDate", query = "SELECT n FROM Nutritionist n WHERE n.hireDate = :hireDate")
    , @NamedQuery(name = "Nutritionist.findByExperience", query = "SELECT n FROM Nutritionist n WHERE n.experience = :experience")
    , @NamedQuery(name = "Nutritionist.findByCertificates", query = "SELECT n FROM Nutritionist n WHERE n.certificates = :certificates")})
public class Nutritionist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nutId")
    private Integer nutId;
    @Column(name = "nutName")
    private String nutName;
    @Column(name = "password")
    private String password;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "rank")
    private String rank;
    @Column(name = "hireDate")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Column(name = "experience")
    private Integer experience;
    @Column(name = "certificates")
    private String certificates;
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @ManyToOne
    private Addresses addressId;

    public Nutritionist() {
    }

    public Nutritionist(Integer nutId) {
        this.nutId = nutId;
    }

    public Integer getNutId() {
        return nutId;
    }

    public void setNutId(Integer nutId) {
        this.nutId = nutId;
    }

    public String getNutName() {
        return nutName;
    }

    public void setNutName(String nutName) {
        this.nutName = nutName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public Addresses getAddressId() {
        return addressId;
    }

    public void setAddressId(Addresses addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nutId != null ? nutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nutritionist)) {
            return false;
        }
        Nutritionist other = (Nutritionist) object;
        if ((this.nutId == null && other.nutId != null) || (this.nutId != null && !this.nutId.equals(other.nutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Nutritionist[ nutId=" + nutId + " ]";
    }
    
}
