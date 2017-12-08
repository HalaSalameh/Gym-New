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
@Table(name = "coach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coach.findAll", query = "SELECT c FROM Coach c")
    , @NamedQuery(name = "Coach.findByCoachId", query = "SELECT c FROM Coach c WHERE c.coachId = :coachId")
    , @NamedQuery(name = "Coach.findByCoachNamr", query = "SELECT c FROM Coach c WHERE c.coachNamr = :coachNamr")
    , @NamedQuery(name = "Coach.findByPassword", query = "SELECT c FROM Coach c WHERE c.password = :password")
    , @NamedQuery(name = "Coach.findByGender", query = "SELECT c FROM Coach c WHERE c.gender = :gender")
    , @NamedQuery(name = "Coach.findByEmail", query = "SELECT c FROM Coach c WHERE c.email = :email")
    , @NamedQuery(name = "Coach.findByDateOfBirth", query = "SELECT c FROM Coach c WHERE c.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Coach.findByRank", query = "SELECT c FROM Coach c WHERE c.rank = :rank")
    , @NamedQuery(name = "Coach.findByHireDate", query = "SELECT c FROM Coach c WHERE c.hireDate = :hireDate")
    , @NamedQuery(name = "Coach.findByExperience", query = "SELECT c FROM Coach c WHERE c.experience = :experience")
    , @NamedQuery(name = "Coach.findByAbilities", query = "SELECT c FROM Coach c WHERE c.abilities = :abilities")
    , @NamedQuery(name = "Coach.findByCertificates", query = "SELECT c FROM Coach c WHERE c.certificates = :certificates")})
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coachId")
    private Integer coachId;
    @Column(name = "coachNamr")
    private String coachNamr;
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
    @Column(name = "abilities")
    private String abilities;
    @Column(name = "certificates")
    private String certificates;
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    @ManyToOne
    private Addresses addressId;

    public Coach() {
    }

    public Coach(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachNamr() {
        return coachNamr;
    }

    public void setCoachNamr(String coachNamr) {
        this.coachNamr = coachNamr;
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

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
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
        hash += (coachId != null ? coachId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coach)) {
            return false;
        }
        Coach other = (Coach) object;
        if ((this.coachId == null && other.coachId != null) || (this.coachId != null && !this.coachId.equals(other.coachId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Coach[ coachId=" + coachId + " ]";
    }
    
}
