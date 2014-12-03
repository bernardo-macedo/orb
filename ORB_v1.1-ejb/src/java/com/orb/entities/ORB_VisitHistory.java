/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author -Bernardo
 */
@Entity
public class ORB_VisitHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private ORB_Property property = null;
    @NotNull
    private int month_period;
    @NotNull
    private int year_period;
    @NotNull
    private int visitsNumber;

    public ORB_Property getProperty() {
        return property;
    }

    public void setProperty(ORB_Property property) {
        this.property = property;
    }

    public int getMonth() {
        return month_period;
    }

    public void setMonth(int month) {
        this.month_period = month;
    }

    public int getYear() {
        return year_period;
    }

    public void setYear(int year) {
        this.year_period = year;
    }

    public int getVisitsNumber() {
        return visitsNumber;
    }

    public void setVisitsNumber(int visitsNumber) {
        this.visitsNumber = visitsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof ORB_VisitHistory)) {
            return false;
        }
        ORB_VisitHistory other = (ORB_VisitHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orb.entities.VisitHistory[ id=" + id + " ]";
    }
    
}
