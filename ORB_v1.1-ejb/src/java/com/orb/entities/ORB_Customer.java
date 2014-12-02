/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author -Bernardo
 */
@Entity
public class ORB_Customer extends ORB_User {

    @NotNull
    private double maxRent;
    @NotNull
    private boolean renting;
    @ManyToMany
    @JoinTable(name="VisitingList")
    private Set<ORB_Property> visitingList = null;

    public Set<ORB_Property> getVisitingList() {
        return visitingList;
    }

    public void setVisitingList(Set<ORB_Property> visitingList) {
        this.visitingList = visitingList;
    }

    public double getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(double maxRent) {
        this.maxRent = maxRent;
    }

    public boolean isRenting() {
        return renting;
    }

    public void setRenting(boolean renting) {
        this.renting = renting;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ORB_Customer)) {
            return false;
        }
        ORB_Customer other = (ORB_Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orb.entities.Customer[ id=" + id + " ]";
    }
    
}
