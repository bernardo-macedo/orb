/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_PropertyFacadeLocal;
import com.orb.entities.ORB_Property;
import java.io.Serializable;
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
    /**
     * Creates a new instance of PropertyController
     */
    public PropertyController() {}

    public ORB_Property getProperty() {
        return property;
    }

    public void setProperty(ORB_Property property) {
        this.property = property;
    }
    
    public boolean addProperty(ORB_Property property) {
        try {
            propertyFacade.create(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean updateProperty(ORB_Property property) {
        try {
            propertyFacade.edit(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteProperty(ORB_Property property) {
        try {
            property.setDeleted(true);
            propertyFacade.edit(property);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
