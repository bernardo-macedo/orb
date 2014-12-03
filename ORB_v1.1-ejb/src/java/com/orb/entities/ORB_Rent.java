/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.entities;

import com.orb.persistence.RentListener;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author -Bernardo
 */
@Entity
@EntityListeners({RentListener.class})
public class ORB_Rent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String email = null;
    @NotNull
    private double rent;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar rentedTimeStamp = null;
    @OneToOne
    @NotNull
    private ORB_Customer customer = null;
    @OneToOne
    @NotNull
    private ORB_Property property = null;

    public ORB_Customer getCustomer() {
        return customer;
    }

    public void setCustomer(ORB_Customer customer) {
        this.customer = customer;
    }

    public ORB_Property getProperty() {
        return property;
    }

    public void setProperty(ORB_Property property) {
        this.property = property;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public Calendar getRentedTimeStamp() {
        return rentedTimeStamp;
    }

    public void setRentedTimeStamp(Calendar rentedTimeStamp) {
        this.rentedTimeStamp = rentedTimeStamp;
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
        if (!(object instanceof ORB_Rent)) {
            return false;
        }
        ORB_Rent other = (ORB_Rent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orb.entities.Rent[ id=" + id + " ]";
    }
    
}
