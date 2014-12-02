/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.UserFacadeLocal;
import com.orb.entities.ORB_User;
import java.io.Serializable;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author -Bernardo
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private UserFacadeLocal userFacade;
    private ORB_User user;
    /**
     * Creates a new instance of UserController
     */
    public UserController() {}

    public ORB_User getUser() {
        return user;
    }

    public void setUser(ORB_User user) {
        this.user = user;
    }
    
    public void addUser() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (!userFacade.isUsernameAlreadyRegistered("username")) {
            ORB_User user = new ORB_User();
            user.setGivenName("Given name");
            user.setLastName("Last name");
            user.setUsername("username");
            user.setEmail("email@email");
            user.setPassword("password");
            user.setTypeOfAccount("customer");
            user.setCreationTimeStamp(Calendar.getInstance());
            userFacade.create(user);
            System.out.println("created");
        } else {
            System.out.println("This user is already registered");
        }
    }
    
    public void retrieveUser() {
        user = userFacade.findByEmail("email@email.com");
    }
    
    public void removeUser() {
        if (user != null) {
            userFacade.remove(user);
            user = null;
        }
    }
    
}
