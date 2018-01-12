/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Panels.DatabaseAPI;
import static database.Customers_.cusid;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "medicalsituation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicalsituation.findAll", query = "SELECT m FROM Medicalsituation m")
    , @NamedQuery(name = "Medicalsituation.findByMedicalSituation", query = "SELECT m FROM Medicalsituation m WHERE m.medicalSituation = :medicalSituation")
    , @NamedQuery(name = "Medicalsituation.findByDiseases", query = "SELECT m FROM Medicalsituation m WHERE m.diseases = :diseases")
    , @NamedQuery(name = "Medicalsituation.findByWeight", query = "SELECT m FROM Medicalsituation m WHERE m.weight = :weight")
    , @NamedQuery(name = "Medicalsituation.findByMeasurment", query = "SELECT m FROM Medicalsituation m WHERE m.measurment = :measurment")})
public class Medicalsituation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicalsituation")
    private Integer medicalsituation;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "medicalSituation")
    private Integer medicalSituation;
    @Column(name = "diseases")
    private String diseases;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "weight")
    private Double weight;
    @Column(name = "measurment")
    private String measurment;
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    @ManyToOne
    private Employee empId;
    @JoinColumn(name = "cusId", referencedColumnName = "cusid")
    @ManyToOne
    private Customers cusId;

    public Medicalsituation() {
    }

    public Medicalsituation(Integer medicalSituation) {
        this.medicalSituation = medicalSituation;
    }

    public Integer getMedicalSituation() {
        return medicalSituation;
    }

    public void setMedicalSituation(Integer medicalSituation) {
        this.medicalSituation = medicalSituation;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) throws SQLException, ClassNotFoundException {
        this.weight = weight;
        String sql = "update  medicalSituation set weight = " + weight + " where programId = " + this.medicalSituation;
        DatabaseAPI db = new DatabaseAPI();
        db.write(sql);

    }

    public String getMeasurment() {
        return measurment;
    }

    public void setMeasurment(String measurment) throws SQLException, ClassNotFoundException {
        this.measurment = measurment;
        String sql = "update  medicalSituation set measurment = " + measurment + " where programId = " + this.medicalSituation;
        DatabaseAPI db = new DatabaseAPI();
        db.write(sql);

    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
    }

    public Customers getCusId() {
        return cusId;
    }

    public void setCusId(Customers cusId) {
        this.cusId = cusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalSituation != null ? medicalSituation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalsituation)) {
            return false;
        }
        Medicalsituation other = (Medicalsituation) object;
        if ((this.medicalSituation == null && other.medicalSituation != null) || (this.medicalSituation != null && !this.medicalSituation.equals(other.medicalSituation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Medicalsituation[ medicalSituation=" + medicalSituation + " ]";
    }

    public static int addToMedical(Customers cus, Employee emp) throws SQLException, ClassNotFoundException {
        String sql = " insert into Medicalsituation (cusId, empId) Values  ( " + cus.getCusid() + " ," + emp.getEmpId() + ")";
        DatabaseAPI db = new DatabaseAPI();
         int ide = 0;
        ide=db.write(sql);
        
        return ide;

    }

   

    public Integer getMedicalsituation() {
        return medicalsituation;
    }

    public void setMedicalsituation(Integer medicalsituation) {
        this.medicalsituation = medicalsituation;
    }

   
   

   
}
