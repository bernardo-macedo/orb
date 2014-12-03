/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_PropertyFacadeLocal;
import com.orb.entities.ORB_Property;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author RenataCristina
 */
@Named(value = "propertyController")
@RequestScoped
public class PropertyController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ORB_PropertyFacadeLocal propertyFacade;
    private ORB_Property property;
    
    private Long propertyId;
    private Long locationId;
    private Long typeId;
    private int number;
    private double minRent;
    private double maxRent;
            
            
    /**
     * Creates a new instance of PropertyController
     */
    public PropertyController() {}

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
    
    public ORB_Property getProperty() {
        return property;
    }

    public void setProperty(ORB_Property property) {
        this.property = property;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getMinRent() {
        return minRent;
    }

    public void setMinRent(double minRent) {
        this.minRent = minRent;
    }

    public double getMaxRent() {
        return maxRent;
    }

    public void setMaxRent(double maxRent) {
        this.maxRent = maxRent;
    }    
    
    public boolean addProperty() {
        try {
            propertyFacade.create(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean updateProperty() {
        try {
            propertyFacade.edit(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteProperty() {
        try {
            property.setDeleted(true);
            propertyFacade.edit(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public ORB_Property findPropertyById() {
        return propertyFacade.find(propertyId);
    }

    public List<ORB_Property> findPropertyByLocation() {
        return propertyFacade.findPropertyByLocation(locationId);
    }

    public List<ORB_Property> findPropertyByType() {
        return propertyFacade.findPropertyByType(typeId);
    }

    public List<ORB_Property> findPropertyByNumberOfBedrooms() {
        return propertyFacade.findPropertyByNumberOfBedrooms(number);
    }

    public List<ORB_Property> findPropertyByNumberOfBathrooms() {
        return propertyFacade.findPropertyByNumberOfBathrooms(number);
    }

    public List<ORB_Property> findPropertyByMinimumRent() {
        return propertyFacade.findPropertyByMinimumRent(minRent);
    }

    public List<ORB_Property> findPropertyByMaximumRent() {
        return propertyFacade.findPropertyByMaximumRent(maxRent);
    }
    
}
