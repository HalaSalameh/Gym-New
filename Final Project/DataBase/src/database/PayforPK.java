/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author dell
 */
@Embeddable
public class PayforPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "memId")
    private int memId;
    @Basic(optional = false)
    @Column(name = "cusId")
    private int cusId;

    public PayforPK() {
    }

    public PayforPK(int memId, int cusId) {
        this.memId = memId;
        this.cusId = cusId;
    }

    public int getMemId() {
        return memId;
    }

    public void setMemId(int memId) {
        this.memId = memId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) memId;
        hash += (int) cusId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayforPK)) {
            return false;
        }
        PayforPK other = (PayforPK) object;
        if (this.memId != other.memId) {
            return false;
        }
        if (this.cusId != other.cusId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.PayforPK[ memId=" + memId + ", cusId=" + cusId + " ]";
    }
    
}
