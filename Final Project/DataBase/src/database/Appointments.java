/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
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
@Table(name = "appointments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointments.findAll", query = "SELECT a FROM Appointments a")
    , @NamedQuery(name = "Appointments.findByAppid", query = "SELECT a FROM Appointments a WHERE a.appid = :appid")
    , @NamedQuery(name = "Appointments.findByStartHour", query = "SELECT a FROM Appointments a WHERE a.startHour = :startHour")
    , @NamedQuery(name = "Appointments.findByEndHour", query = "SELECT a FROM Appointments a WHERE a.endHour = :endHour")
    , @NamedQuery(name = "Appointments.findByDay", query = "SELECT a FROM Appointments a WHERE a.day = :day")})
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appid")
    private Integer appid;
    @Column(name = "startHour")
    private String startHour;
    @Column(name = "endHour")
    private String endHour;
    @Column(name = "day")
    private String day;
    @JoinColumn(name = "sectionId", referencedColumnName = "sectionId")
    @ManyToOne
    private Sections sectionId;
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    @ManyToOne
    private Classroom roomId;

    public Appointments() {
    }

    public Appointments(Integer appid) {
        this.appid = appid;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Sections getSectionId() {
        return sectionId;
    }

    public void setSectionId(Sections sectionId) {
        this.sectionId = sectionId;
    }

    public Classroom getRoomId() {
        return roomId;
    }

    public void setRoomId(Classroom roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appid != null ? appid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointments)) {
            return false;
        }
        Appointments other = (Appointments) object;
        if ((this.appid == null && other.appid != null) || (this.appid != null && !this.appid.equals(other.appid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Appointments[ appid=" + appid + " ]";
    }
    
}
