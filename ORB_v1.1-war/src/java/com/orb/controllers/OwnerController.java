/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_OwnerFacadeLocal;
import com.orb.ejb.ORB_UserSessionFacadeLocal;
import com.orb.entities.ORB_Owner;
import com.orb.entities.ORB_Property;
import com.orb.entities.ORB_UserSession;
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
    
    @EJB
    private ORB_UserSessionFacadeLocal sessionFacade;
    
    @ManagedProperty(value = "#{userController}")
    private UserController userController;
    
    private ORB_Owner owner;
    
    private String ownerUsername;

    /**
     * Creates a new instance of OwnerController
     */
    public OwnerController() {}
    
    @PostConstruct
    public void init() {
        //owner = ownerFacade.find(userController.getUser().getId());
        owner = ownerFacade.find(sessionFacade.getCurrentSession().getUser().getId());
        System.out.println("Owner Controller Initialized");
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }
    
    public ORB_Owner getOwner() {
        if (owner == null) {
            ORB_UserSession session = sessionFacade.getCurrentSession(); 
            owner = ownerFacade.find(session.getUser().getId());
        }
        return owner;
    }

    public void setOwner(ORB_Owner owner) {
        this.owner = owner;
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
    
}
