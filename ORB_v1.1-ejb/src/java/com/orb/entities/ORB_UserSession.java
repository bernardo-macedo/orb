/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.entities;

import static com.orb.entities.ORB_Property_.id;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author -Bernardo
 */
@Entity
public class ORB_UserSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String cookieId;
    private ORB_User orb_user;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar lastVisit;
    private int hits;

    
    public ORB_UserSession() {
        // Default
    }
    
    public ORB_UserSession(String cookieId) {
        this.cookieId = cookieId;
        this.creationDate = Calendar.getInstance();
        this.lastVisit = Calendar.getInstance();
    }

    public String getCookieId() {
        return cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public ORB_User getUser() {
        return orb_user;
    }

    public void setUser(ORB_User user) {
        this.orb_user = user;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public Calendar getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Calendar lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
    
    public void addHit() {
        this.hits++;
        this.lastVisit = Calendar.getInstance();
    }

    public boolean isLoggedIn() {
        return orb_user != null;
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
        if (!(object instanceof ORB_UserSession)) {
            return false;
        }
        ORB_UserSession other = (ORB_UserSession) object;
        if ((this.cookieId == null && other.cookieId != null) || (this.cookieId != null && !this.cookieId.equals(other.cookieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orb.entities.ORB_UserSession[ id=" + cookieId + " ]";
    }
    
}
