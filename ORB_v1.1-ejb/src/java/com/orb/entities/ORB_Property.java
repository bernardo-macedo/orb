/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author -Bernardo
 */
@Entity
public class ORB_Property implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
    @NotNull
    private String address = null;
    @NotNull
    private int bedroomsNumber;
    @NotNull
    private int bathroomsNumber;
    @NotNull
    private int othersNumber;
    @NotNull
    private double rent;
    @NotNull
    private boolean deleted = false;
    @NotNull
    private boolean rented = false;
    @ManyToOne
    @NotNull
    private ORB_Location location = null;
    @ManyToOne
    @NotNull
    private ORB_TypeOfProperty typeOfProperty = null;
    @ManyToOne
    @NotNull
    private ORB_Owner owner = null;
    @ManyToMany(mappedBy = "visitingList")
    private Set<ORB_Customer> interestedCustomers = null;

    public ORB_Owner getOwner() {
        return owner;
    }

    public void setOwner(ORB_Owner owner) {
        this.owner = owner;
    }

    public Set<ORB_Customer> getInterestedCustomers() {
        return interestedCustomers;
    }

    public void setInterestedCustomers(Set<ORB_Customer> interestedCustomers) {
        this.interestedCustomers = interestedCustomers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedroomsNumber() {
        return bedroomsNumber;
    }

    public void setBedroomsNumber(int bedroomsNumber) {
        this.bedroomsNumber = bedroomsNumber;
    }

    public int getBathroomsNumber() {
        return bathroomsNumber;
    }

    public void setBathroomsNumber(int bathroomsNumber) {
        this.bathroomsNumber = bathroomsNumber;
    }

    public int getOthersNumber() {
        return othersNumber;
    }

    public void setOthersNumber(int othersNumber) {
        this.othersNumber = othersNumber;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public ORB_Location getLocation() {
        return location;
    }

    public void setLocation(ORB_Location location) {
        this.location = location;
    }

    public ORB_TypeOfProperty getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(ORB_TypeOfProperty typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
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
        if (!(object instanceof ORB_Property)) {
            return false;
        }
        ORB_Property other = (ORB_Property) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orb.entities.Property[ id=" + id + " ]";
    }
    
}
