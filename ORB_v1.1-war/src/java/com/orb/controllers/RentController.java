/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orb.controllers;

import com.orb.ejb.ORB_RentFacadeLocal;
import com.orb.entities.ORB_Rent;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author RenataCristina
 */
@Named(value = "rentController")
@RequestScoped
public class RentController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private ORB_RentFacadeLocal rentFacade;
    private ORB_Rent rent;

    /**
     * Creates a new instance of RentController
     */
    public RentController() {}
    
    public boolean addRent() {
        try {
            rentFacade.create(rent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean updateRent() {
        try {
            rentFacade.edit(rent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
        
    public boolean deleteRent() {
        try {
            rentFacade.remove(rent);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
