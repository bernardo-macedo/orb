/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_OwnerFacadeLocal;
import com.orb.ejb.UserFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
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

    /**
     * Creates a new instance of OwnerController
     */
    public OwnerController() {}
    
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
    
    

    
    
}
