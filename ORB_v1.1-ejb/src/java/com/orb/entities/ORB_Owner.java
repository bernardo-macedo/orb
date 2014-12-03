/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author -Bernardo
 */
@Entity
public class ORB_Owner extends ORB_User {
    
    @OneToMany(mappedBy = "owner")
    private List<ORB_Property> properties = null;

    public List<ORB_Property> getProperties() {
        return properties;
    }

    public void setProperties(List<ORB_Property> properties) {
        this.properties = properties;
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
        if (!(object instanceof ORB_Owner)) {
            return false;
        }
        ORB_Owner other = (ORB_Owner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orb.entities.Owner[ id=" + id + " ]";
    }
    
}
