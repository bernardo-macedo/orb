/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_OwnerFacadeLocal;
import com.orb.entities.ORB_Owner;
import com.orb.entities.ORB_Property;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author -Bernardo
 */
@Named(value = "ownerController")
@SessionScoped
public class OwnerController implements Serializable {

    @EJB
    private ORB_OwnerFacadeLocal ownerFacade;
    
    @ManagedProperty(value = "#{propertyController}")
    private PropertyController propertyController;
    
    @ManagedProperty(value = "#{userController}")
    private UserController userController;
    
    private ORB_Owner owner;
    
    private String ownerUsername;
    
    private List<ORB_Property> properties = null;
    private boolean anyProperties = false;
    private boolean noProperties = true;

    /**
     * Creates a new instance of OwnerController
     */
    public OwnerController() {}
    
    /*@PostConstruct
    public void init() {
        owner = ownerFacade.find(userController.getUser().getId());
    }*/

    public boolean isAnyProperties() {
        return anyProperties;
    }

    public void setAnyProperties(boolean anyProperties) {
        this.anyProperties = anyProperties;
    }

    public boolean isNoProperties() {
        return noProperties;
    }

    public void setNoProperties(boolean noProperties) {
        this.noProperties = noProperties;
    }

    public List<ORB_Property> getProperties() {
        return properties;
    }

    public void setProperties(List<ORB_Property> properties) {
        this.properties = properties;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }
    
    public ORB_Owner getOwner() {
        return owner;
    }

    public void setOwner(ORB_Owner owner) {
        this.owner = owner;
    }
    public PropertyController getPropertyController() {
        return propertyController;
    }

    public void setPropertyController(PropertyController propertyController) {
        this.propertyController = propertyController;
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
    
    public void retrieveOwner() {
        userController = new UserController();
        userController.setUsername(ownerUsername);
        userController.retrieveUser();
        owner = ownerFacade.find(userController.getUser().getId());
    }
    
    public List<ORB_Property> retrieveOwnerProperties() {
        return owner.getProperties();
    }
    
    public void updateProperty() {
        //chama a updateproperty do property controller
    }
    
    public void deleteProperty() {
        //chama a delete property do property controller
    }
    
}
