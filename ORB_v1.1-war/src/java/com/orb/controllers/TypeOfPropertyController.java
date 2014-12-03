/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_TypeOfPropertyFacadeLocal;
import com.orb.entities.ORB_TypeOfProperty;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author RenataCristina
 */
@Named(value = "typeOfPropertyController")
@RequestScoped
public class TypeOfPropertyController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ORB_TypeOfPropertyFacadeLocal typeFacade;

    /**
     * Creates a new instance of TypeOfPropertyController
     */
    public TypeOfPropertyController() {
    }
    
    public ORB_TypeOfProperty findTypeByName(String name) {
        return typeFacade.findTypeByName(name);
    }  
    
}
